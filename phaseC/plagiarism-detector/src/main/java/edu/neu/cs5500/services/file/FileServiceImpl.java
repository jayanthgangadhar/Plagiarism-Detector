package edu.neu.cs5500.services.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.comparisonEngine.strategy.FileComparisonEngine;
import edu.neu.cs5500.controllers.UserController;
import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.ReportComparator;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;
import edu.neu.cs5500.utils.Constants;

@Service("fileService")
public class FileServiceImpl implements FileService{


	// Logger
	private static Logger logger = Logger.getLogger(FileServiceImpl.class.getName());

	@Autowired 
	private StorageService storageService;
	@Autowired 
	private FileService fileService;

	@Autowired
	private S3Services s3Service;

	@Autowired
	private ReportService reportService;


	@Autowired
	private UserService userService;
	/* (non-Javadoc)
	 * @see edu.neu.cs5500.services.file.FileService#compareTwoFiles(java.io.File, java.io.File)
	 */
	@Override
	public Report compareTwoFiles(File file1, File file2, Double threshold) throws FileNotFoundException, IOException {
		FileComparisonEngine f = new FileComparisonEngine();
		return f.weightedCompare(file1, file2, threshold);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.services.file.FileService#compareTwoFolders(org.springframework.web.multipart.MultipartFile[], org.springframework.web.multipart.MultipartFile[], java.lang.String)
	 */
	@Override
	public String compareTwoFolders(MultipartFile[] fileList1, MultipartFile[] fileList2, String userID, String student1Id, String student2Id) {
		List<Report> reportList = new ArrayList<Report>();
		String operationIdGenerated = null;

		try {


			storageService.init(userID);
			User currentUser = userService.findUserById(userID);
			Double threshold = currentUser.getThreshold()!=null?currentUser.getThreshold():Constants.PLAG_THRESHOLD;
			StudentCompareResult spr = new StudentCompareResult();
			spr.setStudent1Id(student1Id);
			spr.setStudent2Id(student2Id);		
			spr.setComparisonType("FOLDER");
			Double maxSimilarity = -1.0;
			for (int i = 0; i < fileList1.length; i++) {
				Long file1Path = System.currentTimeMillis();

				for (int j = 0; j < fileList2.length; j++) {

					File file1 = storageService.store(fileList1[i],student1Id);
					File file2 = storageService.store(fileList2[j],student2Id);

					logger.info("Files getting compared:>"+ file1.getName() +"  " + file2.getName());
					Long file2Path = System.currentTimeMillis();
					Report result = fileService.compareTwoFiles(file1, file2, threshold);
					if (result == null) {
						throw new Exception("Comparison Failed!");
					}


					String f1 = s3Service.uploadFile(file1Path.toString()+".py", file1);
					if (Constants.SUCCESS.equals(f1)) {
						result.setFile1Path(file1Path.toString()+".py");
					}

					String f2 =  s3Service.uploadFile(file2Path.toString()+".py", file2);

					if (Constants.SUCCESS.equals(f2)) {
						result.setFile2Path(file2Path.toString()+".py");
					}

					storageService.deleteFile(file1);
					storageService.deleteFile(file2);


					if (result != null) {
						
						reportList.add(result);	
						if (result.getAverageScore()>= threshold) {
							spr.setPlagiarismExists(Constants.YES);
						}
						if (maxSimilarity<=result.getAverageScore()) {
							maxSimilarity=result.getAverageScore();
						}

					}
				}
			}
			Collections.sort(reportList, new ReportComparator());
			spr.setReports(reportList);
			spr.setMaxSimilarityInAnyTwoFiles(maxSimilarity.toString());
			List<StudentCompareResult> lspr = new ArrayList<StudentCompareResult>();
			lspr.add(spr);

			Operation op = new Operation();

			op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
			op.setOperationType("FOLDER");		
			op.setStudentResult(lspr);
			op.setUserId(userID);
			op.setInitiatedBy("User");

			// add data to DB

			operationIdGenerated = reportService.saveOperation(op);

			if (operationIdGenerated == null) {
				throw new Exception("Error while save the operation");
			}


		}catch(Exception e) {
			logger.log(Level.SEVERE, "Error Occurred while Comparison of folders", e);
		}finally {
			storageService.deleteAll();
		}

		return operationIdGenerated;
	}



	/* (non-Javadoc)
	 * @see edu.neu.cs5500.services.file.FileService#compareTwoTexts(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Report compareTwoTexts(String file1Text, String file2Text, String userID, String student1Id, String student2Id) {

		storageService.init(userID);
		User currentUser = userService.findUserById(userID);
		File file1 = storageService.createFile("text1", file1Text);
		File file2 = storageService.createFile("text2", file2Text);
		Report result = null;
		Double threshold = currentUser.getThreshold()!=null?currentUser.getThreshold():Constants.PLAG_THRESHOLD;
		try {
			result = fileService.compareTwoFiles(file1, file2, threshold);
			if (result == null) {
				throw new Exception("Comparison Failed!");
			}

			Long file1Path = System.currentTimeMillis();
			String f1 = s3Service.uploadFile(file1Path.toString()+".py", file1);
			if (Constants.SUCCESS.equals(f1)) {
				result.setFile1Path(Constants.S3URL+file1Path.toString()+".py");
			}else {
				throw new Exception();
			}

			Long file2Path = System.currentTimeMillis();
			String f2 =  s3Service.uploadFile(file2Path.toString()+".py", file2);

			if (Constants.SUCCESS.equals(f2)) {
				result.setFile2Path(Constants.S3URL+file2Path.toString()+".py");
			}else {
				throw new Exception("upload failed");
			}

			// Now save this operation in DB
			StudentCompareResult spr = new StudentCompareResult();

			spr.setStudent1Id(student1Id);
			spr.setStudent2Id(student2Id);		
			spr.setComparisonType("FILE");

			spr.setMaxSimilarityInAnyTwoFiles(result.getAverageScore().toString());

			

			if (result.getAverageScore() >= threshold) {
				spr.setPlagiarismExists(Constants.YES);
			}


			List<Report> list = new ArrayList<Report>();
			list.add(result);		
			spr.setReports(list);

			List<StudentCompareResult> lspr = new ArrayList<StudentCompareResult>();
			lspr.add(spr);

			Operation op = new Operation();
			op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

			op.setOperationType("FILE");		
			op.setStudentResult(lspr);
			op.setUserId(userID);
			op.setInitiatedBy("User");

			// add data to DB

			String saveResult = reportService.saveOperation(op);

			if (saveResult == null) {
				throw new Exception("Error while save the operation");
			}


		}catch (Exception e) {
			logger.log(Level.SEVERE, "Error during comparison", e);

		}finally {
			storageService.deleteAll();
		}
		return result;
	}

	public StudentCompareResult compareTwoSubmissionFolders(List<FileTuple> fileList1, List<FileTuple> fileList2, String userID, String student1Id,
			String student2Id, String submissionType) throws FileNotFoundException, IOException {

		List<Report> reportList = new ArrayList<Report>();	

		try {


			storageService.init(userID);

			StudentCompareResult spr = new StudentCompareResult();
			spr.setStudent1Id(student1Id);
			spr.setStudent2Id(student2Id);				
			spr.setComparisonType(submissionType);

			User u = userService.findUserById(userID);


			Double maxSimilarityScoreFound=-1.0D;
			Double threshold = u.getThreshold()!=null?u.getThreshold():Constants.PLAG_THRESHOLD;
			for (FileTuple fileTuple1: fileList1) {


				for (FileTuple fileTuple2: fileList2) {

					File file1 = storageService.store(s3Service.downloadFile(fileTuple1.getFileText2().substring(fileTuple1.getFileText2().lastIndexOf("/")+1)), fileTuple1.getFileText1());
					File file2 = storageService.store(s3Service.downloadFile(fileTuple2.getFileText2().substring(fileTuple1.getFileText2().lastIndexOf("/")+1)), fileTuple2.getFileText1());

					logger.info("Files getting compared:>"+ file1.getName() +"  " + file2.getName());
					Report result = fileService.compareTwoFiles(file1, file2, threshold);
					if (result == null) {
						throw new Exception("Comparison Failed!");
					}

					result.setFile1Path(fileTuple1.getFileText2().substring(fileTuple1.getFileText2().lastIndexOf("/")+1));
					result.setFile2Path(fileTuple2.getFileText2().substring(fileTuple1.getFileText2().lastIndexOf("/")+1));
					storageService.deleteFile(file1);
					storageService.deleteFile(file2);


					if (result != null) {

						if (result.getAverageScore() > maxSimilarityScoreFound) {
							maxSimilarityScoreFound = result.getAverageScore();
						}
						
						if (result.getAverageScore() >= threshold) {
							spr.setPlagiarismExists(Constants.YES);
						}
						reportList.add(result);	 
					}
				}
			}

			spr.setMaxSimilarityInAnyTwoFiles(String.valueOf(maxSimilarityScoreFound));
			
			Collections.sort(reportList,new ReportComparator());
			spr.setReports(reportList);
			return spr;
		}catch(Exception e) {
			logger.log(Level.SEVERE, "Error Occurred while Comparison of folders", e);

		}finally {
			storageService.deleteAll();
		}
		return null;
	}
}

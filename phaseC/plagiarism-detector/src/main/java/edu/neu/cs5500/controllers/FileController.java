package edu.neu.cs5500.controllers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.file.FileService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;
@RestController
public class FileController {

	// Logger
	private static Logger logger = Logger.getLogger(FileController.class.getName());

	@Autowired 
	private StorageService storageService;

	@Autowired
	private UserService userService;


	@Autowired 
	private FileService fileService;
	
	
	@Autowired
	private S3Services s3Service;
	
	@Autowired
	private ReportService reportService;

	/**
	 * @param uploadFiles
	 * @param userId
	 * @param student1Id
	 * @param student2Id
	 * @return
	 * Method to compare two uploaded files. It returns the report object in response which containes all plagiarism related data
	 * 
	 */
	@RequestMapping(value = "/api/compare/comparefiles/{userId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> uploadAndCompareTwoFiles
					(@RequestParam("uploadingFiles") MultipartFile[] uploadFiles,
							@PathVariable("userId") String userId,
							@RequestParam("s1Id") String student1Id,
							@RequestParam("s2Id") String student2Id) {	


		User currentUser = userService.findUserById(userId);
		ServiceResponse response = new ServiceResponse();
		HttpHeaders headers = new HttpHeaders();
		
		if (uploadFiles == null || uploadFiles.length < 2) {
			Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Input", response);
			return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
		}
		if (userId==null || currentUser==null) {
			Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid User", response);
			return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
		}
		if (student1Id==null || userService.findUserById(student1Id)==null) {
			Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Student found", response);
			return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
		}
		if (student2Id==null || userService.findUserById(student2Id)==null) {
			Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Student found", response);
			return new ResponseEntity<>(response, headers, HttpStatus.BAD_REQUEST);
		}

		logger.info("File 1 uploaded for comparison" + uploadFiles[0].getOriginalFilename());
		logger.info("File 1 uploaded for comparison" + uploadFiles[1].getOriginalFilename());
		Double threshold = currentUser.getThreshold()!=null?currentUser.getThreshold():Constants.PLAG_THRESHOLD;
		try {
			
			storageService.init(userId);
			
			File file1 = storageService.store(uploadFiles[0],student1Id);
			File file2 = storageService.store(uploadFiles[1],student2Id);

			Report result = fileService.compareTwoFiles(file1, file2, threshold);
			
			if (result == null) {
				throw new Exception();
			}
			
			
			// Add files to s3 bucket
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
				throw new Exception();
			}
			
			
			// Add the file Data
	
			// Add report to the database by creating this report object to a bigger report object
			StudentCompareResult spr = new StudentCompareResult();
			
			spr.setStudent1Id(student1Id);
			spr.setStudent2Id(student2Id);		
			spr.setComparisonType("FILE");
			List<Report> list = new ArrayList<Report>();
			list.add(result);		
			spr.setReports(list);
			
			spr.setMaxSimilarityInAnyTwoFiles(result.getAverageScore().toString());
			
			if (result.getAverageScore() >= threshold) {
				spr.setPlagiarismExists(Constants.YES);
			}
			
			List<StudentCompareResult> lspr = new ArrayList<StudentCompareResult>();
			lspr.add(spr);
			
			Operation op = new Operation();

			op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

			op.setOperationType("FILE");		
			op.setStudentResult(lspr);
			op.setUserId(userId);
			op.setInitiatedBy("User");			
			
			
			String saveResult =  reportService.saveOperation(op);
			if (saveResult == null) {
				throw new Exception("Error while save the operation");
			}

			
			
			Utility.setResponseObject(result, Constants.SUCCESS, "Comparison Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
			
		}catch (Exception e) {
			logger.log(Level.SEVERE,"Error Occurred",e);
			Utility.setResponseObject(null, "201", "Comparison Not Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
		}finally {
			storageService.deleteAll();
		}
	

	} 



	@RequestMapping(value = "/api/compare/comparefolders/{userId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> uploadAndCompareTwoFolders(@RequestParam("fileList1") MultipartFile[] fileList1,
			@RequestParam("fileList2") MultipartFile[] fileList2,
			@PathVariable("userId") String userId,
			@RequestParam("s1Id") String student1Id,
			@RequestParam("s2Id") String student2Id) {	
		ServiceResponse response = new ServiceResponse();
		HttpHeaders headers = new HttpHeaders();
		try {
			

			if (fileList1 == null || fileList1.length == 0 || fileList2==null || fileList2.length ==0) {
				Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Input", response);
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);
			}
			if (userId==null || userService.findUserById(userId)==null) {
				Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid User", response);
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);
			}

		
			
			String operationId = fileService.compareTwoFolders(fileList1, fileList2, userId,student1Id,student2Id);

			if (operationId==null || operationId.isEmpty()) {
				Utility.setResponseObject(null, "201", "Comparison Not Successful", response);
				return new ResponseEntity<>(response,headers, HttpStatus.OK);
			}
			Utility.setResponseObject(operationId, Constants.SUCCESS, "Comparison Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
			
		}catch(Exception e) {
			Utility.setResponseObject(null, "201", "Comparison Not Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
		}

		


	} 
	
	
	@RequestMapping(value = "/api/compare/comparetexts/{userId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> compareTexts(
			@RequestBody FileTuple fileTuple, 
			@PathVariable("userId") String userId,
			@RequestParam("s1Id") String student1Id,
			@RequestParam("s2Id") String student2Id) {	
		ServiceResponse response = new ServiceResponse();
		HttpHeaders headers = new HttpHeaders();

		try {
			
			if (fileTuple==null || fileTuple.getFileText1() == null || fileTuple.getFileText1().isEmpty()
					|| fileTuple.getFileText2() == null || fileTuple.getFileText2().isEmpty()) {
				
				Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Input", response);
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);
			}
			if (userId==null || userService.findUserById(userId)==null) {
				Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid User", response);
				return new ResponseEntity<>(response,headers, HttpStatus.BAD_REQUEST);
			}

			Report result = fileService.compareTwoTexts(fileTuple.getFileText1(), fileTuple.getFileText2(), userId,student1Id,student2Id);

			if (result == null) {
				throw new Exception ("Comparison not successful");
			}
			Utility.setResponseObject(result, Constants.SUCCESS, "Comparison Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
			
		}catch(Exception e) {
			Utility.setResponseObject(null, "201", "Comparison Not Successful", response);
			return new ResponseEntity<>(response,headers, HttpStatus.OK);
		}
		
		
		

	} 
	
	
	// S3 Bucket Tests
	//upload
	@RequestMapping(value = "/api/s3/upload", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> uploadFileTesting() {

		ServiceResponse response = new ServiceResponse();
		
		
		s3Service.uploadFile("userName/myFileName.py", new File("C:\\Users\\Asim\\Dropbox\\Northeastern_University\\Spring2018\\MSD\\jplagTest\\files\\s1\\app.py"));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	
	//Download
		@RequestMapping(value = "/api/s3/download", method = RequestMethod.GET)
		public ResponseEntity<ServiceResponse> downloadFileTesting() {

			ServiceResponse response = new ServiceResponse();
			
			
			s3Service.downloadFile("userName/myFileName.py");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		


}

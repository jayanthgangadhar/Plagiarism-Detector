package edu.neu.cs5500.services.report;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import edu.neu.cs5500.dao.report.ReportDao;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Utility;

/**
 * @author Asim
 * 
 * Service to implement the Report generation and other related features
 *
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService{


	@Autowired
	private ReportDao reportDao;

	@Autowired
	private UserService userService;

	@Autowired
	private S3Services s3Service;
	
	// Logger
	private static Logger logger = Logger.getLogger(ReportServiceImpl.class.getName());

	@Override
	public String saveOperation(Operation op){

		Operation opCurrent = new Operation();
		try {


			// Saving the operation 
			opCurrent = reportDao.saveOperation(op);
			// Saving the student results

			List<StudentCompareResult> studentResults = op.getStudentResult();
			for (StudentCompareResult stuResult : studentResults) {

				stuResult.setParentOperationId(opCurrent.getId());
				StudentCompareResult s  = reportDao.saveStudentCompareResult(stuResult);

				for (Report report : stuResult.getReports()) {
					report.setParentStudentsCompareId(s.getId());
					reportDao.saveReport(report);
				}


			}	
		}catch (Exception e) {
			logger.log(Level.SEVERE, "Error occurred while saving the operation", e);
			return null;
		}
		return opCurrent.getId();
	}

	@Override
	public StudentCompareResult saveStudentCompareResult(StudentCompareResult studentResult) {
		return reportDao.saveStudentCompareResult(studentResult);
	}

	@Override
	public Report saveReport(Report report) {
		return reportDao.saveReport(report);
	}

	@Override
	public List<Operation> getOperationsByUserId(String userId) {

		return reportDao.getOperationsByUserId(userId);
	}

	@Override
	public List<StudentCompareResult> getStudentCompareResultByOpId(String operationID) {
		List<StudentCompareResult> results = null;

		try {

			results = reportDao.getStudentCompareResultByOpId(operationID);

			results = results.stream().map(item -> {
				item.setStudent1Name(userService.getUserFullNameById(item.getStudent1Id()));
				item.setStudent2Name(userService.getUserFullNameById(item.getStudent2Id()));
				return item;
			}).collect(Collectors.toList());

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Cannot retrieve student comparison results", e);
		}
		return results;
	}

	@Override
	public List<Report> getAllReportsByStudentCompareId(String id) {
		List<Report> results = null;

		try {

			results = reportDao.getAllReportsByStudentCompareId(id);

			results = results.stream().map(item -> {
				try {
					item.setFile1Data(Utility.getFileStringData(s3Service.downloadFile(item.getFile1Path().substring(item.getFile1Path().lastIndexOf("/")+1))));
					item.setFile2Data(Utility.getFileStringData(s3Service.downloadFile(item.getFile2Path().substring(item.getFile1Path().lastIndexOf("/")+1))));
				} catch (IOException e) {
					logger.log(Level.SEVERE,"Error occured while retrieving document from S3 Bucket", e);

				}

				return item;
			}).collect(Collectors.toList());

		}catch(Exception e) {
			logger.log(Level.SEVERE,"Cannot retrieve student comparison results", e);
		}
		return results;
	}

	@Override
	public Operation findOperationById(String opId) {
		return reportDao.findOperationById(opId);
	}

	@Override
	public StudentCompareResult findStudentCompById(String id) {
		return reportDao.findStudentCompById(id);
	}

}

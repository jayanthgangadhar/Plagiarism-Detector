package edu.neu.cs5500.dao.report;

import java.util.List;

import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;

public interface ReportDao {
	
	/**
	 * @param operation
	 * @return
	 * 
	 * Method used to save a compare transaction of the user
	 */
	public Operation saveOperation(Operation operation);
	/**
	 * @param studentResult
	 * Method used to save studentPair results
	 * 
	 * @return
	 */
	public StudentCompareResult saveStudentCompareResult(StudentCompareResult studentResult);
	/**
	 * @param report
	 * @return
	 * 
	 * Method used to save the report generated during comparison of files between two students
	 */
	public Report saveReport(Report report);
	/**
	 * @param userId
	 * @return
	 * 
	 * list all operations based on the professors id
	 */
	public List<Operation> getOperationsByUserId(String userId);
	/**
	 * @param operationID
	 * @return
	 * 
	 * get all students pairs involved in the operation
	 */
	public List<StudentCompareResult> getStudentCompareResultByOpId(String operationID);
	/**
	 * @param id
	 * @return
	 * 
	 * Get all reports/results between the comparison of two students
	 */
	public List<Report> getAllReportsByStudentCompareId(String id);
	/**
	 * @param opId
	 * @return
	 * Find the operation data based on input operation id
	 */
	public Operation findOperationById(String opId);
	/**
	 * @param id
	 * @return
	 * 
	 * Find StudentPairs Data based on input ID
	 */
	public StudentCompareResult findStudentCompById(String id);
	

}

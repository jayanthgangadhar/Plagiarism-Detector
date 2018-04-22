package edu.neu.cs5500.services.report;

import java.util.List;

import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;

public interface ReportService {
	
	
	public String saveOperation(Operation op);
	public StudentCompareResult saveStudentCompareResult(StudentCompareResult studentResult);
	public Report saveReport(Report report);
	public List<Operation> getOperationsByUserId(String userId);
	public List<StudentCompareResult> getStudentCompareResultByOpId(String operationID);
	public List<Report> getAllReportsByStudentCompareId(String id);
	public Operation findOperationById(String opId);
	public StudentCompareResult findStudentCompById(String id);
}

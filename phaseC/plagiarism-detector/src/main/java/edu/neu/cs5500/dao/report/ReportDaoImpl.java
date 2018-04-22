package edu.neu.cs5500.dao.report;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.cs5500.dao.semester.SemesterDaoImpl;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.repository.OperationRepository;
import edu.neu.cs5500.repository.ReportsRepository;
import edu.neu.cs5500.repository.StudentComparisonRepository;

@Repository("reportDao")
public class ReportDaoImpl implements ReportDao{

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private StudentComparisonRepository studentResultRepository;
	
	@Autowired
	private ReportsRepository reportRepository;
	
	
	
	private static Logger logger = Logger.getLogger(ReportDaoImpl.class.getName());
	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#saveOperation(edu.neu.cs5500.domainObjects.Operation)
	 */
	@Override
	public Operation saveOperation(Operation operation) {
	
		return operationRepository.save(operation);
		
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#getOperationsByUserId(java.lang.String)
	 */
	@Override
	public List<Operation> getOperationsByUserId(String userId) {
		return operationRepository.findByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#getStudentCompareResultByOpId(java.lang.String)
	 */
	@Override
	public List<StudentCompareResult> getStudentCompareResultByOpId(String operationID) {
		
		return studentResultRepository.findByParentOperationId(operationID);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#getAllReportsByStudentCompareId(java.lang.String)
	 */
	@Override
	public List<Report> getAllReportsByStudentCompareId(String id) {
		
		return reportRepository.findByParentStudentsCompareId(id);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#saveStudentCompareResult(edu.neu.cs5500.domainObjects.StudentCompareResult)
	 */
	@Override
	public StudentCompareResult saveStudentCompareResult(StudentCompareResult studentResult) {
		return studentResultRepository.save(studentResult);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#saveReport(edu.neu.cs5500.domainObjects.Report)
	 */
	@Override
	public Report saveReport(Report report) {

		return reportRepository.save(report); 
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#findOperationById(java.lang.String)
	 */
	@Override
	public Operation findOperationById(String opId) {

		return operationRepository.findById(opId);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.report.ReportDao#findStudentCompById(java.lang.String)
	 */
	@Override
	public StudentCompareResult findStudentCompById(String id) {
		return studentResultRepository.findById(id);
	}

}

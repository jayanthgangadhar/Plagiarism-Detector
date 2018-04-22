package edu.neu.cs5500.services.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;
import edu.neu.cs5500.dao.report.ReportDao;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.user.UserService;

/**
 * @author Asim
 * 
 * Test suite to test the functionality of the report service
 *
 */
@RunWith(SpringRunner.class)
public class ReportServiceImplTest {


	@Autowired
	private ReportService reportService;

	@MockBean
	private ReportDao reportDaoMock;


	@MockBean
	private UserService userServiceMock;

	@MockBean
	private S3Services s3ServiceMock;


	@Autowired
	private ResourceLoader resourceLoader;

	@TestConfiguration
	static class ReportServiceImplConfiguraton {
		@Bean
		public ReportService reportService() {
			return new ReportServiceImpl();
		}
	}

	/**
	 * Test save operation
	 */
	@Test
	public void testtestSaveOperation() {
		Operation opCurrent = new Operation();
		opCurrent.setId("12345");
		Report r = new Report();
		List<Report> lr = new ArrayList<>();
		lr.add(r);
		StudentCompareResult st = new StudentCompareResult();
		st.setReports(lr);
		st.setId("2345");
		List<StudentCompareResult> results = new ArrayList<>();
		results.add(st);

		opCurrent.setStudentResult(results);
		when(reportDaoMock.saveOperation(anyObject())).thenReturn(opCurrent);
		when(reportDaoMock.saveStudentCompareResult(anyObject())).thenReturn(st);
		when(reportDaoMock.saveReport(anyObject())).thenReturn(r);


		assertEquals("12345", reportService.saveOperation(opCurrent));

	}


	/**
	 * Test for save operation when any method throws an exception
	 */
	@Test
	public void testtestSaveOperationWithException() {
		Operation opCurrent = new Operation();
		opCurrent.setId("12345");
		Report r = new Report();
		List<Report> lr = new ArrayList<>();
		lr.add(r);
		StudentCompareResult st = new StudentCompareResult();
		st.setReports(lr);
		st.setId("2345");
		List<StudentCompareResult> results = new ArrayList<>();
		results.add(st);

		opCurrent.setStudentResult(results);
		when(reportDaoMock.saveOperation(anyObject())).thenThrow(Exception.class);
		when(reportDaoMock.saveStudentCompareResult(anyObject())).thenReturn(st);
		when(reportDaoMock.saveReport(anyObject())).thenReturn(r);


		assertEquals(null, reportService.saveOperation(opCurrent));

	}

	/**
	 * Test student pair results
	 */
	@Test
	public void testsaveStudentCompareResult() {
		StudentCompareResult st = new StudentCompareResult();

		st.setId("2345");
		when(reportDaoMock.saveStudentCompareResult(anyObject())).thenReturn(st);

		assertEquals("2345", reportService.saveStudentCompareResult(st).getId());
	}

	/**
	 * Test for save report for a positive scenario
	 */
	@Test
	public void testsaveReport() {
		Report r = new Report();
		r.setId("123");
		when(reportDaoMock.saveReport(anyObject())).thenReturn(r);
		assertEquals("123", reportService.saveReport(r).getId());
	}

	/**
	 * Test method getOperationsByUserId in case id is valid
	 */
	@Test
	public void testgetOperationsByUserId() {
		Operation opCurrent = new Operation();
		opCurrent.setId("12345");
		List<Operation> results = new ArrayList<>();
		results.add(opCurrent);
		when(reportDaoMock.getOperationsByUserId(anyString())).thenReturn(results);

		assertEquals("12345", reportService.getOperationsByUserId("123").get(0).getId());
	}

	/**
	 * tes for student pair when valid operationid is given
	 */
	@Test
	public void testgetStudentCompareResultByOpId() {
		List<StudentCompareResult> results = new ArrayList<>();
		StudentCompareResult s = new StudentCompareResult();
		results.add(s);
		when(userServiceMock.getUserFullNameById(anyString())).thenReturn("Asim Khan");
		when(reportDaoMock.getStudentCompareResultByOpId(anyString())).thenReturn(results);

		assertNotNull(reportService.getStudentCompareResultByOpId("123"));
	}

	/**
	 * Test getStudentCompareResultByOpId when any internal method gives an exception
	 */
	@Test
	public void testgetStudentCompareResultByOpIdForException() {
		List<StudentCompareResult> results = new ArrayList<>();

		when(userServiceMock.getUserFullNameById(anyString())).thenReturn("Asim Khan");
		when(reportDaoMock.getStudentCompareResultByOpId(anyString())).thenThrow(Exception.class);

		assertNull(reportService.getStudentCompareResultByOpId("123"));
	}


	/**
	 * @throws IOException
	 * Test if reports are generated correctly
	 */
	@Test
	public void testgetAllReportsByStudentCompareId() throws IOException {
		List<Report> results = new ArrayList<>();
		Report r = new Report();
		r.setId("123");
		r.setFile1Path("www.asd/123.py");
		r.setFile2Path("www.asd/1234.py");
		results.add(r);
		InputStream f1 = resourceLoader.getResource("classpath:File1.py").getInputStream();
		InputStream f2 = resourceLoader.getResource("classpath:File2.py").getInputStream();

		when(reportDaoMock.getAllReportsByStudentCompareId(anyString())).thenReturn(results);		
		when(s3ServiceMock.downloadFile("123.py")).thenReturn(f1);
		when(s3ServiceMock.downloadFile("1234.py")).thenReturn(f2);


		assertNotNull(reportService.getAllReportsByStudentCompareId("123"));
		assertEquals("123", reportService.getAllReportsByStudentCompareId("123").get(0).getId());
	}


	/**
	 * @throws IOException
	 * 
	 * test for report generation if any excetion occurs
	 */
	@Test
	public void testgetAllReportsByStudentExceptionCase() throws IOException {

		when(reportDaoMock.getAllReportsByStudentCompareId(anyString())).thenThrow(Exception.class);
		assertNull(reportService.getAllReportsByStudentCompareId("123"));

	}

	/**
	 * test for valid operation ID
	 */
	@Test
	public void testfindOperationById() {
		Operation opCurrent = new Operation();
		opCurrent.setId("12345");

		when(reportDaoMock.findOperationById(anyString())).thenReturn(opCurrent);
		assertEquals("12345", reportService.findOperationById("123").getId());
	}

	/**
	 * Test for valid studentCompId
	 */
	@Test
	public void testfindStudentCompById() {

		StudentCompareResult st = new StudentCompareResult();
		st.setId("2345");
		when(reportDaoMock.findStudentCompById(anyString())).thenReturn(st);
		assertEquals("2345", reportService.findStudentCompById("123").getId());
	}

}

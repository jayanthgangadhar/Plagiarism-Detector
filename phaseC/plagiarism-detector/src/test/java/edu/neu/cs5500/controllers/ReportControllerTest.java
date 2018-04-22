package edu.neu.cs5500.controllers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.email.MailService;
import edu.neu.cs5500.services.file.FileService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ReportControllerTest.class, secure=false)
public class ReportControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FileService fileServiceMock;
	
	
	@MockBean
	private UserService userServiceMock;
	
	@MockBean
	private S3Services s3ServiceMock;
	
	
	@MockBean
	private ReportService reportServiceMock;
	
	@MockBean
	private StorageService storageServiceMock;
	
	
	@MockBean
	private MailService mailServiceMock;

	
	
	@TestConfiguration
	static class ReportControllerTestConfiguration {
		@Bean
		public ReportController reportController() {
			return new ReportController();
		}
	}
	
	
	/**
	 * @throws Exception
	 * 
	 * Operations is not null
	 */
	@Test
	public void testGetOperationsByUserId() throws Exception {
		
		User u = new User();
		u.setId("1234");
		Operation o = new Operation();
		o.setStudentResult(null);
		o.setId("5ac7071e033a724a64aaee77");
		o.setDate("Fri Apr 06 01:34:40 EDT 2018");
		o.setOperationType("FILE");
		o.setUserId("5ac190057a5fd865282c20ec");
		o.setInitiatedBy("User");
		List<Operation> listOp = new ArrayList<>();
		
		listOp.add(o);
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(reportServiceMock.getOperationsByUserId(anyString())).thenReturn(listOp);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1234/operation")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\r\n" + 
				"    \"status\": \"200\",\r\n" + 
				"    \"description\": \"Found operations for the user\",\r\n" + 
				"    \"data\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": \"5ac7071e033a724a64aaee77\",\r\n" + 
				"            \"studentResult\": null,\r\n" + 
				"            \"date\": \"Fri Apr 06 01:34:40 EDT 2018\",\r\n" + 
				"            \"operationType\": \"FILE\",\r\n" + 
				"            \"userId\": \"5ac190057a5fd865282c20ec\",\r\n" + 
				"            \"initiatedBy\": \"User\"\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"token\": null,\r\n" + 
				"    \"refreshToken\": null\r\n" + 
				"}";
		
		
		
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * @throws Exception
	 * 
	 * when operation is null
	 */
	@Test
	public void testGetOperationsForNullOperation() throws Exception {
		
		User u = new User();
		u.setId("1234");
		
		List<Operation> listOp = new ArrayList<>();
		
		
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(reportServiceMock.getOperationsByUserId(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1234/operation")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	
	/**
	 * @throws Exception
	 * 
	 * when operation is null
	 */
	@Test
	public void testGetOperationsForEmptyOperation() throws Exception {
		
		User u = new User();
		u.setId("1234");
		
		List<Operation> listOp = new ArrayList<>();
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(reportServiceMock.getOperationsByUserId(anyString())).thenReturn(listOp);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1234/operation")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";		
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * @throws Exception
	 * 
	 * when User is null
	 */
	@Test
	public void testGetOperationsForNullUser() throws Exception {
		
		User u = new User();
		u.setId("1234");
		
		List<Operation> listOp = new ArrayList<>();
		
		when(userServiceMock.findUserById(anyString())).thenReturn(null);
		when(reportServiceMock.getOperationsByUserId(anyString())).thenReturn(null);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1234/operation")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		String response = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";		
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	

	/**
	 * When student details is  empty
	 * @throws Exception 
	 */
	@Test
	public void testGetStudentsDetailsByOperationsId() throws Exception{
		
		Operation o = new Operation();
		o.setStudentResult(null);
		o.setId("5ac7071e033a724a64aaee77");
		o.setDate("Fri Apr 06 01:34:40 EDT 2018");
		o.setOperationType("FILE");
		o.setUserId("5ac190057a5fd865282c20ec");
		o.setInitiatedBy("User");
		List<StudentCompareResult> results = new ArrayList<>();
		when(reportServiceMock.findOperationById(anyString())).thenReturn(o);
		when(reportServiceMock.getStudentCompareResultByOpId(anyString())).thenReturn(results);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/466/studentsInvolved")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * When student details is  null
	 * @throws Exception 
	 */
	@Test
	public void testGetStudentsDetailsByOperationsIdForNull() throws Exception{
		
		Operation o = new Operation();
		o.setStudentResult(null);
		o.setId("5ac7071e033a724a64aaee77");
		o.setDate("Fri Apr 06 01:34:40 EDT 2018");
		o.setOperationType("FILE");
		o.setUserId("5ac190057a5fd865282c20ec");
		o.setInitiatedBy("User");
		List<StudentCompareResult> results = new ArrayList<>();
		when(reportServiceMock.findOperationById(anyString())).thenReturn(o);
		when(reportServiceMock.getStudentCompareResultByOpId(anyString())).thenReturn(null);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/466/studentsInvolved")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	

	/**
	 * When student details is  not empty or null
	 * @throws Exception 
	 */
	@Test
	public void testGetStudentsDetailsByOperationsNotNullList() throws Exception{
		
		Operation o = new Operation();
		
		
		StudentCompareResult s = new StudentCompareResult();
		s.setComparisonType("FILE");
		s.setId("5ac7198c033a723524cd106e");
		s.setMaxSimilarityInAnyTwoFiles(null);
		s.setMaxSimilarityInAnyTwoFiles(null);
		s.setStudent1Name("asim khan");
		s.setStudent1Id("5ac1a865033a722eb8ede9ea");
		s.setStudent2Name("Sanket Mathu");
		s.setStudent2Id("123456");
		s.setParentOperationId("5ac7198c033a723524cd106d");
		List<StudentCompareResult> results = new ArrayList<>();
		results.add(s);
		when(reportServiceMock.findOperationById(anyString())).thenReturn(o);
		when(reportServiceMock.getStudentCompareResultByOpId(anyString())).thenReturn(results);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/466/studentsInvolved")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\r\n" + 
				"    \"status\": \"200\",\r\n" + 
				"    \"description\": \"Found results for the operationID\",\r\n" + 
				"    \"data\": [\r\n" + 
				"        {\r\n" + 
				"            \"id\": \"5ac7198c033a723524cd106e\",\r\n" + 
				"            \"student1Name\": \"asim khan\",\r\n" + 
				"            \"student2Name\": \"Sanket Mathu\",\r\n" + 
				"            \"student1Id\": \"5ac1a865033a722eb8ede9ea\",\r\n" + 
				"            \"student2Id\": \"123456\",\r\n" + 
				"            \"parentOperationId\": \"5ac7198c033a723524cd106d\",\r\n" + 
				"            \"plagiarismExists\": null,\r\n" + 
				"            \"maxSimilarityInAnyTwoFiles\": null,\r\n" + 
				"            \"comparisonType\": \"FILE\",\r\n" + 
				"            \"reports\": null\r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"token\": null,\r\n" + 
				"    \"refreshToken\": null\r\n" + 
				"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	
	/**
	 * When student details is  not empty or null
	 * @throws Exception 
	 */
	@Test
	public void testGetStudentsDetailsforNullOperation() throws Exception{
		
		when(reportServiceMock.findOperationById(anyString())).thenReturn(null);
		when(reportServiceMock.getStudentCompareResultByOpId(anyString())).thenReturn(null);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/466/studentsInvolved")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"Operation ID Does not exist\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	}
	
	
	
	/**
	 * @throws Exception
	 * 
	 * Test on empty record
	 */
	@Test
	public void testGetReportsOnStudentCompareId() throws Exception{	
		
		StudentCompareResult s = new StudentCompareResult();		
		List<Report> results = new ArrayList<>();		
		when(reportServiceMock.findStudentCompById(anyString())).thenReturn(s);
		when(reportServiceMock.getAllReportsByStudentCompareId(anyString())).thenReturn(results);		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/456/studentsInvolved/789")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	
		
	}
	
	
	/**
	 * @throws Exception
	 * 
	 * Test on null report
	 */
	@Test
	public void testGetReportsOnStudentCompareId2() throws Exception{	
		
		StudentCompareResult s = new StudentCompareResult();		
		List<Report> results = new ArrayList<>();		
		when(reportServiceMock.findStudentCompById(anyString())).thenReturn(s);
		when(reportServiceMock.getAllReportsByStudentCompareId(anyString())).thenReturn(null);		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/456/studentsInvolved/789")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"Not Found\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	
		
	}

	/**
	 * @throws Exception
	 * 
	 * Test on Non empty report
	 */
	@Test
	public void testGetReportsOnStudentCompareIdNonEmptyReport() throws Exception{	
		
		StudentCompareResult s = new StudentCompareResult();		
		Report r = new Report();
		r.setId("5ac725f0033a7234648c5cf7");
		List<Report> results = new ArrayList<>();	
		results.add(r);
		when(reportServiceMock.findStudentCompById(anyString())).thenReturn(s);
		when(reportServiceMock.getAllReportsByStudentCompareId(anyString())).thenReturn(results);		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/456/studentsInvolved/789")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\r\n" + 
				"    \"status\": \"200\",\r\n" + 
				"    \"description\": \"Found the reports\",\r\n" + 
				"    \"data\": [\r\n" + 
				"        \r\n" + 
				"        {\r\n" + 
				"            \"id\": \"5ac725f0033a7234648c5cf7\"        \r\n" + 
				"           \r\n" + 
				"            \r\n" + 
				"        }\r\n" + 
				"    ],\r\n" + 
				"    \"token\": null,\r\n" + 
				"    \"refreshToken\": null\r\n" + 
				"}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	
		
	}
	
	
	/**
	 * @throws Exception
	 * 
	 * Test on empty record for students
	 */
	@Test
	public void testGetReportsOnStudentCompareIdNonNullStudents() throws Exception{	
		
		
		when(reportServiceMock.findStudentCompById(anyString())).thenReturn(null);
		when(reportServiceMock.getAllReportsByStudentCompareId(anyString())).thenReturn(null);		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/123/operation/456/studentsInvolved/789")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String response = "{\"status\":\"404\",\"description\":\"ID Does not exist\",\"data\":null,\"token\":null,\"refreshToken\":null}";
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(response, result.getResponse().getContentAsString(), false);
	
		
	}

	

}

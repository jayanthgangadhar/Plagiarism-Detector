/**
 * 
 */
package edu.neu.cs5500.controllers;

import static org.mockito.Matchers.anyObject;
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

import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.storage.StorageService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value=AssignmentController.class, secure=false)
public class AssignmentControllerTest {

	@TestConfiguration
	static class AssignmentControllerTestConfiguration {
		@Bean
		public AssignmentController assignmentController() {
			return new AssignmentController();
		}
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AssignmentService assignServiceMock;
	
	@MockBean
	private StorageService storageServiceMock;
	
	@MockBean
	private S3Services s3Service;
	
	/**
	 * Test for the assignment creation
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void createAssignmentTestSuccess() throws Exception {
		String assignJSON = "{\n" + 
				"	\"_id\": \"A0010\",\n" + 
				"	\"name\": \"GIT\",\n" + 
				"	\"deadline\": \"2018-04-03\",\n" + 
				"	\"relatedCourseId\": \"124\",\n" + 
				"	\"documentUrl\": \"someurl.comassignment\",\n" + 
				"	\"status\": \"ACTIVE\",\n" + 
				"	\"submissionType\": \"File\"\n" + 
				"}";
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignServiceMock.createAssignment(anyObject())).thenReturn(a);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON)
				.content(assignJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\n" + 
				"    \"status\": \"200\",\n" + 
				"    \"description\": \"Created assignment successfully\",\n" + 
				"    \"data\": {\n" + 
				"        \"_id\": \"A0010\",\n" + 
				"        \"name\": \"GIT\",\n" + 
				"        \"deadline\": \"2018-04-03\",\n" + 
				"        \"submissionType\": \"File\",\n" + 
				"        \"documentUrl\": \"https://someurl.com/assignment\",\n" + 
				"        \"relatedCourseId\": \"124\",\n" + 
				"        \"status\": \"ACTIVE\",\n" + 
				"        \"creationDate\": null\n" + 
				"    }\n" + 
				"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for the assignment creation
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void createAssignmentTestFail() throws Exception {
		String assignJSON = "{\n" + 
				"	\"_id\": \"A0010\",\n" + 
				"	\"name\": \"GIT\",\n" + 
				"	\"deadline\": \"2018-04-03\",\n" + 
				"	\"relatedCourseId\": \"124\",\n" + 
				"	\"documentUrl\": \"someurl.comassignment\",\n" + 
				"	\"status\": \"ACTIVE\",\n" + 
				"	\"submissionType\": \"File\"\n" + 
				"}";
		when(assignServiceMock.createAssignment(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON)
				.content(assignJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\n" + 
				"    \"status\": \"404\",\n" + 
				"    \"description\": \"Assignment not created\",\n" + 
				"    \"data\": null" + 
				"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * test for delete assignment successfully
	 * @throws Exception
	 */
	@Test
	public void deleteAssignmentTestSuccess() throws Exception {
		when(assignServiceMock.deleteAssignment(anyString())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/12345/assignment/remove/A123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJson = "{\"status\":\"200\",\"description\":\"Deleted assignment Successfully\",\"data\":null}";
		JSONAssert.assertEquals(responseJson, result.getResponse().getContentAsString(), false);
		
		
	}
	
	/**
	 * test for delete assignment fail
	 * @throws Exception
	 */
	@Test
	public void deleteAssignmentTestFail() throws Exception {
		when(assignServiceMock.deleteAssignment(anyString())).thenReturn(false);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/12345/assignment/remove/A123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJson = "{\"status\":\"409\",\"description\":\"Could not delete assignment\",\"data\":null}";
		JSONAssert.assertEquals(responseJson, result.getResponse().getContentAsString(), false);		
	}
	
	/**
	 * Test for the assignment update
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void updateAssignmentTestSuccess() throws Exception {
		String assignJSON = "{\n" + 
				"	\"_id\": \"A0010\",\n" + 
				"	\"name\": \"GIT2\",\n" + 
				"	\"deadline\": \"2018-04-03\",\n" + 
				"	\"relatedCourseId\": \"124\",\n" + 
				"	\"documentUrl\": \"https://someurl.com/assignment\",\n" + 
				"	\"status\": \"ACTIVE\",\n" + 
				"	\"submissionType\": \"File\"\n" + 
				"}";
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT2");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignServiceMock.updateAssignment(anyObject())).thenReturn(a);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON)
				.content(assignJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\n" + 
				"    \"status\": \"200\",\n" + 
				"    \"description\": \"Updated assignment successfully\",\n" + 
				"    \"data\": {\n" + 
				"        \"_id\": \"A0010\",\n" + 
				"        \"name\": \"GIT2\",\n" + 
				"        \"deadline\": \"2018-04-03\",\n" + 
				"        \"submissionType\": \"File\",\n" + 
				"        \"documentUrl\": \"https://someurl.com/assignment\",\n" + 
				"        \"relatedCourseId\": \"124\",\n" + 
				"        \"status\": \"ACTIVE\",\n" + 
				"        \"creationDate\": null\n" + 
				"    }\n" + 
				"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for the assignment update
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void updateAssignmentTestFail() throws Exception {
		String assignJSON = "{\n" + 
				"	\"_id\": \"A0010\",\n" + 
				"	\"name\": \"GIT2\",\n" + 
				"	\"deadline\": \"2018-04-03\",\n" + 
				"	\"relatedCourseId\": \"124\",\n" + 
				"	\"documentUrl\": \"https://someurl.com/assignment\",\n" + 
				"	\"status\": \"ACTIVE\",\n" + 
				"	\"submissionType\": \"File\"\n" + 
				"}";
		when(assignServiceMock.updateAssignment(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON)
				.content(assignJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\n" + 
				"    \"status\": \"404\",\n" + 
				"    \"description\": \"Assignment Not Found\",\n" + 
				"    \"data\": null \n" +
				"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for findAllAssignments
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAllAssignmentsTestSuccess() throws Exception {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT2");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		List<Assignment> assignList = new ArrayList<>();
		assignList.add(a);
		when(assignServiceMock.findAllAssignments()).thenReturn(assignList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 1 Assignments\","
				+ "\"data\":[{\"_id\":\"A0010\","
					+ "\"name\":\"GIT2\","
					+ "\"deadline\":\"2018-04-03\","
					+ "\"submissionType\":\"File\","
					+ "\"documentUrl\":\"https://someurl.com/assignment\","
					+ "\"relatedCourseId\":\"124\","
					+ "\"status\":\"ACTIVE\","
					+ "\"creationDate\":null}]"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for findAllAssignments
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAllAssignmentsTestFail() throws Exception {
		when(assignServiceMock.findAllAssignments()).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Assignment Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for findAssignmentById
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAssignmentByIdTestSuccess() throws Exception {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT2");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignServiceMock.findAssignmentById(anyString())).thenReturn(a);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment/1234")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found Assignment\","
				+ "\"data\":{\"_id\":\"A0010\","
					+ "\"name\":\"GIT2\","
					+ "\"deadline\":\"2018-04-03\","
					+ "\"submissionType\":\"File\","
					+ "\"documentUrl\":\"https://someurl.com/assignment\","
					+ "\"relatedCourseId\":\"124\","
					+ "\"status\":\"ACTIVE\","
					+ "\"creationDate\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test for findAssignmentById
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAssignmentByIdTestFail() throws Exception {
		when(assignServiceMock.findAssignmentById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment/1234")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Assignment Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * test findAssignmentByCourseId
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAssignmentByCourseIdTestSuccess() throws Exception {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT2");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		List<Assignment> assignList = new ArrayList<>();
		assignList.add(a);
		when(assignServiceMock.findAllCourseRelatedAssignments(anyString())).thenReturn(assignList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment/course/124")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 1 Assignments\","
				+ "\"data\":[{\"_id\":\"A0010\","
					+ "\"name\":\"GIT2\","
					+ "\"deadline\":\"2018-04-03\","
					+ "\"submissionType\":\"File\","
					+ "\"documentUrl\":\"https://someurl.com/assignment\","
					+ "\"relatedCourseId\":\"124\","
					+ "\"status\":\"ACTIVE\","
					+ "\"creationDate\":null}"
				+ "]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * test findAssignmentByCourseId
	 * @throws Exception 
	 * @throws ParseException
	 */
	@Test
	public void findAssignmentByCourseIdTestFail() throws Exception {
		when(assignServiceMock.findAllCourseRelatedAssignments(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1234/assignment/course/124")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Assignment Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
}

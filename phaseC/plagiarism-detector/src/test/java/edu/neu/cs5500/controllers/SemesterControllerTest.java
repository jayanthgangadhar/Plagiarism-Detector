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

import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.services.semester.SemesterService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value=SemesterController.class, secure=false)
public class SemesterControllerTest {

	@TestConfiguration
	static class SemesterControllerTestConfiguration {
		@Bean
		public SemesterController semesterController() {
			return new SemesterController();
		}
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SemesterService semServiceMock;
	
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#createSemester(edu.neu.cs5500.domainObjects.Semester, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreateSemesterSuccess() throws Exception {
		String semJson = "{\n" + 
				"            \"name\": \"Spring 2018\",\n" + 
				"            \"status\": \"ACTIVE\"\n" +  
				"        }";
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2018");
		s.setStatus("ACTIVE");
		when(semServiceMock.createSemester(anyObject())).thenReturn(s);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON)
				.content(semJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Created Semester\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"name\":\"Spring 2018\","
					+ "\"status\":\"ACTIVE\","
					+ "\"courses\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#createSemester(edu.neu.cs5500.domainObjects.Semester, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreateSemesterFail() throws Exception {
		String semJson = "{\n" + 
				"            \"name\": \"Spring 2018\",\n" + 
				"            \"status\": \"ACTIVE\"\n" +  
				"        }";
		when(semServiceMock.createSemester(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON)
				.content(semJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"500\",\"description\":\"Semester Not Created\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#deleteSemester(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteSemesterSuccess() throws Exception {
		when(semServiceMock.deleteSemester(anyString())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/1234/semester/remove/123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Deleted semester Successfully\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#deleteSemester(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteSemesterFail() throws Exception {
		when(semServiceMock.deleteSemester(anyString())).thenReturn(false);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/1234/semester/remove/123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"409\",\"description\":\"Could not delete semester\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#updateSemester(java.lang.String, edu.neu.cs5500.domainObjects.Semester)}.
	 * @throws Exception 
	 */
	@Test
	public void testUpdateSemesterSuccess() throws Exception {
		String semJson = "{\n" + 
				"			\"_id\":\"123\",\n" +
				"            \"name\": \"Spring 2018\",\n" + 
				"            \"status\": \"ACTIVE\"\n" +  
				"        }";
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2018");
		s.setStatus("ACTIVE");
		when(semServiceMock.updateSemester(anyObject())).thenReturn(s);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON)
				.content(semJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Updated semester successfully\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"name\":\"Spring 2018\","
					+ "\"status\":\"ACTIVE\","
					+ "\"courses\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#updateSemester(java.lang.String, edu.neu.cs5500.domainObjects.Semester)}.
	 * @throws Exception 
	 */
	@Test
	public void testUpdateSemesterFail() throws Exception {
		String semJson = "{\n" + 
				"			\"_id\":\"123\",\n" +
				"            \"name\": \"Spring 2018\",\n" + 
				"            \"status\": \"ACTIVE\"\n" +  
				"        }";
		when(semServiceMock.updateSemester(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON)
				.content(semJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Semester Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findAllSemesters(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllSemestersSuccess() throws Exception {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2018");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semServiceMock.findAllSemesters()).thenReturn(semList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 1 semesters\","
				+ "\"data\":["
					+ "{\"_id\":\"123\","
					+ "\"name\":\"Spring 2018\","
					+ "\"status\":\"ACTIVE\","
					+ "\"courses\":null}"
				+ "]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findAllSemesters(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllSemestersFail() throws Exception {
		List<Semester> semList = null;
		when(semServiceMock.findAllSemesters()).thenReturn(semList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Semester Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findSemestersById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindSemestersByIdSuccess() throws Exception {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2018");
		s.setStatus("ACTIVE");
		when(semServiceMock.findSemesterById(anyString())).thenReturn(s);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Semester found\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"name\":\"Spring 2018\","
					+ "\"status\":\"ACTIVE\","
					+ "\"courses\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findSemestersById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindSemestersByIdFail() throws Exception {
		when(semServiceMock.findSemesterById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Semester Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findAllActiveSemesters(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllActiveSemestersSuccess() throws Exception {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2018");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semServiceMock.findAllActiveSemesters()).thenReturn(semList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester/active")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 1 semesters\","
				+ "\"data\":["
					+ "{\"_id\":\"123\","
					+ "\"name\":\"Spring 2018\","
					+ "\"status\":\"ACTIVE\","
					+ "\"courses\":null}"
				+ "]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.SemesterController#findAllActiveSemesters(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindAllActiveSemestersFail() throws Exception {
		List<Semester> semList = null;
		when(semServiceMock.findAllActiveSemesters()).thenReturn(semList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123456/semester/active")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Semester Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
}
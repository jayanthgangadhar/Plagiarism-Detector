package edu.neu.cs5500.controllers;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;
import edu.neu.cs5500.services.file.FileService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;

/**
 * @author Asim
 * 
 * Test Class for FileController
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value=FileControllerTest.class, secure=false)
public class FileControllerTest {
	
	@TestConfiguration
	static class FileControllerTestConfiguration {
		@Bean
		public FileController fileController() {
			return new FileController();
		}
	}
	
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
	
	
	@Test
	public void testUploadAndCompareTwoFilesEmpty() throws Exception{
		
		
		 MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
	                "text/plain", "Spring Framework".getBytes());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload("/api/compare/comparefiles/123456?s1Id=123&s2Id=123").file(multipartFile)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String responseJSON = "{\r\n" + 
				"    \"status\": \"400\",\r\n" + 
				"    \"description\": \"Invalid Input\",\r\n" + 
				"    \"data\": null,\r\n" + 
				"    \"token\": null,\r\n" + 
				"    \"refreshToken\": null\r\n" + 
				"}";
	
		
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}
	
	
	@Test
	public void testUploadAndCompareTwoFiles() throws Exception{
		
		
		 MockMultipartFile multipartFile = new MockMultipartFile("file", "test.txt",
	                "text/plain", "Spring Framework".getBytes());
		 MockMultipartFile multipartFile2 = new MockMultipartFile("file", "test2.txt",
	                "text/plain", "Spring Framework".getBytes());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.fileUpload("/api/compare/comparefiles/123456?s1Id=123&s2Id=123").file(multipartFile).file(multipartFile2)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String responseJSON = "{\r\n" + 
				"    \"status\": \"400\",\r\n" + 
				"    \"description\": \"Invalid Input\",\r\n" + 
				"    \"data\": null,\r\n" + 
				"    \"token\": null,\r\n" + 
				"    \"refreshToken\": null\r\n" + 
				"}";
		System.out.println(result.getResponse().getContentAsString());
		
		User u = new User();
		u.setId("123456");
		when(userServiceMock.findUserById(anyString())).thenReturn(null);
		
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}

}

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

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value=CourseController.class, secure=false)
public class CourseControllerTest {
	
	@TestConfiguration
	static class CourseControllerTestConfiguration {
		@Bean
		public CourseController courseController() {
			return new CourseController();
		}
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CourseService courseServiceMock;
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#getAllCourses(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetAllCoursesSuccess() throws Exception {
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		when(courseServiceMock.listCourses()).thenReturn(courseLs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/courses")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 1 courses\","
				+ "\"data\":["
					+ "{\"_id\":\"123\","
					+ "\"courseName\":\"Test\","
					+ "\"facultyID\":\"F12\","
					+ "\"status\":\"ACTIVE\","
					+ "\"semesterId\":\"S12\","
					+ "\"studentsEnrolled\":null}"
				+ "]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#getAllCourses(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testGetAllCoursesFail() throws Exception {
		when(courseServiceMock.listCourses()).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/courses")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Course Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#createCourse(java.lang.String, edu.neu.cs5500.domainObjects.Course)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreateCourseSuccess() throws Exception {
		String courseJSON = "{ \"courseName\":\"Test\","
				+ "\"facultyID\":\"F12\","
				+ "\"status\":\"ACTIVE\","
				+ "\"semesterId\":\"S12\","
				+ "\"studentsEnrolled\":null,"
				+ "\"relatedHomeworks\":null}"
			+ "}";
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		when(courseServiceMock.createCourse(anyObject())).thenReturn(c);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/123/course")
				.accept(MediaType.APPLICATION_JSON)
				.content(courseJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Created Course\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"courseName\":\"Test\","
					+ "\"facultyID\":\"F12\","
					+ "\"status\":\"ACTIVE\","
					+ "\"semesterId\":\"S12\","
					+ "\"studentsEnrolled\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#createCourse(java.lang.String, edu.neu.cs5500.domainObjects.Course)}.
	 * @throws Exception 
	 */
	@Test
	public void testCreateCourseFail() throws Exception {
		String courseJSON = "{ \"courseName\":\"Test\","
				+ "\"facultyID\":\"F12\","
				+ "\"status\":\"ACTIVE\","
				+ "\"semesterId\":\"S12\","
				+ "\"studentsEnrolled\":null,"
				+ "\"relatedHomeworks\":null}"
			+ "}";
		when(courseServiceMock.createCourse(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/123/course")
				.accept(MediaType.APPLICATION_JSON)
				.content(courseJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"500\",\"description\":\"Course Not Created\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#updateCourse(java.lang.String, edu.neu.cs5500.domainObjects.Course)}.
	 * @throws Exception 
	 */
	@Test
	public void testUpdateCourseSuccess() throws Exception {
		String courseJSON = "{ \"courseName\":\"Test\","
				+ "\"facultyID\":\"F12\","
				+ "\"status\":\"ACTIVE\","
				+ "\"semesterId\":\"S12\","
				+ "\"studentsEnrolled\":null,"
				+ "\"relatedHomeworks\":null}"
			+ "}";
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		when(courseServiceMock.updateCourse(anyObject())).thenReturn(c);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/123/course")
				.accept(MediaType.APPLICATION_JSON)
				.content(courseJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Updated the course\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"courseName\":\"Test\","
					+ "\"facultyID\":\"F12\","
					+ "\"status\":\"ACTIVE\","
					+ "\"semesterId\":\"S12\","
					+ "\"studentsEnrolled\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#updateCourse(java.lang.String, edu.neu.cs5500.domainObjects.Course)}.
	 * @throws Exception 
	 */
	@Test
	public void testUpdateCourseFail() throws Exception {
		String courseJSON = "{ \"courseName\":\"Test\","
				+ "\"facultyID\":\"F12\","
				+ "\"status\":\"ACTIVE\","
				+ "\"semesterId\":\"S12\","
				+ "\"studentsEnrolled\":null}"
			+ "}";
		when(courseServiceMock.updateCourse(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/123/course")
				.accept(MediaType.APPLICATION_JSON)
				.content(courseJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Course Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#deleteCourseById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteCourseByIdSuccess() throws Exception {
		when(courseServiceMock.deleteCourse(anyString())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/123/course/C123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Deleted the course Successfully\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#deleteCourseById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testDeleteCourseByIdFail() throws Exception {
		when(courseServiceMock.deleteCourse(anyString())).thenReturn(false);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/123/course/C123");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"409\",\"description\":\"Could not delete Course\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findCourseById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindCourseByIdSuccess() throws Exception {
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		when(courseServiceMock.findCourseById(anyString())).thenReturn(c);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/course/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found a Course\","
				+ "\"data\":{"
					+ "\"_id\":\"123\","
					+ "\"courseName\":\"Test\","
					+ "\"facultyID\":\"F12\","
					+ "\"status\":\"ACTIVE\","
					+ "\"semesterId\":\"S12\","
					+ "\"studentsEnrolled\":null}"
				+ "}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findCourseById(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindCourseByIdFail() throws Exception {
		when(courseServiceMock.findCourseById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/course/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Course Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findCourseByFacultyId(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindCourseByFacultyIdSuccess() throws Exception {
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		when(courseServiceMock.findCourseByProfId(anyString())).thenReturn(courseLs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/course/faculty/F12")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 1 courses\",\"data\":[{\"_id\":\"123\",\"courseName\":\"Test\",\"facultyID\":\"F12\",\"status\":\"ACTIVE\",\"semesterId\":\"S12\",\"studentsEnrolled\":null}]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findCourseByFacultyId(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindCourseByFacultyIdFail() throws Exception {
		when(courseServiceMock.findCourseByProfId(anyString())).thenReturn(new ArrayList<>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/course/faculty/F12")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 0 courses\",\"data\":[]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findStudentsByCourseId(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindStudentsByCourseIdSuccess() throws Exception {
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("student");
		u.setStatus("ACTIVE");
		List<User> users = new ArrayList<>();
		users.add(u);
		when(courseServiceMock.findAllStudentsByCourseId(anyString())).thenReturn(users);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/11/course/students/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 1 students\",\"data\":[{\"id\":\"1001\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"emailAddress\":\"test@gmail.com\",\"password\":\"pass\",\"report\":null,\"role\":\"student\",\"status\":\"ACTIVE\",\"approvedBy\":null,\"approvedOn\":null,\"courseEnrolled\":null,\"userCreationDate\":null,\"operations\":null,\"threshold\":null}]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findStudentsByCourseId(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindStudentsByCourseIdFail() throws Exception {
		when(courseServiceMock.findAllStudentsByCourseId(anyString())).thenReturn(new ArrayList<>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/11/course/students/123")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"Student Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}

	/**
	 * Test method for {@link edu.neu.cs5500.controllers.CourseController#findCoursesInThisSemesters(java.lang.String, java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public void testFindCoursesInThisSemestersSuccess() throws Exception {
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("Test");
		c.setFacultyID("F12");
		c.setSemesterId("S12");
		c.setStatus("ACTIVE");
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		when(courseServiceMock.findAllCoursesInThisSemester(anyString())).thenReturn(courseLs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/11/courses/S12")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 1 courses\",\"data\":[{\"_id\":\"123\",\"courseName\":\"Test\",\"facultyID\":\"F12\",\"status\":\"ACTIVE\",\"semesterId\":\"S12\",\"studentsEnrolled\":null}]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testFindCoursesInThisSemestersFail() throws Exception {
		when(courseServiceMock.findAllCoursesInThisSemester(anyString())).thenReturn(new ArrayList<>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/11/courses/S12")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 0 courses\",\"data\":[]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}

}

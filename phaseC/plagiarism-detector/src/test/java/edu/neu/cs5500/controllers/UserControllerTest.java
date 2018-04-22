/**
 * Test for user controller
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
import edu.neu.cs5500.services.user.UserService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserControllerTest {

	@TestConfiguration
	static class UserControllerTestConfiguration {
		@Bean
		public UserController userController() {
			return new UserController();
		}
	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userServiceMock;
	
	@MockBean
	private CourseService courseServiceMock;
	
	/**
	 * A user is registered successfully
	 * @throws Exception
	 */
	@Test
	public void registerUserTestSuccess() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.createUser(anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/register")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Created User\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"APPROVAL\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User is not registered successfully
	 * @throws Exception
	 */
	@Test
	public void registerUserTestFail() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		when(userServiceMock.createUser(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/register")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"500\",\"description\":\"User Not Created\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User logged in with active status
	 * @throws Exception
	 */
	@Test
	public void loginActiveUserTestSuccess() throws Exception {
		String userJSON = "{\n" +    
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\"\n" +   
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.getUserByCredential(anyString(), anyString())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"User was found\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User logged in with rejected status
	 * @throws Exception
	 */
	@Test
	public void loginRejectedUserTestSuccess() throws Exception {
		String userJSON = "{\n" +    
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\"\n" +   
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("REJECTED");
		when(userServiceMock.getUserByCredential(anyString(), anyString())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"206\","
				+ "\"description\":\"User account has been rejected. Contant support\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"REJECTED\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User logged in with approval status
	 * @throws Exception
	 */
	@Test
	public void loginApprovalUserTestSuccess() throws Exception {
		String userJSON = "{\n" +    
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\"\n" +   
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.getUserByCredential(anyString(), anyString())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"207\","
				+ "\"description\":\"User account needed approval prior login. Contact support\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"APPROVAL\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * wrong user logged in
	 * @throws Exception
	 */
	@Test
	public void loginUserTestFail() throws Exception {
		String userJSON = "{\n" +    
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\"\n" +   
				"}";
		when(userServiceMock.getUserByCredential(anyString(), anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/login")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User is registered successfully by admin
	 * @throws Exception
	 */
	@Test
	public void createUserByAdminTestSuccess() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.createUserByAdmin(anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Created User Successfully\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * User is not registered successfully by admin
	 * @throws Exception
	 */
	@Test
	public void createUserByAdminTestFail() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		when(userServiceMock.createUser(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"500\",\"description\":\"User Not Created\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * findUserByEmail - user found
	 * @throws Exception
	 */
	@Test
	public void findUserByEmailTestSuccess() throws Exception {
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.getUserByEmail(anyString())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user?email=test@gmail.com")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"User Found\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * findUserByEmail - user not found
	 * @throws Exception
	 */
	@Test
	public void findUserByEmailTestFail() throws Exception {
		when(userServiceMock.getUserByEmail(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user?email=test@gmail.com")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * listAllUsers - list 2 users
	 * @throws Exception
	 */
	@Test public void listAllUsersTestSuccess() throws Exception {
		User u = new User();
		u.setId("1001");
		User u1 = new User();
		u.setId("10012");
		List<User> users = new ArrayList<>();
		users.add(u);
		users.add(u1);
		when(userServiceMock.listUsers()).thenReturn(users);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/allusers")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found 2 users.\","
				+ "\"data\":"
					+ "["
						+ "{\"id\":\"10012\","
						+ "\"firstName\":null,"
						+ "\"lastName\":null,"
						+ "\"emailAddress\":null,"
						+ "\"password\":null,"
						+ "\"report\":null,"
						+ "\"role\":null,"
						+ "\"status\":null,"
						+ "\"approvedBy\":null,"
						+ "\"approvedOn\":null},"
						+ "{\"id\":null,"
						+ "\"firstName\":null,"
						+ "\"lastName\":null,"
						+ "\"emailAddress\":null,"
						+ "\"password\":null,"
						+ "\"report\":null,"
						+ "\"role\":null,"
						+ "\"status\":null,"
						+ "\"approvedBy\":null,"
						+ "\"approvedOn\":null}]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * listAllUsers - list 0 users
	 * @throws Exception
	 */
	@Test public void listAllUsersTestFail() throws Exception {
		List<User> users = new ArrayList<>();
		when(userServiceMock.listUsers()).thenReturn(users);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/allusers")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * findUserById - user found
	 * @throws Exception
	 */
	@Test
	public void findUserByIdTestSuccess() throws Exception {
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1001")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Found a User\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * findUserById - user found
	 * @throws Exception
	 */
	@Test
	public void findUserByIdTestFail() throws Exception {
		when(userServiceMock.findUserById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/1001")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * updateUser:
	 * @throws Exception
	 */
	@Test
	public void updateUserTestSuccess() throws Exception {
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test_new");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.updateUser(anyObject())).thenReturn(u);
		String userJSON = "{\n" +  
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test_new\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"Updated the user\","
				+ "\"data\":{\"id\":null,"
				+ "\"firstName\":\"Test_new\","
				+ "\"lastName\":\"Test\","
				+ "\"emailAddress\":\"test@gmail.com\","
				+ "\"password\":\"pass\","
				+ "\"report\":null,"
				+ "\"role\":\"prof\","
				+ "\"status\":\"APPROVAL\","
				+ "\"approvedBy\":null,"
				+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}
	
	/**
	 * updateUser:
	 * @throws Exception
	 */
	@Test
	public void updateUserTestFail() throws Exception {
		when(userServiceMock.updateUser(anyObject())).thenReturn(null);
		String userJSON = "{\n" +  
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test_new\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * deleteUserById - user found
	 * @throws Exception
	 */
	@Test
	public void deleteUserByIdTestSuccess() throws Exception {
		when(userServiceMock.deleteUser(anyObject())).thenReturn(true);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/1001");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Deleted the user Successfully...\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * deleteUserById - user not found
	 * @throws Exception
	 */
	@Test
	public void deleteUserByIdTestFail() throws Exception {
		when(userServiceMock.deleteUser(anyObject())).thenReturn(false);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/1001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"409\",\"description\":\"Could not delete User\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void approveActiveUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"ACTIVE\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("ACTIVE");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.approveUser(anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/approve")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"203\","
				+ "\"description\":\"User already approved\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void approveApprovalUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		User u1 = new User();
		u1.setId("1001");
		u1.setFirstName("Test");
		u1.setLastName("Test");
		u1.setEmailAddress("test@gmail.com");
		u1.setPassword("pass");
		u1.setRole("prof");
		u1.setStatus("ACTIVE");
		when(userServiceMock.approveUser(anyObject())).thenReturn(u1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/approve")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"User approval successful\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"ACTIVE\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void approveNullUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.approveUser(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/approve")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"202\",\"description\":\"User approval failed\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void rejectRejectedUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"REJECTED\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("REJECTED");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.rejectUser(anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/reject")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"205\","
				+ "\"description\":\"User already rejected\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"REJECTED\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
		
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void rejectApprovalUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		User u1 = new User();
		u1.setId("1001");
		u1.setFirstName("Test");
		u1.setLastName("Test");
		u1.setEmailAddress("test@gmail.com");
		u1.setPassword("pass");
		u1.setRole("prof");
		u1.setStatus("REJECTED");
		when(userServiceMock.rejectUser(anyObject())).thenReturn(u1);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/reject")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\","
				+ "\"description\":\"User rejection successful\","
				+ "\"data\":{\"id\":\"1001\","
					+ "\"firstName\":\"Test\","
					+ "\"lastName\":\"Test\","
					+ "\"emailAddress\":\"test@gmail.com\","
					+ "\"password\":\"pass\","
					+ "\"report\":null,"
					+ "\"role\":\"prof\","
					+ "\"status\":\"REJECTED\","
					+ "\"approvedBy\":null,"
					+ "\"approvedOn\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * approveUser: admin approves a user
	 * @throws Exception
	 */
	@Test
	public void rejectNullUserTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("prof");
		u.setStatus("APPROVAL");
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.rejectUser(anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/reject")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"204\",\"description\":\"User rejection failed\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void studentEnrollInCourseSuccessTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		
		Course c = new Course();
		c.set_id("12321");
		c.setCourseName("PDP");
		List<String> cls = new ArrayList<>();
		cls.add("12321");
		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(cls);
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.enrollInCourse(anyObject(), anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/enroll/1001")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Course enrollment successful\",\"data\":{\"id\":\"1001\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"emailAddress\":\"test@gmail.com\",\"password\":\"pass\",\"report\":null,\"role\":\"Student\",\"status\":\"APPROVAL\",\"approvedBy\":null,\"approvedOn\":null,\"courseEnrolled\":[\"12321\"],\"userCreationDate\":null,\"operations\":null,\"threshold\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void studentEnrollInCourseFailTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		
		Course c = new Course();
		c.set_id("12321");
		c.setCourseName("PDP");
		List<String> cls = new ArrayList<>();
		cls.add("12321");
		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(cls);
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.enrollInCourse(anyObject(), anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/enroll/1001")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"208\",\"description\":\"Course enrollment failed\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void studentDropCourseSuccessTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(new ArrayList<>());
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.dropCourse(anyObject(), anyObject())).thenReturn(u);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/drop/1001")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Course drop successful\",\"data\":{\"id\":\"1001\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"emailAddress\":\"test@gmail.com\",\"password\":\"pass\",\"report\":null,\"role\":\"Student\",\"status\":\"APPROVAL\",\"approvedBy\":null,\"approvedOn\":null,\"courseEnrolled\":[],\"userCreationDate\":null,\"operations\":null,\"threshold\":null}}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void studentDropCourseFailTest() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(new ArrayList<>());
		
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		when(userServiceMock.dropCourse(anyObject(), anyObject())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/student/drop/1001")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"208\",\"description\":\"Course drop failed\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void getStudentsByFacultyIdSuccessTest() throws Exception {		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(new ArrayList<>());
		List<User> uls = new ArrayList<>();
		uls.add(u);
		
		Course c = new Course();
		c.set_id("12321");
		c.setCourseName("PDP");
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		
		when(courseServiceMock.findCourseByProfId(anyString())).thenReturn(cls);
		when(courseServiceMock.findAllStudentsByCourseId(anyString())).thenReturn(uls);
		when(userServiceMock.findUserByIds(anyObject())).thenReturn(uls);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/students/1001")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":\"Found 1 students\",\"data\":[{\"id\":\"1001\",\"firstName\":\"Test\",\"lastName\":\"Test\",\"emailAddress\":\"test@gmail.com\",\"password\":\"pass\",\"report\":null,\"role\":\"Student\",\"status\":\"APPROVAL\",\"approvedBy\":null,\"approvedOn\":null,\"courseEnrolled\":[],\"userCreationDate\":null,\"operations\":null,\"threshold\":null}]}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	/**
	 * studentEnrollInCourse
	 * @throws Exception
	 */
	@Test
	public void getStudentsByFacultyIdFailTest() throws Exception {		
		User u = new User();
		u.setId("1001");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setEmailAddress("test@gmail.com");
		u.setPassword("pass");
		u.setRole("Student");
		u.setStatus("APPROVAL");
		u.setCourseEnrolled(new ArrayList<>());
		List<User> uls = new ArrayList<>();
		uls.add(u);
		
		Course c = new Course();
		c.set_id("12321");
		c.setCourseName("PDP");
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		
		when(courseServiceMock.findCourseByProfId(anyString())).thenReturn(cls);
		when(courseServiceMock.findAllStudentsByCourseId(anyString())).thenReturn(uls);
		when(userServiceMock.findUserByIds(anyObject())).thenReturn(new ArrayList<>());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/123/students/1001")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"404\",\"description\":\"User Not Found\",\"data\":null}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetApi() throws Exception {
		when(userServiceMock.findUserById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/test/1001")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":null,\"data\":\"Working Fine....\"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testPutApi() throws Exception {
		String userJSON = "{\n" + 
				"    \"_id\": \"1001\",\n" +  
				"    \"firstName\": \"Test\",\n" + 
				"    \"lastName\": \"Test\",\n" + 
				"    \"emailAddress\": \"test@gmail.com\",\n" + 
				"    \"password\": \"pass\",\n" + 
				"    \"role\": \"prof\",\n" + 
				"    \"status\": \"APPROVAL\"\n" + 
				"}";
		when(userServiceMock.findUserById(anyString())).thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/test/1001")
				.accept(MediaType.APPLICATION_JSON)
				.content(userJSON)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String responseJSON = "{\"status\":\"200\",\"description\":null,\"data\":\"Working Fine....\"}";
		JSONAssert.assertEquals(responseJSON, result.getResponse().getContentAsString(), false);
	}
}

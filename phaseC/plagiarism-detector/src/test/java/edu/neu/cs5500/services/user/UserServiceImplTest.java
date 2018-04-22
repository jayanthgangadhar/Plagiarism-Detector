/**
 * Test class for UserServiceImpl
 */

package edu.neu.cs5500.services.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.dao.user.UserDao;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
	@TestConfiguration
	static class UserServiceImplTestConfiguration {
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}
	
	@Autowired
	private UserService us;
	
	@MockBean
	private UserDao mockedUserDao;
	
	@MockBean
	private CourseService mockedCourseService;
	
	/**
	 * Test for create user
	 */
	@Test
	public void testCreateUser() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.createUser(u)).thenReturn(u);
		assertEquals(u, us.createUser(u));
	}
	
	/**
	 * Test for update user when is updated successfully
	 */
	@Test
	public void testUpdateUserSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		u.setThreshold(51.0);
		when(mockedUserDao.updateUser(u)).thenReturn(true);
		when(mockedUserDao.findUserById(u.getId())).thenReturn(u);
		assertEquals(u, us.updateUser(u));
	}
	
	/**
	 * Test for update user when is updated successfully
	 */
	@Test
	public void testUpdateUserSuccess0() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		u.setThreshold(51.0);
		when(mockedUserDao.updateUser(u)).thenReturn(false);
		when(mockedUserDao.findUserById(u.getId())).thenReturn(u);
		assertEquals(null, us.updateUser(u));
	}
	
	/**
	 * Test for update user when is updated successfully
	 */
	@Test
	public void testUpdateUserSuccess1() {
		User input = new User();
		input.setId("1");
		
		User find = new User();
		find.setEmailAddress("test@email.com");
		find.setFirstName("Test");
		find.setLastName("Test");
		find.setId("1");
		find.setPassword("Pass");
		find.setRole("Stud");
		find.setReport(null);
		find.setThreshold(51.0);
		
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedUserDao.findUserById(anyString())).thenReturn(find);
		assertEquals(find, us.updateUser(input));
	}
	
	/**
	 * Test for update user when is updated successfully
	 */
	@Test
	public void testUpdateUserSuccess2() {
		User input = new User();
		input.setEmailAddress("test@email.com");
		input.setFirstName("Test");
		input.setLastName("Test");
		input.setId("1");
		input.setPassword("Pass");
		input.setRole("Stud");
		input.setReport(null);
		input.setThreshold(51.0);
		input.setStatus("ACTIVE");
		input.setApprovedBy("123");
		input.setApprovedOn(new Date());
		input.setCourseEnrolled(new ArrayList<>());
		input.setReport(new Report());
		
		User find = new User();
		find.setEmailAddress("test@email.com");
		find.setFirstName("Test");
		find.setLastName("Test");
		find.setId("1");
		find.setPassword("Pass");
		find.setRole("Stud");
		find.setReport(null);
		find.setThreshold(51.0);
		
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedUserDao.findUserById(anyString())).thenReturn(find);
		assertEquals(find, us.updateUser(input));
	}
	
	/**
	 * Test for update user when is not updated successfully
	 */
	@Test
	public void testUpdateUserFail() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.updateUser(u)).thenReturn(false);
		assertEquals(null, us.updateUser(u));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testListUsersSuccess() {
		User u = new User();
		u.setId("12");
		User u1 = new User();
		u1.setId("13");
		List<User> testUsers = new ArrayList<>();
		testUsers.add(u);
		testUsers.add(u1);
		List<String> inputls = new ArrayList<>();
		inputls.add("12");
		inputls.add("13");
		when(mockedUserDao.listUsers(anyObject())).thenReturn(testUsers);
		assertEquals(testUsers, us.listUsers(inputls));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testListUsersSuccess1() {
		User u = new User();
		u.setId("12");
		User u1 = new User();
		u1.setId("13");
		List<User> testUsers = new ArrayList<>();
		testUsers.add(u);
		testUsers.add(u1);
		List<String> inputls = new ArrayList<>();
		inputls.add("12");
		inputls.add("13");
		when(mockedUserDao.listUsers(anyObject())).thenReturn(null);
		assertEquals(new ArrayList<>(), us.listUsers(inputls));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testListUsersSuccess2() {
		User u = new User();
		u.setId("12");
		User u1 = new User();
		u1.setId("13");
		List<User> testUsers = new ArrayList<>();
		testUsers.add(u);
		testUsers.add(u1);
		List<String> inputls = new ArrayList<>();
		inputls.add("12");
		inputls.add("13");
		when(mockedUserDao.listUsers(anyObject())).thenReturn(new ArrayList<>());
		assertEquals(new ArrayList<>(), us.listUsers(inputls));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testListUsersSuccess3() {
		User u = new User();
		u.setId("12");
		User u1 = new User();
		u1.setId("13");
		List<User> testUsers = new ArrayList<>();
		testUsers.add(u);
		testUsers.add(u1);
		when(mockedUserDao.listUsers()).thenReturn(testUsers);
		assertEquals(testUsers, us.listUsers());
	}
	
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Professor");
		u.setReport(null);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserStudentSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Student");
		u.setReport(null);
		List<String> studentList = new ArrayList<>();
		studentList.add("1");
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> courseList = new ArrayList<>();
		courseList.add("123");
		c.setStudentsEnrolled(studentList);

		u.setCourseEnrolled(courseList);
		
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when false
	 */
	@Test
	public void testDeleteUserFail() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.deleteUser(u)).thenReturn(false);
		assertEquals(false, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess1() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Professor");
		u.setReport(null);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(null);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess2() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Professor");
		u.setReport(null);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(null);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(false, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess3() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Student");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess4() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Student");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess5() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Student");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		//c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(true, us.deleteUser("1"));
	}
	
	/**
	 * Test for delete user when true
	 */
	@Test
	public void testDeleteUserProfSuccess6() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Student");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedCourseService.findCourseByProfId(anyString())).thenReturn(courseList);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(null);
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.deleteUser(anyObject())).thenReturn(true);
		assertEquals(false, us.deleteUser("1"));
	}
	
	/**
	 * Test for addrole
	 */
	@Test
	public void testAddRole() {
		assertEquals(null, us.addRole("test.test@test.com"));
	}
	
	/**
	 * Test for getUserByEmail when the user is found in the database
	 */
	@Test
	public void testGetUserByEmailSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.findUserByEmail("some@email.com")).thenReturn(u);
		assertEquals(u, us.getUserByEmail("some@email.com"));
	}
	
	/**
	 * Test for getUserByEmail when the user is not found in the database
	 */
	@Test
	public void testGetUserByEmailFail() {
		when(mockedUserDao.findUserByEmail("some@email.com")).thenReturn(null);
		assertEquals(null, us.getUserByEmail("some@email.com"));
	}
	
	/**
	 * Test for getUserByCredential when the user is found in the database
	 */
	@Test
	public void testGetUserByCredentialSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.findUserByCredential("some@email.com", "pass")).thenReturn(u);
		assertEquals(u, us.getUserByCredential("some@email.com", "pass"));
	}
	
	/**
	 * Test for getUserByCredential when the user is not found in the database
	 */
	@Test
	public void testGetUserByCredentialFail() {
		when(mockedUserDao.findUserByCredential("some@email.com", "pass")).thenReturn(null);
		assertEquals(null, us.getUserByCredential("some@email.com", "pass"));
	}
	
	/**
	 * Test for findUserById when the user is found in the database
	 */
	@Test
	public void testFindUserByIdSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserDao.findUserById("1")).thenReturn(u);
		assertEquals(u, us.findUserById("1"));
	}
	
	/**
	 * Test for findUserById when the user is not found in the database
	 */
	@Test
	public void testFindUserByIdFail() {
		when(mockedUserDao.findUserById("1")).thenReturn(null);
		assertEquals(null, us.findUserById("1"));
	}
	
	/**
	 * Test for findUserByIds when the user is found in the database
	 */
	@Test
	public void testFindUserByIdsSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		List<String> uids = new ArrayList<>();
		uids.add("1");
		List<User> uls = new ArrayList<>();
		uls.add(u);
		when(mockedUserDao.findUserByIds(anyObject())).thenReturn(uls);
		assertEquals(uls, us.findUserByIds(uids));
	}
	
	/**
	 * Test for createUserByAdmin when the user is found in the database
	 */
	@Test
	public void testcreateUserByAdminSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("APPROVE");
		u.setReport(null);
		when(mockedUserDao.createUserByAdmin(anyObject())).thenReturn(u);
		assertEquals(u, us.createUserByAdmin(u));
	}
	
	/**
	 * Test for createUserByAdmin when the user is found in the database
	 */
	@Test
	public void testcreateUserByAdminFail() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("APPROVE");
		u.setReport(null);
		when(mockedUserDao.createUserByAdmin(anyObject())).thenReturn(null);
		assertEquals(null, us.createUserByAdmin(u));
	}
	
	/**
	 * Test for getCourseEnrolled when the user is not found in the database
	 */
	@Test
	public void testgetCourseEnrolledFail() {
		when(mockedUserDao.findUserById(anyObject())).thenReturn(null);
		assertEquals(new ArrayList<>(), us.getCourseEnrolled("123"));
	}
	
	/**
	 * Test for getCourseEnrolled when the user is found in the database
	 */
	@Test
	public void testgetCourseEnrolledSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("APPROVE");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedUserDao.findUserById(anyObject())).thenReturn(u);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		assertEquals(courseList, us.getCourseEnrolled("123"));
	}
	
	/**
	 * Test for getCourseEnrolled when the user is found in the database
	 */
	@Test
	public void testgetCourseEnrolledSuccess1() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("APPROVE");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		List<Course> courseList = new ArrayList<>();
		courseList.add(c);
		
		when(mockedUserDao.findUserById(anyObject())).thenReturn(u);
		when(mockedCourseService.listCourses(cls)).thenReturn(courseList);
		assertEquals(new ArrayList<>(), us.getCourseEnrolled("123"));
	}
	
	
	
	/**
	 * Test for approveUser when the user is found in the database
	 */
	@Test
	public void testApproveUserSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("ACTIVE");
		u.setReport(null);
		when(mockedUserDao.approveUserDao(anyObject())).thenReturn(u);
		assertEquals(u, us.approveUser(u));
	}
	
	/**
	 * Test for rejectUser when the user is found in the database
	 */
	@Test
	public void testRejectUserSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		when(mockedUserDao.rejectUserDao(anyObject())).thenReturn(u);
		assertEquals(u, us.rejectUser(u));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail() {
		User u = new User();		
		assertEquals(null, us.enrollInCourse(u, null));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail1() {		
		Course c = new Course();		
		assertEquals(null, us.enrollInCourse(null, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail2() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(null);
		assertEquals(null, us.enrollInCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail3() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		assertEquals(null, us.enrollInCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail4() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		assertEquals(null, us.enrollInCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(u, us.enrollInCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testEnrollInCourseFail6() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(false);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(null, us.enrollInCourse(u, c));
	}
	
	/**
	 * Test for dropCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail() {
		User u = new User();		
		assertEquals(null, us.dropCourse(u, null));
	}
	
	/**
	 * Test for dropCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail1() {		
		Course c = new Course();		
		assertEquals(null, us.dropCourse(null, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(u, us.dropCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail2() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(null, us.dropCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail4() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(null, us.dropCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail3() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(true);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(null);
		assertEquals(null, us.dropCourse(u, c));
	}
	
	/**
	 * Test for enrollInCourse when the user is found in the database
	 */
	@Test
	public void testDropCourseFail5() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		u.setReport(null);
		List<String> cls = new ArrayList<>();
		cls.add("123");
		u.setCourseEnrolled(cls);
		
		Course c = new Course();
		c.set_id("123");
		c.setCourseName("PDP");
		List<String> uls = new ArrayList<>();
		uls.add("1");
		c.setStudentsEnrolled(uls);
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		when(mockedUserDao.updateUser(anyObject())).thenReturn(false);
		when(mockedCourseService.findCourseById(anyString())).thenReturn(c);
		when(mockedCourseService.updateCourse(anyObject())).thenReturn(c);
		assertEquals(null, us.dropCourse(u, c));
	}
	
	/**
	 * Test for getUserFullNameById when the user is found in the database
	 */
	@Test
	public void testGetUserFullNameById() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setStatus("REJECT");
		
		when(mockedUserDao.findUserById(anyString())).thenReturn(u);
		assertEquals("Test Test", us.getUserFullNameById("1"));
	}
	
	/**
	 * Test for getUserFullNameById when the user is found in the database
	 */
	@Test
	public void testGetUserFullNameById1() {
		when(mockedUserDao.findUserById(anyString())).thenReturn(null);
		assertEquals(null, us.getUserFullNameById("1"));
	}
	
	
}

package edu.neu.cs5500.dao.user;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.repository.UserRepository;


@RunWith(SpringRunner.class)
public class UserDaoImplTest {

	@TestConfiguration
	static class UserDaoImplTestConfiguration {
		@Bean
		public UserDao userDao() {
			return new UserDaoImpl();
		}
	}
	
	@Autowired
	private UserDao ud;
	
	@MockBean
	private UserRepository mockedUserRepository;
	
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
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(u, ud.createUser(u));
	}
	
	/**
	 * Test for findUserByCredential when the user is found in the database
	 */
	@Test
	public void testFindUserByCredentialSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setPassword("Pass");
		when(mockedUserRepository.findByEmailAddress(anyString())).thenReturn(null);
		//when(BCrypt.checkpw("Pass", "dsfs")).thenReturn(true);
		assertEquals(null, ud.findUserByCredential("test@email.com", "Pass"));
	}
	
	/**
	 * Test for findUserByCredential when the user is not found in the database
	 */
	@Test
	public void testFindUserByCredentialFail() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setPassword("Pass");
		when(mockedUserRepository.findByEmailAddressAndPassword(anyString(), anyString())).thenReturn(null);
		assertEquals(null, ud.findUserByCredential("test@email.com", "Pass1"));
	}
	
	/**
	 * Test for updateUser when the user is found in the database
	 */
	@Test
	public void testupdateUserSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserRepository.findById(u.getId())).thenReturn(u);
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(true, ud.updateUser(u));
	}
	
	/**
	 * Test for updateUser when the user is not found in the database
	 */
	@Test
	public void testupdateUserFail() {
		User u = new User();
		when(mockedUserRepository.findById(u.getId())).thenReturn(null);
		assertEquals(false, ud.updateUser(u));
	}
	
	/**
	 * Test for updateUser when the user is found in the database 
	 * and firstname, lastname and role is null
	 */
	@Test
	public void testUpdateUserFirstNameNull() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName(null);
		u.setLastName(null);
		u.setId("1");
		u.setPassword("Pass");
		u.setRole(null);
		u.setReport(null);
		u.setStatus("ACTIVE");
		when(mockedUserRepository.findById(u.getId())).thenReturn(u);
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(true, ud.updateUser(u));
	}
	
	/**
	 * Test for findAll not null list of users
	 */
	@Test
	public void testListUsers() {
		User u = new User();
		User u1 = new User();
		List<User> testUsers = new ArrayList<>();
		testUsers.add(u);
		testUsers.add(u1);
		when(mockedUserRepository.findAll()).thenReturn(testUsers);
		assertEquals(testUsers, ud.listUsers());
	}
	
	/**
	 * Test for findAll null list of users
	 */
	@Test
	public void testListUsersNull() {
		when(mockedUserRepository.findAll()).thenReturn(null);
		assertEquals(new ArrayList<>(), ud.listUsers());
	}
	
	/**
	 * Test for deleteUsers success
	 */
	@Test
	public void testdeleteUserSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName(null);
		u.setLastName(null);
		u.setId("1");
		u.setPassword("Pass");
		u.setRole(null);
		u.setReport(null);
		when(mockedUserRepository.findById(anyString())).thenReturn(u);
		assertEquals(true, ud.deleteUser(u));
	}
	
	/**
	 * Test for deleteUsers false
	 */
	@Test
	public void testDeleteUserFail() {
		User u = new User();
		when(mockedUserRepository.findById(anyString())).thenReturn(null);
		assertEquals(true, ud.deleteUser(u));
	}
	
	/**
	 * Test for findUserByEmail Success
	 */
	@Test
	public void testfindUserByEmailSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName(null);
		u.setLastName(null);
		u.setId("1");
		u.setPassword("Pass");
		u.setRole(null);
		u.setReport(null);
		when(mockedUserRepository.findByEmailAddress(anyString())).thenReturn(u);
		assertEquals(u, ud.findUserByEmail("test@email.com"));
	}
	
	/**
	 * Test for findUserByEmail fail
	 */
	@Test
	public void testfindUserByEmailFail() {
		when(mockedUserRepository.findByEmailAddress(anyString())).thenReturn(null);
		assertEquals(null, ud.findUserByEmail("test@email.com"));
	}
	
	/**
	 * Test for findUserById Success
	 */
	@Test
	public void testFindUserByIdSuccess() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName(null);
		u.setLastName(null);
		u.setId("1");
		u.setPassword("Pass");
		u.setRole(null);
		u.setReport(null);
		when(mockedUserRepository.findById(anyString())).thenReturn(u);
		assertEquals(u, ud.findUserById("SomeID"));
	}
	
	/**
	 * Test for findUserByEmail fail
	 */
	@Test
	public void testFindUserByIdFail() {
		when(mockedUserRepository.findById(anyString())).thenReturn(null);
		assertEquals(null, ud.findUserById("SomeID"));
	}
	
	/**
	 * Test for createUserByAdmin fail
	 */
	@Test
	public void testCreateUserByAdmin() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Stud");
		u.setReport(null);
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(u, ud.createUserByAdmin(u));
	}
	
	/**
	 * Test for approveUserDao fail
	 */
	@Test
	public void testApproveUser() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Prof");
		u.setReport(null);
		u.setStatus("APPROVE");
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(u, ud.approveUserDao(u));
	}
	
	/**
	 * Test for rejectUserDao fail
	 */
	@Test
	public void testRejectUserDao() {
		User u = new User();
		u.setEmailAddress("test@email.com");
		u.setFirstName("Test");
		u.setLastName("Test");
		u.setId("1");
		u.setPassword("Pass");
		u.setRole("Prof");
		u.setReport(null);
		u.setStatus("REJECT");
		when(mockedUserRepository.save((User)anyObject())).thenReturn(u);
		assertEquals(u, ud.rejectUserDao(u));
	}
}

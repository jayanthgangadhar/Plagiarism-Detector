package edu.neu.cs5500.services.user;

import java.util.List;

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;

public interface UserService {


	/**
	 * @param u
	 * @return
	 * method to create a user
	 */
	public User createUser(User u);
	
    /**
     * @param p
     */
    /**
     * @param Update user method
     */
    public User updateUser(User p);
    
    /**
     * @return List all Users
     */
    public List<User> listUsers();
    
    /**
     * @return List all Users with the given user ids
     */
    public List<User> listUsers(List<String> userIds);
    
    /**
     * @param id
     * @return
     * returns the user data on the basis of given iD
     */
    
    public boolean deleteUser(String id);
    
	/**
	 * @param emailAddress
	 * @return
	 */
	public User getUserByEmail(String emailAddress);
	
	/**
	 * @param userEmail
	 * @return
	 * adding a role to the current user
	 */
	public String addRole(String userEmail);
	
	/**
	 * @param userEmail
	 * @return
	 * 
	 * get all the operation history of the input user
	 */

	
	/**
	 * @param userEmail
	 * @param password
	 * @return The used for which the credentials are matched in the database
	 */
	public User getUserByCredential(String userEmail, String password);
	
	/**
	 * @param id
	 * @return the user for which the id is matched in the database 
	 */
	public User findUserById(String id);
	
	/**
	 * @param id
	 * @return the users for which the ids is matched in the database 
	 */
	public List<User> findUserByIds(List<String> ids);

	/**
	 * @param id
	 * @return Create user by admin
	 */
	public User createUserByAdmin(User u);
	
	/**
	 * 
	 * @param u
	 * @return list of courses associated with this user
	 */
	public List<Course> getCourseEnrolled(String u);

	/**
	 * 
	 * @param p the user who will be approved
	 * @return the approved user
	 */
	public User approveUser(User p);
	
	/**
	 * 
	 * @param p the user who will be rejected
	 * @return the rejected user
	 */
	public User rejectUser(User p);

	/**
	 * 
	 * @param student: student who is going to enroll in the course
	 * @param course: course to be enrolled in
	 * @return
	 */
	public User enrollInCourse(User student, Course course);
	
	/**
	 * 
	 * @param student: student who is going to drop the given course
	 * @param course: course to be dropped
	 * @return
	 */
	public User dropCourse(User student, Course course);
	
	
	
	public String getUserFullNameById(String id);

	
}

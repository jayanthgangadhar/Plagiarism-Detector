package edu.neu.cs5500.dao.user;

import java.util.List;

import edu.neu.cs5500.domainObjects.User;


public interface UserDao {
	
	/**
	 * @param u
	 * @return
	 * method to create a user
	 */
	public User createUser(User u);
    
    /**
     * @param p 
     * Update user method
     */
    public boolean updateUser(User p);
    
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
    
    public boolean deleteUser(User id);
    
	/**
	 * @param emailAddress
	 * @return
	 */
	public User findUserByEmail(String emailAddress);
	
	
	/**
	 * @param userEmail
	 * @return
	 * adding a role to the current user
	 */
	public String addRole(String userEmail);

	
	/**
	 * It will search and return the user in the database with the given
	 * email address and corresponding password else return null
	 * @param email
	 * @param password
	 */
	public User findUserByCredential(String email, String password);
	
	/**
	 * It will search and return the user in the database with the given
	 * id else return null
	 * @param email
	 * @param password
	 */
	public User findUserById(String id);
	
	/**
	 * It will search and return the user in the database with the given
	 * ids else return null
	 * @param 
	 */
	public Iterable<User> findUserByIds(List<String> ids);
	
	
	/**
	 * @param u
	 * @return
	 * method to create a user
	 */
	public User createUserByAdmin(User u);


	
	/**
	 * 
	 * @param p they user who will be approved
	 * @return the approved user
	 */
	public User approveUserDao(User p);
	
	/**
	 * 
	 * @param p they user who will be rejected
	 * @return the rejected user
	 */
	public User rejectUserDao(User p);
}

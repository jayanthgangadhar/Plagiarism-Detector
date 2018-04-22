package edu.neu.service;

import java.util.List;

import edu.neu.model.Operation;
import edu.neu.model.Report;
import edu.neu.model.User;

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
    public void updateUser(User p);
    /**
     * @return List all Users
     */
    public List<User> listUsers();
    /**
     * @param id
     * @return
     * returns the user data on the basis of given iD
     */
    
    public void deleteUser(int email);
	/**
	 * @param emailAddress
	 * @return
	 */
	public User getUserByEmail(String emailAddress);
	/**
	 * @param userEmail
	 * @return
	 * 
	 * Method to approve the USer
	 */
	public String approveUser(String userEmail);
	/**
	 * @param userEmail
	 * @return
	 * 
	 * method to reject a user approval request of given user
	 */
	public String rejectUser(String userEmail);
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
	public List<Operation> getUserHistory(String userEmail);
	
}

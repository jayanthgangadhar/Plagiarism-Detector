package edu.neu.cs5500.dao.user;

import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.repository.UserRepository;
import edu.neu.cs5500.utils.Constants;

import org.mindrot.jbcrypt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class.getName());
	
	@Autowired
	private UserRepository userRepository;

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.user.UserDao#createUser(edu.neu.cs5500.domainObjects.User)
	 */
	@Override
	public User createUser(User u) {
		User result =null;
		try {
			if(u.getRole().equalsIgnoreCase("Student")) {
				u.setStatus(Constants.ACTIVE);
			}
			else {
				u.setStatus(Constants.APPROVAL);
			}
			u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt())); 
			u.setThreshold(40.0);
			result = userRepository.save(u);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.user.UserDao#findUserByCredential(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUserByCredential(String email, String password) {
		User  foundUser = null;
		try {

			foundUser = userRepository.findByEmailAddress(email);
			if(foundUser != null && BCrypt.checkpw(password, foundUser.getPassword())) {
				return foundUser;
			}

		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		} 
		return null;
	}

	/**
	 * It will update the user in the database with the updated values
	 * present in the argument user object
	 * @param p
	 */
	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.user.UserDao#updateUser(edu.neu.cs5500.domainObjects.User)
	 */
	@Override
	public boolean updateUser(User p) {
		User u = null;
		try {
			u = userRepository.save(p);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return false;
		}
		return (u!=null);
	}

	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.user.UserDao#listUsers()
	 */
	@Override
	public List<User> listUsers() {
		Iterable<User> iterable = userRepository.findAll();
		if (iterable==null) {
			return new ArrayList<>();
		}
		return (List<User>)iterable;
	}
	
	@Override
	public List<User> listUsers(List<String> userIds) {
		Iterable<User> iterable = userRepository.findAll(userIds);
		if (iterable==null) {
			return new ArrayList<>();
		}
		return (List<User>)iterable;
	}



	/* (non-Javadoc)
	 * @see edu.neu.cs5500.dao.user.UserDao#deleteUser(edu.neu.cs5500.domainObjects.User)
	 */
	@Override
	public boolean deleteUser(User user) {
		try {
			if (user!=null) {
				userRepository.delete(user);			
				return true;
			}
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return false;
		}

		return false;
	}



	@Override
	public User findUserByEmail(String emailAddress) {

		try {
			User result = userRepository.findByEmailAddress(emailAddress);
			if (result!=null) {
				return result;
			}
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return null;
		}
		return null;
	}

	@Override
	public String addRole(String userEmail) {

		return null;
	}

	/**
	 * It will search and return the user in the database with the given
	 * id else return null
	 * @param email
	 */
	@Override
	public User findUserById(String id) {

		User user = null;

		try {
			user = userRepository.findById(id);

		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}		
		return user;
	}
	
	/**
	 * It will search and return the user in the database with the given
	 * ids else return null
	 * @param 
	 */
	public Iterable<User> findUserByIds(List<String> ids) {
		return userRepository.findAll(ids);
	}

	@Override
	public User createUserByAdmin(User u) {

		User result =null;
		try {

			if (u!=null) {
				u.setStatus(Constants.ACTIVE);
				u.setPassword(BCrypt.hashpw(u.getPassword(), BCrypt.gensalt()));
				u.setThreshold(40.0);
			}
			result = userRepository.save(u);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
	}

	/**
	 * 
	 * @param p they user who will be approved
	 * @return the approved user
	 */
	public User approveUserDao(User p) {
		try {
			p.setStatus(Constants.ACTIVE);
			userRepository.save(p);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return null;
		}
		return p;
	}

	/**
	 * 
	 * @param p they user who will be rejected
	 * @return the rejected user
	 */
	@Override
	public User rejectUserDao(User p) {
		try {
			p.setStatus("REJECTED");
			userRepository.save(p);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return p;
	}
}

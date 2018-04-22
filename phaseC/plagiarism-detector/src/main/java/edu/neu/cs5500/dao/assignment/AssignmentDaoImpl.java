/**
 * This is the DAO (data access object) layer implementation, which will interact
 * with the database
 * Implements AssignmentDao
 */
package edu.neu.cs5500.dao.assignment;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.repository.AssignmentRepository;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 * 
 */

@Repository("assignDao")
public class AssignmentDaoImpl implements AssignmentDao {

	// Logger
	private static Logger logger= Logger.getLogger(AssignmentDaoImpl.class.getName());
	
	@Autowired
	private AssignmentRepository assignRepo;
	
	/**
	 * called to create an assignment
	 * @param assign: the assignment object to be created
	 * @return the Assignment created
	 */
	@Override
	public Assignment createAssignment(Assignment assign) {
		Assignment assign1 = null;
		try {
			
			// save called
			assign1 = assignRepo.save(assign);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return assign1;
	}
	
	/**
	 * deletes an assignment
	 * @param assign: the assignment object to be deleted
	 */
	@Override
	public void deleteAssignment(Assignment assign) {
		try {
			assignRepo.delete(assign);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
	}
	
	/**
	 * Updates the assingment
	 * @param assign: the new assignment object
	 * @return the Assignment updated
	 */
	@Override
	public Assignment updateAssignment(Assignment assign) {
		Assignment assign1 = null;
		try {
			assign1 = assignRepo.save(assign);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return assign1;
	}
	
	/**
	 * 
	 * @return list of all the Assignments
	 */
	@Override
	public Iterable<Assignment> findAllAssignments() {
		Iterable<Assignment> it = null;
		try {
			it = assignRepo.findAll();
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return it;
	}
	
	/**
	 * 
	 * @param id: the assignment id to find
	 * @return the Assignment associated with the given id 
	 */
	@Override
	public Assignment findAssignmentById(String id) {
		Assignment assign1 = null;
		if(id != null) {
			try {
				assign1 = assignRepo.findOne(id);
			}
			catch(Exception e) {
				logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			}
		}
		return assign1;
	}
}

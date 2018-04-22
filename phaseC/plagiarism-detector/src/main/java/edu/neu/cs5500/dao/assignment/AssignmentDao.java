/**
 * 
 */
package edu.neu.cs5500.dao.assignment;

import edu.neu.cs5500.domainObjects.Assignment;

/**
 * @author sanketmathur
 *
 */
public interface AssignmentDao {

	/**
	 * 
	 * @param assign
	 * @return the Assignment created
	 * Method used to create an assignment in the DB
	 */
	Assignment createAssignment(Assignment assign);
	
	/**
	 * 
	 * @param assign
	 * @return true iff the Assignment is deleted from the database
	 */
	void deleteAssignment(Assignment assign);
	
	/**
	 * 
	 * @param assign
	 * @return the Assignment updated
	 * 
	 * Method used to updated the assignment in the db
	 */
	Assignment updateAssignment(Assignment assign);
	
	/**
	 * 
	 * @return list of all the Assignments
	 */
	Iterable<Assignment> findAllAssignments();
	
	/**
	 * 
	 * @param id
	 * @return the Assignment associated with the given id 
	 */
	Assignment findAssignmentById(String id);
}

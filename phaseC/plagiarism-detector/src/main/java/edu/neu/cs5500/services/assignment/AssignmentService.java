/**
 * 
 */
package edu.neu.cs5500.services.assignment;

import java.util.List;

import edu.neu.cs5500.domainObjects.Assignment;

/**
 * @author sanketmathur
 *
 */
public interface AssignmentService {

	/**
	 * 
	 * @param assign
	 * @return the Assignment created
	 */
	Assignment createAssignment(Assignment assign);
	
	/**
	 * 
	 * @param assign
	 * @return true iff the Assignment is deleted from the database
	 */
	boolean deleteAssignment(String assignId);
	
	/**
	 * 
	 * @param assign
	 * @return the Assignment updated
	 */
	Assignment updateAssignment(Assignment assign);
	
	/**
	 * 
	 * @return list of all the Assignments
	 */
	List<Assignment> findAllAssignments();
	
	/**
	 * 
	 * @param id
	 * @return the Assignment associated with the given id 
	 */
	Assignment findAssignmentById(String assignId);
	
	
	/**
	 * 
	 * @return list of all the Assignments
	 * related to this course
	 */
	List<Assignment> findAllCourseRelatedAssignments(String courseId);
}

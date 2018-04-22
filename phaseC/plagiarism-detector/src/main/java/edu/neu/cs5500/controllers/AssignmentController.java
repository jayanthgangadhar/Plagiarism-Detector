/**
 * This class will have all the apis related to the assignment
 * Will be used to interact with the front end
 */
package edu.neu.cs5500.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.storage.StorageService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

/**
 * @author sanketmathur
 */
@RestController
public class AssignmentController {
	
	// Logger
	private static Logger logger = Logger.getLogger(AssignmentController.class.getName());

	@Autowired
	private AssignmentService assignService;
	
	
	
	/**
	 * called to create an assignment
	 * @param userId: the user id of the person who is logged in
	 * @param assign: the assignment object which will be created
	 * @return assignment object as response

	 */
	@RequestMapping(value="/api/{userId}/assignment", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> createAssignment(@PathVariable String userId, @RequestBody Assignment assign) {
		ServiceResponse response = new ServiceResponse();
		Assignment s = assignService.createAssignment(assign);
		if (s != null) {
			logger.log(Level.INFO, "Created assignment successfully");
			Utility.setResponseObject(s, Constants.SUCCESS, "Created assignment successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		logger.log(Level.SEVERE, "Error Occured while creating assignment");
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "Assignment not created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param userId - logged in user ID
	 * @param assignId - Assignment id to be deleted
	 * @return response with no data

	 */
	@RequestMapping(value="/api/{userId}/assignment/remove/{assignId}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> deleteAssignemnt(@PathVariable String userId, @PathVariable String assignId) {
		ServiceResponse response = new ServiceResponse();
		if (assignService.deleteAssignment(assignId)) {
			logger.log(Level.INFO, "Deleted assignment successfully");
			Utility.setResponseObject(null, Constants.SUCCESS, "Deleted assignment Successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} 
		else {
			Utility.setResponseObject(null, "409", "Could not delete assignment", response);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	/**
	 * 
	 * @param userId - user who is logged in
	 * @param assign: the Assignment to be updated
	 * @return assignment object as response

	 */
	@RequestMapping(value="/api/{userId}/assignment", method=RequestMethod.PUT, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> updateAssignment(@PathVariable String userId, @RequestBody Assignment assign) {
		ServiceResponse response = new ServiceResponse();
		Assignment s = assignService.updateAssignment(assign);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Updated assignment successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.ASSIGNMENT_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get all the Assignments in a list
	 * @param userId - user who is logged in
	 * API endpoint to find all asisignments based on input user ID
	 * @return list of assignment objects object as response

	 */
	@RequestMapping(value="/api/{userId}/assignment", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findAllAssignments(@PathVariable String userId) {
		ServiceResponse response = new ServiceResponse();
		List<Assignment> slist = assignService.findAllAssignments();
		if (slist != null) {
			logger.log(Level.INFO, "Assignments found for user ID:" + userId);
			Utility.setResponseObject(slist, Constants.SUCCESS, "Found " + slist.size() + " Assignments", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.ASSIGNMENT_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get Assignments with the corresponding id
	 * @param userId - user who is logged in
	 * @return assignment object as response

	 */
	@RequestMapping(value="/api/{userId}/assignment/{assignId}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findAssignmentById(@PathVariable String userId, @PathVariable String assignId) {
		ServiceResponse response = new ServiceResponse();
		Assignment s = assignService.findAssignmentById(assignId);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Found Assignment", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.ASSIGNMENT_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	/**
	 * get all the Assignments in a list related to a course
	 * @param userId - user who is logged in
	 * @return list of assignment objects as response

	 */
	@RequestMapping(value="/api/{userId}/assignment/course/{courseId}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findAssignmentByCourseId(@PathVariable String userId, @PathVariable String courseId) {
		ServiceResponse response = new ServiceResponse();
		List<Assignment> s = assignService.findAllCourseRelatedAssignments(courseId);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Found " + s.size() + " Assignments", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.ASSIGNMENT_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

}

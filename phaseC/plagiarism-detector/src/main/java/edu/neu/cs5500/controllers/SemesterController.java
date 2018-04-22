/**
 * Controller class which will act as interface between frontend and backend
 * store all the api methods calls needed by the front end
 */
package edu.neu.cs5500.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.services.semester.SemesterService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

/**
 * @author sanketmathur
 *Controller which has all operations related to the the semester entity
 */
@RestController
public class SemesterController {
	
	@Autowired
	SemesterService semService;
	
	/**
	 * called to create a semester
	 * @param sem - semester object to be created
	 * @param userId - user logged in
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> createSemester(@RequestBody Semester sem, @PathVariable String userId) {
		ServiceResponse response = new ServiceResponse();
		Semester s = semService.createSemester(sem);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Created Semester", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(s, Constants.FAILURE, "Semester Not Created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * called to delete a semester
	 * @param userId - user logged in
	 * @param semId - semester id to be deleted
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester/remove/{semId}", method=RequestMethod.DELETE, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> deleteSemester(@PathVariable String userId, @PathVariable String semId) {
		ServiceResponse response = new ServiceResponse();
		if (semService.deleteSemester(semId)) {
			Utility.setResponseObject(null, Constants.SUCCESS, "Deleted semester Successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} 
		else {
			Utility.setResponseObject(null, "409", "Could not delete semester", response);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	/**
	 * called to update an existing semester with the given semester object
	 * @param userId - user who is logged in
	 * @param sem: the semester to be updated
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester", method=RequestMethod.PUT, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> updateSemester(@PathVariable String userId, @RequestBody Semester sem) {
		ServiceResponse response = new ServiceResponse();
		Semester s = semService.updateSemester(sem);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Updated semester successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.SEMESTER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get all the semesters in a list
	 * @param userId - user who is logged in
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findAllSemesters(@PathVariable String userId) {
		ServiceResponse response = new ServiceResponse();
		List<Semester> slist = semService.findAllSemesters();
		if (slist != null) {
			Utility.setResponseObject(slist, Constants.SUCCESS, "Found " + slist.size() + " semesters", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.SEMESTER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * find semester by a given semester id
	 * @param userId - user who is logged in
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester/{semId}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findSemestersById(@PathVariable String userId, @PathVariable String semId) {
		ServiceResponse response = new ServiceResponse();
		Semester s = semService.findSemesterById(semId);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Semester found", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null,Constants.ERROR_CODE_NOTFOUND, Constants.SEMESTER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get all the active semesters in a list
	 * @param userId - user who is logged in
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/semester/active", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findAllActiveSemesters(@PathVariable String userId) {
		ServiceResponse response = new ServiceResponse();
		List<Semester> slist = semService.findAllActiveSemesters();
		if (slist != null) {
			Utility.setResponseObject(slist, Constants.SUCCESS, "Found " + slist.size() + " semesters", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.SEMESTER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

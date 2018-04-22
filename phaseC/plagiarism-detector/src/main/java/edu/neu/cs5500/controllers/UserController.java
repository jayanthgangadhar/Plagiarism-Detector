/**
 * Controller class which will act as interface between frontend and backend
 */
package edu.neu.cs5500.controllers;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;


/**
 * @author asimkhan
 * @author sanketmathur
 */
@RestController
public class UserController {

	// Logger
	private static Logger logger = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;

	
	/*@Autowired
	private TokenProvider tokenProvider;*/
	
	/**
	 * Register a user into the system by making an entry in the database
	 * @param user: the user object
	 * @return created user object as response
	 */
	@RequestMapping(value = "/api/register", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> registerUser(@RequestBody User user) {
		
		ServiceResponse response = new ServiceResponse();
		User p = userService.createUser(user);

		if (p != null) {
			
			Utility.setResponseObject(p, Constants.SUCCESS, "Created User", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(p, "500", "User Not Created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Login the user into the system by checking whether the credentials are
	 * correct or not
	 * @param user: the user object with username and password
	 * @return user obejct as response
	 */
	@RequestMapping(value = "/api/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> loginUser(@RequestBody User user) {

		ServiceResponse response = new ServiceResponse();
		User p = userService.getUserByCredential(user.getEmailAddress(), user.getPassword());
		if (p != null && p.getStatus().equals("ACTIVE")) {
			
			
			Utility.setResponseObject(p, Constants.SUCCESS, "User was found", response);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else if (p != null && p.getStatus().equals("REJECTED")) {
			Utility.setResponseObject(p, "206", "User account has been rejected. Contant support", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else if (p != null && p.getStatus().equals("APPROVAL")) {
			Utility.setResponseObject(p, "207", "User account needed approval prior login. Contact support", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Register a user into the system by making an entry in the database
	 * The task will be performed by the admin
	 * @param user: the user object
	 * @return created user object as response
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> createUserByAdmin(@RequestBody User user) {
		ServiceResponse response = new ServiceResponse();
		User p = userService.createUserByAdmin(user);

		if (p != null) {
			Utility.setResponseObject(p, Constants.SUCCESS, "Created User Successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(p, "500", "User Not Created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Search for a user with the given email address
	 * @param emailAddress
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> findUserByEmail(@RequestParam("email") String emailAddress) {

		ServiceResponse response = new ServiceResponse();
		// service call
		User user = userService.getUserByEmail(emailAddress);

		if (user == null) {
			Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Utility.setResponseObject(user, Constants.SUCCESS, "User Found", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	/**
	 * List all the users in the database
	 * @return list of user objects as response
	 */
	@RequestMapping(value = "/api/allusers", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> listAllUsers() {

		ServiceResponse response = new ServiceResponse();
		// service call
		List<User> users = userService.listUsers();

		if (users == null || users.isEmpty()) {

			Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			Utility.setResponseObject(users, Constants.SUCCESS, "Found " + users.size() + " users.", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	/**
	 * Search for a user with the given id
	 * @param id: user id to be searched
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findUserById(@PathVariable("userId") String id) {

		ServiceResponse response = new ServiceResponse();

		User user = userService.findUserById(id);

		if (user != null) {

			Utility.setResponseObject(user, Constants.SUCCESS, "Found a User", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * Updates the user data with the given user object
	 * 
	 * @param user: new user object which will replace the existing user object value 
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/user", method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse> updateUser(@RequestBody User user) {

		ServiceResponse response = new ServiceResponse();
		User u = userService.updateUser(user);
		if (u != null) {
			Utility.setResponseObject(user, Constants.SUCCESS, "Updated the user", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * Delete the user with the given id
	 * @param id: user id to be deleted
	 * @return response object
	 */
	@RequestMapping(value = "/api/user/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceResponse> deleteUserById(@PathVariable("userId") String id) {

		ServiceResponse response = new ServiceResponse();
		if (userService.deleteUser(id)) {
			Utility.setResponseObject(null, Constants.SUCCESS, "Deleted the user Successfully...", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Utility.setResponseObject(null, "409", "Could not delete User", response);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}

	/**
	 * Test Method to test if the service is up and running
	 */
	@RequestMapping(value = "/api/test/{anyString}", method = RequestMethod.GET)
	public ResponseEntity<ServiceResponse> testGetApi(@PathVariable("anyString") String anyString) {
		HttpHeaders headers = new HttpHeaders();

		ServiceResponse response = new ServiceResponse();
		response.setStatus(Constants.SUCCESS);
		response.setData("Working Fine....");
		return new ResponseEntity<>(response, headers, HttpStatus.OK);

	}

	/**
	 * Test Method to test if the service is up and running
	 */
	@RequestMapping(value = "/api/test/{anyString}", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> testPostApi(@PathVariable("anyString") String anyString,
			@RequestBody User user) {
		HttpHeaders headers = new HttpHeaders();
		ServiceResponse response = new ServiceResponse();
		response.setStatus(Constants.SUCCESS);
		response.setData("Working Fine....");
		return new ResponseEntity<>(response, headers, HttpStatus.OK);
	}

	/**
	 * Admin approves a user
	 * @param p - user object of the user to be approved
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/user/approve", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> approveUser(@RequestBody User user) {
		ServiceResponse response = new ServiceResponse();
		try {
			User p = userService.findUserById(user.getId());
			if (p != null && p.getStatus().equalsIgnoreCase("ACTIVE")) {
				Utility.setResponseObject(p, "203", "User already approved", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			if (p != null) {
				p = userService.approveUser(p);
			}
			if (p != null) {
				Utility.setResponseObject(p, Constants.SUCCESS, "User approval successful", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Utility.setResponseObject(null, "202", "User approval failed", response);
		} catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Admin rejects a user
	 * @param p - user object of the user to be rejected
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/user/reject", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> rejectUser(@RequestBody User user) {
		ServiceResponse response = new ServiceResponse();
		try {
			User p = userService.findUserById(user.getId());
			if (p != null && p.getStatus().equals("REJECTED")) {
				Utility.setResponseObject(p, "205", "User already rejected", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			if (p != null) {
				p = userService.rejectUser(p);
			}
			if (p != null) {
				Utility.setResponseObject(p, Constants.SUCCESS, "User rejection successful", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			Utility.setResponseObject(null, "204", "User rejection failed", response);
		} catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * called when the user wants to enroll in a course
	 * @param course: the course object in which user wants to enroll
	 * @param id: user id who wants to enroll
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/student/enroll/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> studentEnrollInCourse(@RequestBody Course course, @PathVariable("userId") String id) {
		ServiceResponse response = new ServiceResponse();
		User student = userService.findUserById(id);
		student = userService.enrollInCourse(student, course);
		if (student == null) {
			Utility.setResponseObject(student, "208", "Course enrollment failed", response);
		} else {
			Utility.setResponseObject(student, Constants.SUCCESS, "Course enrollment successful", response);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * called when the user wants to drop a course
	 * @param course: the course object in which user wants to enroll
	 * @param id: user id who wants to drop
	 * @return user object as response
	 */
	@RequestMapping(value = "/api/student/drop/{userId}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> studentDropCourse(@RequestBody Course course, @PathVariable("userId") String id) {
		ServiceResponse response = new ServiceResponse();
		User student = userService.findUserById(id);
		student = userService.dropCourse(student, course);
		if (student == null) {
			Utility.setResponseObject(student, "208", "Course drop failed", response);
		} else {
			Utility.setResponseObject(student, Constants.SUCCESS, "Course drop successful", response);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get all the students under one professor.
	 * It includes all the students a professor takes and the students enrolled in those courses 
	 * @param userId: the user who is logged in
	 * @param facultyId: the professor id
	 * @return list all the users associated with the given facultyId as response
	 */
	@RequestMapping(value="/api/{userId}/students/{facultyId}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> getStudentsByFacultyId(@PathVariable("userId") String userId, @PathVariable("facultyId") String facultyId ) {
		ServiceResponse response = new ServiceResponse();
		List<String> courseIds = courseService.findCourseByProfId(facultyId).stream().map(c -> c.get_id()).collect(Collectors.toList());
		Set<String> studIds = new LinkedHashSet<>();
		for(String i: courseIds) {
			courseService.findAllStudentsByCourseId(i).stream().forEach(u -> studIds.add(u.getId()));
		}
		List<User> students = userService.findUserByIds(new LinkedList<>(studIds));
		if (students.isEmpty()) {
			Utility.setResponseObject(null, "404", Constants.USER_NOT_FOUND, response);
		}
		else {
			Utility.setResponseObject(students, Constants.SUCCESS, "Found " + students.size() + " students", response);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * List of all the courses this student is enrolled in
	 * @param userId: the user who is logged in
	 * @return list all the courses this user is enrolled in as response
	 */
	@RequestMapping(value="/api/{userId}/enrolledcourses", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> getEnrolledCourse(@PathVariable("userId") String userId) {
		ServiceResponse response = new ServiceResponse();
		List<Course> courses = userService.getCourseEnrolled(userId);
		if (courses == null || courses.isEmpty()) {
			Utility.setResponseObject(null, "404", Constants.COURSE_NOT_FOUND, response);
		}
		else {
			Utility.setResponseObject(courses, "200", "Found " + courses.size() + " courses", response);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}

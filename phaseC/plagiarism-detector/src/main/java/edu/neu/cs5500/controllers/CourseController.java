/**
 * This class will have all the apis related to the course
 * Will be used to interact with the front end
 */
package edu.neu.cs5500.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

/**
 * @author sanketmathur
 *
 */

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	// Logger
	private static Logger logger = Logger.getLogger(CourseController.class.getName());
	
	/**
	 * called to get all the courses in the database
	 * @param userId: user if of the person logged in
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/courses", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> getAllCourses(@PathVariable("userId") String userId) {
		ServiceResponse response = new ServiceResponse();
		// service call
		List<Course> courses = courseService.listCourses();

		if (courses == null || courses.isEmpty()) {
			logger.log(Level.INFO, "No Course Found");
			Utility.setResponseObject(null, "404", Constants.COURSE_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			Utility.setResponseObject(courses, Constants.SUCCESS, "Found " + courses.size() + " courses", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	/**
<<<<<<< HEAD
	 * Create a course in the courseCollection	
	 * 
	 * @param course
	 * @return

=======
	 * Create a course in the courseCollection
	 * @param course: course to be created
	 * @return response object
>>>>>>> sanketfinal2
	 */
	@RequestMapping(value = "/api/{userId}/course", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> createCourse(@PathVariable("userId") String userId, @RequestBody Course course) {
		ServiceResponse response = new ServiceResponse();
		Course p = courseService.createCourse(course);
		if (p != null) {
			Utility.setResponseObject(p, Constants.SUCCESS, "Created Course", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(p, "500", "Course Not Created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Updates the course data with the given course object
	 * @param userId: userid of the person who is logged in
	 * @param course: course to be updated
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/course", method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse> updateCourse(@PathVariable("userId") String userId, @RequestBody Course course) {

		ServiceResponse response = new ServiceResponse();
		Course c = courseService.updateCourse(course);
		if (c != null) {
			Utility.setResponseObject(c, Constants.SUCCESS, "Updated the course", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(null, "404", Constants.COURSE_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	
	/**
	 * Delete the course with the given id
	 * @param userId: userid of the person who is logged in
	 * @param id: course id to be deleted
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/course/{courseId}", method = RequestMethod.DELETE)
	public ResponseEntity<ServiceResponse> deleteCourseById(@PathVariable("userId") String userId, @PathVariable("courseId") String id) {

		ServiceResponse response = new ServiceResponse();
		if (courseService.deleteCourse(id)) {
			Utility.setResponseObject(null, Constants.SUCCESS, "Deleted the course Successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			Utility.setResponseObject(null, "409", "Could not delete Course", response);
			return new ResponseEntity<>(response, HttpStatus.CONFLICT);
		}
	}
	
	/**
	 * Search for a course with the given id
	 * @param userId: userid of the person who is logged in
	 * @param id: course id of the course to find
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/course/{courseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findCourseById(@PathVariable("userId") String userId, @PathVariable("courseId") String id) {
		ServiceResponse response = new ServiceResponse();
		Course course = courseService.findCourseById(id);
		if (course != null) {
			Utility.setResponseObject(course, Constants.SUCCESS, "Found a Course", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, "404", Constants.COURSE_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Search for all course with the given facultyid
	 * @param userId: userid of the person who is logged in
	 * @param facultyId: id of the professor whose course shall be in the output
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/course/faculty/{facultyId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findCourseByFacultyId(@PathVariable("userId") String userId, @PathVariable("facultyId") String facultyId) {
		ServiceResponse response = new ServiceResponse();
		List<Course> courses = courseService.findCourseByProfId(facultyId);
		if (courses != null) {
			Utility.setResponseObject(courses, Constants.SUCCESS, "Found " + courses.size() + " courses", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, "404", Constants.COURSE_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * Search for all students with the given courseid
	 * 
	 * @param userId: userid of the person who is logged in
	 * @param courseId: course id of the course whose enrolled students shall be in the output
	 * @return response object
	 */
	@RequestMapping(value = "/api/{userId}/course/students/{courseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findStudentsByCourseId(@PathVariable("userId") String userId, @PathVariable("courseId") String courseId) {
		ServiceResponse response = new ServiceResponse();
		List<User> users = courseService.findAllStudentsByCourseId(courseId);
		if (users != null && !users.isEmpty()) {
			Utility.setResponseObject(users, Constants.SUCCESS, "Found " + users.size() + " students", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, "404", Constants.STUDENT_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/**
	 * get all the courses in this semester
	 * @param userId - user who is logged in
	 * @param semId: semester id whose associated course shall be in the output
	 * @return response object
	 */
	@RequestMapping(value="/api/{userId}/courses/{semId}", method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<ServiceResponse> findCoursesInThisSemesters(@PathVariable("userId") String userId, @PathVariable String semId) {
		ServiceResponse response = new ServiceResponse();
		List<Course> slist = courseService.findAllCoursesInThisSemester(semId);
		if (slist != null) {
			Utility.setResponseObject(slist, Constants.SUCCESS, "Found " + slist.size() + " courses", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		Utility.setResponseObject(null, "404", Constants.SEMESTER_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}

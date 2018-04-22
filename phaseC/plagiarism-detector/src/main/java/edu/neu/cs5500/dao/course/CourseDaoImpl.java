/**
 * This is the DAO (data access object) layer implementation, which will interact
 * with the database
 * Implements CourseDao
 */
package edu.neu.cs5500.dao.course;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.repository.CourseRepository;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 *
 */
@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {
	
	private static Logger logger = Logger.getLogger(CourseDaoImpl.class.getName());

	@Autowired
	private CourseRepository courseRepo;


	/**
	 * creates a new course
	 * @param course: course object to be created
	 * @return the course created
	 */
	@Override
	public Course createCourse(Course c) {
		try {
			return courseRepo.save(c);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return null;
	}

	/**
	 * update en existing course with the given course
	 * @param c: the given course
	 * @return the updated course
	 */
	@Override
	public Course updateCourse(Course c) {
		Course result = null;
		try {
			result = courseRepo.save(c);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
		
	}
	
	/**
	 * @return list of all the courses
	 */
	@Override
	public Iterable<Course> listAllCourses() {
		Iterable<Course> it = null;
		try {
			it = courseRepo.findAll();
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return it;
	}
	
	/**
	 * list of all the courses present with the given ids
	 * @param courseIds: list of all the given courses ids
	 * @return list of all the courses
	 */
	@Override
	public Iterable<Course> listAllCourses(Iterable<String> courseIds) {
		Iterable<Course> it = null;
		try {
			it = courseRepo.findAll(courseIds);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return it;
	}
	
	/**
	 * 
	 * @param c: course to be deleted
	 * @return true iff the course is deleted from the database
	 */
	@Override
	public boolean deleteCourse(Course c) {
		try {
			courseRepo.delete(c);
			return true;
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return false;
	}
	
	/**
	 * find the course with the given course id
	 * @param courseId: course id to be found
	 * @return the course associated with this id
	 */
	@Override
	public Course findCourseById(String courseId) {
		Course c1 = null;
		try {
			c1 = courseRepo.findOne(courseId);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return c1;
	}
	
	/**
	 * find all the courses a professor teaches
	 * @param id: user id of the professor
	 * @return the list of courses associated with this professor id
	 */
	@Override
	public List<Course> findCourseByProfId(String id) {
		List<Course> result = null;
		try {
			Iterable<Course> it = courseRepo.findCourseByFacultyID(id);
			if(it != null) {
				result = new ArrayList<>();
				for(Course c: it) {
					result.add(c);
				}
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
	}
}

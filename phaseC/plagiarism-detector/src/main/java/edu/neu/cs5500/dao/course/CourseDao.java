/**
 * 
 */
package edu.neu.cs5500.dao.course;

import java.util.List;

import edu.neu.cs5500.domainObjects.Course;

/**
 * @author sanketmathur
 *
 */
public interface CourseDao {

	/**
	 * 
	 * @param c
	 * @return the course created
	 * 
	 * Creates a course in the DB
	 */
	Course createCourse(Course c);
	
	/**
	 * 
	 * @param c
	 * @return the true iff the course has been updated in the database
	 */
	Course updateCourse(Course c);
	
	/**
	 * @return list of all the courses
	 */
	Iterable<Course> listAllCourses();
	
	/**
	 * @return list of all the courses present with the given ids
	 */
	Iterable<Course> listAllCourses(Iterable<String> courseIds);
	
	/**
	 * 
	 * @param id
	 * @return true iff the course is deleted from the database
	 * 
	 * used to delete the course from the Db
	 */
	boolean deleteCourse(Course id);
	
	/**
	 * 
	 * @param id
	 * Find a course on the basis of input courseId
	 * @return the course associated with this id
	 */
	Course findCourseById(String courseId);
	
	/**
	 * 
	 * @param id
	 * @return the course associated with this professor id
	 * 
	 * Find all courses based on the input professor id
	 */
	List<Course> findCourseByProfId(String id);	
}

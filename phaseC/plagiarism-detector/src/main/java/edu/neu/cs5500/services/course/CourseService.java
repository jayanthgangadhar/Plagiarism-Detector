/**
 * 
 */
package edu.neu.cs5500.services.course;

import java.util.List;

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;

/**
 * @author sanketmathur
 *
 */
public interface CourseService {

	/**
	 * @param c
	 * @return
	 * method to create a course
	 */
	public Course createCourse(Course c);
	
    /**
     * @param Update course method
     */
    public Course updateCourse(Course c);
    
    /**
     * @return List all courses
     */
    public List<Course> listCourses();
    
    /**
     * @return List all courses with the given course ids
     */
    public List<Course> listCourses(List<String> coursesIds);
    
    /**
     * @param id
     * @return
     * delete the course data on the basis of given iD
     */
    
    public boolean deleteCourse(String id);
    
	/**
	 * @param id
	 * @return course associated with this id
	 */
	public Course findCourseById(String id);
	
	/**
	 * @param id
	 * @return list of courses associated with this professor
	 */
	public List<Course> findCourseByProfId(String id);
	
	/**
	 * 
	 * @param id
	 * @return list of students associated with this course
	 */
	public List<User> findAllStudentsByCourseId(String courseId);
	
	/**
	 * 
	 * @param sem
	 * @return list of courses in the given semester
	 */
	List<Course> findAllCoursesInThisSemester(String id);	
}

/**
 * This is the service layer implementation, which will
 * contain all the business logic for the course object 
 */
package edu.neu.cs5500.services.course;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cs5500.dao.course.CourseDao;
import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 *
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {

	/**
	 * courseDao: an instance of the Dao layer of the Course which will
	 * be used to interact with the database for Course data
	 */
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private AssignmentService assignService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * creates a course
	 * @param course: course object to be created
	 * @return the course created
	 */
	@Override
	public Course createCourse(Course c) {
		if(c != null) {
			c.setStatus(Constants.ACTIVE);
			c = courseDao.createCourse(c);
		}
		return c;
	}
	
	/**
	 * update en existing course with the given course
	 * @param c: the given course
	 * @return the updated course
	 */
	@Override
    public Course updateCourse(Course c) {
    		Course c1 = courseDao.findCourseById(c.get_id());
    		if(c.getCourseName() != null && !c.getCourseName().equals(c1.getCourseName())) {
    			c1.setCourseName(c.getCourseName());
    		}
    		if(c.getFacultyID() != null && !c.getFacultyID().equals(c1.getFacultyID())) {
    			c1.setFacultyID(c.getFacultyID());
    		}
    		if(c.getSemesterId() != null && !c.getSemesterId().equals(c1.getSemesterId())) {
    			c1.setSemesterId(c.getSemesterId());
    		}
    		if(c.getStatus() != null && !c.getStatus().equals(c1.getStatus())) {
    			c1.setStatus(c.getStatus());
    		}
    		if(c.getStudentsEnrolled() != null && !c.getStudentsEnrolled().equals(c1.getStudentsEnrolled())) {
    			c1.setStudentsEnrolled(c.getStudentsEnrolled());
    		}
    		return courseDao.updateCourse(c1);
    }
    
    /**
     * @return List all courses
     */
	@Override
    public List<Course> listCourses() {
    		Iterable<Course> it = courseDao.listAllCourses();
    		if(it == null) {
    			return new ArrayList<>();
    		}
    		return (List<Course>)it;
    }
	
	/**
	 * list of all the courses present with the given ids
	 * @param courseIds: list of all the given courses ids
	 * @return list of all the courses
	 */
	@Override
    public List<Course> listCourses(List<String> coursesIds) {
    		Iterable<Course> it = courseDao.listAllCourses(coursesIds);
    		if(it == null) {
    			return new ArrayList<>();
    		}
    		return (List<Course>)it;
    }
    
	/**
	 * 
	 * @param c: course to be deleted
	 * @return true iff the course is deleted from the database
	 */
	@Override
    public boolean deleteCourse(String id) {
    		Course c = courseDao.findCourseById(id);
    		if(c != null) {
    			List<Assignment> listAssign = assignService.findAllCourseRelatedAssignments(id);
    			List<String> assignIds = StreamSupport.stream(listAssign.spliterator(), false).map(a -> a.get_id()).collect(Collectors.toList());
    			boolean result = true;
    			for(String a : assignIds) {
    				result = result && assignService.deleteAssignment(a);
    			}
    			if(result) {
    				return courseDao.deleteCourse(c);
    			}
    		}
    		return false;
    }
    
	/**
	 * find the course with the given course id
	 * @param courseId: course id to be found
	 * @return the course associated with this id
	 */
	@Override
	public Course findCourseById(String id) {
		return courseDao.findCourseById(id);
	}
	
	/**
	 * find all the courses a professor teaches
	 * @param id: user id of the professor
	 * @return the list of courses associated with this professor id
	 */
	@Override
	public List<Course> findCourseByProfId(String id) {
		return courseDao.findCourseByProfId(id);
	}
	
	/**
	 * returns a list of users associated with this course
	 * @param courseId: the given course id
	 * @return list of students associated with this course
	 */
	public List<User> findAllStudentsByCourseId(String courseId) {
		Course c = courseDao.findCourseById(courseId);
		if(c != null) {
			List<String> studs = c.getStudentsEnrolled();
			if(studs != null) {
				return userService.listUsers(studs);
			}
		}
		return new ArrayList<>();
	}
	
	/**
	 * returns a list of courses in this semester
	 * @param id: semester id
	 * @return list of courses in the given semester
	 */
	public List<Course> findAllCoursesInThisSemester(String id) {
		Iterable<Course> it = courseDao.listAllCourses();
		List<Course> courses = new LinkedList<>();
		if(it != null) {
			courses = StreamSupport.stream(it.spliterator(), false)
					.filter(c -> c.getSemesterId().equals(id))
					.collect(Collectors.toList());
		}
		return courses;
	}
}

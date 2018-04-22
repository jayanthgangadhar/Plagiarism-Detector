/**
 * A class implementation for the UserService interface
 */

package edu.neu.cs5500.services.user;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.mindrot.jbcrypt.*;
import org.springframework.stereotype.Service;

import edu.neu.cs5500.dao.user.UserDao;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.course.CourseService;

/**
 * @author Asim
 * 
 * Service class to implement all the User related functionalities
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	/**
	 * userDao: an instance of the Dao layer of the User which will
	 * be used to interact with the database for User data
	 */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * @param u
	 * @return the user created
	 * method to create a user
	 */
	@Override
	public User createUser(User u) {
		
		return userDao.createUser(u);

	}

	/**
     * @param p 
     * @return the updated user
     * Update user method
     */
	@Override
	public User updateUser(User p) {
		
		User u = userDao.findUserById(p.getId());
		if (u !=null) {
			if(p.getFirstName() != null) {
				u.setFirstName(p.getFirstName());
			}
			if(p.getLastName() != null) {
				u.setLastName(p.getLastName());
			}
			if(p.getRole() != null) {
				u.setRole(p.getRole());
			}	
			if(p.getStatus() != null) {
				u.setStatus(p.getStatus());
			}
			if(p.getApprovedBy() != null) {
				u.setApprovedBy(p.getApprovedBy());
			}
			if(p.getApprovedOn() != null) {
				u.setApprovedOn(p.getApprovedOn());
			}
			if(p.getCourseEnrolled() != null) {
				u.setCourseEnrolled(p.getCourseEnrolled());
			}			
			if(p.getReport() != null) {
				u.setReport(p.getReport());
			}
			if(p.getThreshold() != null) {
				u.setThreshold(p.getThreshold());
			}
		}
		else {
			return null;
		}
		if (userDao.updateUser(u)) {
			return userDao.findUserById(p.getId());
		}
		return null;
	}

	/**
	 * @return list of user objects
	 */
	@Override
	public List<User> listUsers() {
		
		return userDao.listUsers();
	}
	
	/**
	 * userIds: list of user ids
	 * @return list of user objects
	 */
	@Override
	public List<User> listUsers(List<String> userIds) {
		List<User> it = userDao.listUsers(userIds);
		if(it == null || it.isEmpty()) {
			return new ArrayList<>();
		}
		return it;
	}

	/**
	 * 
     * @param id
     * @return true iff user is deleted from the database
     * returns the user data on the basis of given iD
     */
	@Override
	public boolean deleteUser(String id) {
		User u = userDao.findUserById(id);
		if(u == null) return false;
		boolean result = true;
		
		// is user is professor then update the course he is teaching
		if(u.getRole().equalsIgnoreCase("Professor")) {
			List<Course> stuCourses = courseService.findCourseByProfId(id);
			if(stuCourses != null) {
				for(Course i: stuCourses) {
					i.setFacultyID("");
					result = result && courseService.updateCourse(i) != null;
				}
			}
			if(!result) return false;
		}
		
		// if user is student update the course list in the courseCollection
		if(u.getRole().equalsIgnoreCase("Student")) {
			List<String> coursesIds = u.getCourseEnrolled();
			if(coursesIds != null) {
				List<Course> courses = courseService.listCourses(coursesIds); 
				for(Course course: courses) {
					Course c1 = courseService.findCourseById(course.get_id());
					List<String> courseStuLs = c1.getStudentsEnrolled();
					if(courseStuLs != null) {
						courseStuLs.remove(u.getId());
						c1.setStudentsEnrolled(courseStuLs);
						result = result && (courseService.updateCourse(c1) != null);
					}
				}
			}
		}
		
		if(result) {
			userDao.deleteUser(u);
		}
		return result;
		
	}

	/**
	 * @param emailAddress
	 * @return the user with the given email
	 */
	@Override
	public User getUserByEmail(String emailAddress) {
		return userDao.findUserByEmail(emailAddress);
	}

	/**
	 * @param userEmail
	 * @return
	 * adding a role to the current user
	 */
	@Override
	public String addRole(String userEmail) {

		return null;
	}

	/**
	 * It will search and return the user in the database with the given
	 * email address and corresponding password else return null
	 * @param email
	 * @param password
	 */
	@Override
	public User getUserByCredential(String userEmail, String password) {
		return userDao.findUserByCredential(userEmail, password);
	}

	/**
	 * It will search and return the user in the database with the given
	 * id else return null
	 * @param id
	 */
	@Override
	public User findUserById(String id) {
		return userDao.findUserById(id);
	}
	
	/**
	 * It will search and return the users in the database with the given
	 * list of ids else return null
	 * @param 
	 * @param 
	 */
	@Override
	public List<User> findUserByIds(List<String> ids) {
		return (List<User>) userDao.findUserByIds(ids);
	}


	@Override
	public User createUserByAdmin(User u) {
		
		return userDao.createUserByAdmin(u);	
		
	}
	
	/**
	 * @param u: user id
	 * @return list of course object the given user is enrolled in
	 */
	@Override
	public List<Course> getCourseEnrolled(String u) {
		User u1 = userDao.findUserById(u);
		if(u1 != null) {
			List<String> courses = u1.getCourseEnrolled();
			if(courses != null) {
				return courseService.listCourses(courses);
			}
		}
		return new ArrayList<>();
	}

	/**
	 * 
	 * @param p they user who will be approved
	 * @return the approved user
	 */
	@Override
	public User approveUser(User p) {
		return userDao.approveUserDao(p);
	}

	/**
	 * 
	 * @param p the user who will be rejected
	 * @return the rejected user
	 */
	@Override
	public User rejectUser(User p) {
		return userDao.rejectUserDao(p);

	}

	/**
	 * 
	 * @param student: student who is going to enroll in the course
	 * @param course: course in to be enrolled
	 * @return: updated student
	 */
	@Override
	public User enrollInCourse(User student, Course course) {
		if(course == null || student == null) {
			return null;
		}
		else {
			String courseId = course.get_id();
			User s1 = userDao.findUserById(student.getId());
			if(s1 == null) {
				return null;
			}
			
			List<String> stuCoursesLs = s1.getCourseEnrolled();
			if(stuCoursesLs == null) {
				stuCoursesLs = new LinkedList<>();
			}
			if(!stuCoursesLs.contains(courseId)) {
				stuCoursesLs.add(courseId);
			}
			s1.setCourseEnrolled(stuCoursesLs);
			
			Course c1 = courseService.findCourseById(courseId);
			if(c1==null) {
				return null;
			}
			List<String> courseStuLs = c1.getStudentsEnrolled();
			if(courseStuLs == null) {
				courseStuLs = new LinkedList<>();
			}
			student.setCourseEnrolled(null);
			student.setApprovedBy(null);
			student.setApprovedOn(null);
			student.setReport(null);
			student.setPassword(null);
			if(!courseStuLs.contains(student.getId())) {
				courseStuLs.add(student.getId());
			}
			c1.setStudentsEnrolled(courseStuLs);
			if(courseService.updateCourse(c1) == null) {
				return null;
			}
			
			if (userDao.updateUser(s1)) {
				return userDao.findUserById(s1.getId());
			}
			return null;
		}
	}
	
	/**
	 * 
	 * @param student: student who is going to drop the given course
	 * @param course: course to be dropped
	 * @return
	 */
	@Override
	public User dropCourse(User student, Course course) {
		if(course == null || student == null) {
			return null;
		}
		else {
			User s1 = userDao.findUserById(student.getId());
			List<String> stuCoursesLs = s1.getCourseEnrolled();
			if(stuCoursesLs == null) {
				return null;
			}
			stuCoursesLs.remove(course.get_id());
			s1.setCourseEnrolled(stuCoursesLs);
			
			Course c1 = courseService.findCourseById(course.get_id());
			List<String> courseStuLs = c1.getStudentsEnrolled();
			if(courseStuLs == null) {
				return null;
			}
			courseStuLs.remove(student.getId());
			c1.setStudentsEnrolled(courseStuLs);
			
			if(courseService.updateCourse(c1) == null) {
				return null;
			}
			
			if (userDao.updateUser(s1)) {
				return userDao.findUserById(s1.getId());
			}
			return null;
		}
	}

	/**
	 * returns user full name in the format:
	 * firstname lastname - from the given id
	 * @param id: user id
	 * @return user full name
	 */
	@Override
	public String getUserFullNameById(String id) {
		
		String fullName = null;
		User user = this.findUserById(id);
		
		if (user !=null) {
			
			fullName = user.getFirstName() + " " + user.getLastName();
			
		}
		
		return fullName;
	}
}

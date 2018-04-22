/**
 * Test class for CourseServiceImpl
 */
package edu.neu.cs5500.services.course;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.dao.course.CourseDao;
import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.user.UserService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
public class CourseServiceImplTest {

	@TestConfiguration
    static class CourseServiceImplConfiguraton {
        @Bean
        public CourseService courseService() {
            return new CourseServiceImpl();
        }
    }
    
    @Autowired
    CourseService cs;
    
    @MockBean
    private CourseDao courseDaoMock;
    
    @MockBean
    private AssignmentService assignServiceMock;
    
    @MockBean
    private UserService userServiceMock;
    
    Course c = new Course();
    
    @Before
    public void createCourseBefore() {
        c.set_id("123");
        c.setCourseName("PDP");
        c.setFacultyID("111");
        c.setSemesterId("S01");
        c.setStatus("ACTIVE");
        List<String> stu = new ArrayList<>();
        stu.add("a");
        c.setStudentsEnrolled(stu);
    }
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#createCourse(edu.neu.cs5500.domainObjects.Course)}.
	 * Success
	 */
	@Test
	public void testCreateCourse() {
        when(courseDaoMock.createCourse(anyObject())).thenReturn(c);
        assertEquals(c, cs.createCourse(c));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#createCourse(edu.neu.cs5500.domainObjects.Course)}.
	 * Fail
	 */
	@Test
	public void createCourseTestFail() {
        when(courseDaoMock.createCourse(anyObject())).thenReturn(null);
        assertEquals(null, cs.createCourse(c));
    }
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#createCourse(edu.neu.cs5500.domainObjects.Course)}.
	 * Fail
	 */
	@Test
    public void createCourseTestFail2() {
        assertEquals(null, cs.createCourse(null));
    }

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#updateCourse(edu.neu.cs5500.domainObjects.Course)}.
	 * Success
	 */
	@Test
	public void testUpdateCourse() {
        List<String> stu = new ArrayList<>();
        stu.add("a");
        c.setStudentsEnrolled(stu);
        
        Course c1 = new Course();
        c1.set_id("123");
        c1.setCourseName("PDPD");
        c1.setFacultyID("1111");
        c1.setSemesterId("S02");
        c1.setStatus("INACTIVE");
        when(courseDaoMock.findCourseById(anyString())).thenReturn(c1);
        when(courseDaoMock.updateCourse(anyObject())).thenReturn(c);
        assertEquals(c, cs.updateCourse(c));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#listCourses()}.
	 * Success
	 */
	@Test
	public void testListCoursesSuccess() {
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		when(courseDaoMock.listAllCourses()).thenReturn(courseLs);
		assertEquals(courseLs, cs.listCourses());
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#listCourses()}.
	 * Fail
	 */
	@Test
	public void testListCoursesFail() {
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		when(courseDaoMock.listAllCourses()).thenReturn(null);
		assertEquals(new ArrayList<>(), cs.listCourses());
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#listCourses(java.util.List)}.
	 * Success
	 */
	@Test
	public void testListCoursesListOfString() {
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		List<String> sLs = new ArrayList<>();
		sLs.add("123");
		when(courseDaoMock.listAllCourses(anyObject())).thenReturn(courseLs);
		assertEquals(courseLs, cs.listCourses(sLs));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#listCourses(java.util.List)}.
	 * Fail
	 */
	@Test
	public void testListCoursesListOfStringFail() {
		List<Course> courseLs = new ArrayList<>();
		courseLs.add(c);
		List<String> sLs = new ArrayList<>();
		sLs.add("123");
		when(courseDaoMock.listAllCourses(anyObject())).thenReturn(null);
		assertEquals(new ArrayList<>(), cs.listCourses(sLs));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#deleteCourse(java.lang.String)}.
	 * Fail
	 */
	@Test
	public void testDeleteCourseFail() {
		when(courseDaoMock.findCourseById(anyString())).thenReturn(null);
		assertEquals(false, cs.deleteCourse("123"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#deleteCourse(java.lang.String)}.
	 * Success
	 */
	@Test
	public void testDeleteCourseSuccess() {
		Assignment a = new Assignment();
		a.set_id("A1");
		a.setName("Graphs");
		List<Assignment> als = new ArrayList<>();
		als.add(a);
		when(courseDaoMock.findCourseById(anyString())).thenReturn(c);
		when(assignServiceMock.findAllCourseRelatedAssignments(anyString())).thenReturn(als);
		when(assignServiceMock.deleteAssignment(anyString())).thenReturn(true);
		when(courseDaoMock.deleteCourse(anyObject())).thenReturn(true);
		assertEquals(true, cs.deleteCourse("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#findCourseById(java.lang.String)}.
	 */
	@Test
	public void testFindCourseById() {
		when(courseDaoMock.findCourseById(anyString())).thenReturn(c);
		assertEquals(c, cs.findCourseById("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#findCourseByProfId(java.lang.String)}.
	 */
	@Test
	public void testFindCourseByProfId() {
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(courseDaoMock.findCourseByProfId(anyString())).thenReturn(cls);
		assertEquals(cls, cs.findCourseByProfId("111"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#findAllStudentsByCourseId(java.lang.String)}.
	 */
	@Test
	public void testFindAllStudentsByCourseId() {
		User u = new User();
		u.setId("U1");
		u.setFirstName("Tom");
		List<User> uls = new ArrayList<>();
		uls.add(u);
		when(courseDaoMock.findCourseById(anyString())).thenReturn(c);
		when(userServiceMock.listUsers(anyObject())).thenReturn(uls);
		assertEquals(uls, cs.findAllStudentsByCourseId("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.course.CourseServiceImpl#findAllCoursesInThisSemester(java.lang.String)}.
	 */
	@Test
	public void testFindAllCoursesInThisSemester() {
		List<Course> cls = new ArrayList<>();
		when(courseDaoMock.listAllCourses()).thenReturn(cls);
		assertEquals(cls, cs.findAllCoursesInThisSemester("S1"));
	}

}

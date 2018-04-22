/**
 * Test class for CourseDaoImpl
 */
package edu.neu.cs5500.dao.course;

import static org.junit.Assert.*;
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

import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.repository.CourseRepository;

/**
 * @author sanketmathur
 *
 */
@RunWith(SpringRunner.class)
public class CourseDaoImplTest {

	@TestConfiguration
    static class CourseDaoImplConfiguraton {
        @Bean
        public CourseDao courseDao() {
            return new CourseDaoImpl();
        }
    }
	
	@Autowired
	CourseDao cd;
	
	@MockBean
	private CourseRepository courseRepoMock;
	
	Course c = new Course();
	
	@Before
    public void createCourseBefore() {
        c.set_id("1233333333333333333333333333333333333333333333333333333333333333333333333333333333");
        c.setCourseName("PDP");
        c.setFacultyID("111");
        c.setSemesterId("S01");
        c.setStatus("ACTIVE");
        List<String> stu = new ArrayList<>();
        stu.add("a");
        c.setStudentsEnrolled(stu);
    }
	
	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#createCourse(edu.neu.cs5500.domainObjects.Course)}.
	 */
	@Test
	public void testCreateCourse() {
		when(courseRepoMock.save(c)).thenReturn(c);
		assertEquals(c, cd.createCourse(c));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#updateCourse(edu.neu.cs5500.domainObjects.Course)}.
	 */
	@Test
	public void testUpdateCourse() {
		when(courseRepoMock.save(c)).thenReturn(c);
		assertEquals(c, cd.updateCourse(c));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#listAllCourses()}.
	 */
	@Test
	public void testListAllCourses() {
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(courseRepoMock.findAll()).thenReturn(cls);
		assertEquals(cls, cd.listAllCourses());
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#listAllCourses(java.lang.Iterable)}.
	 */
	@Test
	public void testListAllCoursesIterableOfString() {
		List<String> sls = new ArrayList<>();
		sls.add("123");
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(courseRepoMock.findAll(sls)).thenReturn(cls);
		assertEquals(cls, cd.listAllCourses(sls));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#deleteCourse(edu.neu.cs5500.domainObjects.Course)}.
	 */
	@Test
	public void testDeleteCourse() {
		assertEquals(true, cd.deleteCourse(c));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#findCourseById(java.lang.String)}.
	 */
	@Test
	public void testFindCourseById() {
		when(courseRepoMock.findOne("123")).thenReturn(c);
		assertEquals(c, cd.findCourseById("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.course.CourseDaoImpl#findCourseByProfId(java.lang.String)}.
	 */
	@Test
	public void testFindCourseByProfId() {
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(courseRepoMock.findCourseByFacultyID(anyString())).thenReturn(cls);
		assertEquals(cls, cd.findCourseByProfId("11"));
	}

}

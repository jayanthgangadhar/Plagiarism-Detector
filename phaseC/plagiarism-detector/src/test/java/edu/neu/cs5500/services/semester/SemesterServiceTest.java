/**
 * 
 */
package edu.neu.cs5500.services.semester;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.dao.semester.SemesterDao;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.services.course.CourseService;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
public class SemesterServiceTest {
	
	@TestConfiguration
	static class SemesterServiceTestConfiguration {
		@Bean
		public SemesterService semesterService() {
			return new SemesterServiceImpl();
		}
	}
	
	@Autowired
	private SemesterService ss;
	
	@MockBean
	private SemesterDao semDaoMock;
	
	@MockBean
	private CourseService courseServiceMock;

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#createSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testCreateSemesterSuccess() {
		Semester s = new Semester();
		s.setName("MSD");
		s.setStatus("ACTIVE");
		when(semDaoMock.findSemesterById(anyString())).thenReturn(null);
		when(semDaoMock.createSemester(s)).thenReturn(s);
		assertEquals(s, ss.createSemester(s));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#createSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testCreateSemesterFail() {
		Semester s = new Semester();
		s.setName("MSD");
		s.setStatus("ACTIVE");
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		assertEquals(null, ss.createSemester(s));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#createSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testCreateSemesterFailNull() {
		assertEquals(null, ss.createSemester(null));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#deleteSemester(java.lang.String)}.
	 */
	@Test
	public void testDeleteSemester() {
		when(semDaoMock.findSemesterById(anyString())).thenReturn(null);
		assertEquals(true, ss.deleteSemester("123"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#deleteSemester(java.lang.String)}.
	 */
	@Test
	public void testDeleteSemesterSuccess() {
		Semester s = new Semester();
		s.set_id("123333333333333333333333333333333333333333");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		when(courseServiceMock.findAllCoursesInThisSemester(anyString())).thenReturn(new ArrayList<>());
		when(courseServiceMock.deleteCourse(anyString())).thenReturn(true);
		assertEquals(false, ss.deleteSemester("12333333333333333333333333333333333333333333333"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#deleteSemester(java.lang.String)}.
	 */
	@Test
	public void testDeleteSemesterSuccess1() {
		Semester s = new Semester();
		s.set_id("123333333333333333333333333333333333333333");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		
		Course c = new Course();
		c.set_id("123");
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		when(courseServiceMock.findAllCoursesInThisSemester(anyString())).thenReturn(cls);
		when(courseServiceMock.deleteCourse(anyString())).thenReturn(false);
		assertEquals(false, ss.deleteSemester("12333333333333333333333333333333333333333333333"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#deleteSemester(java.lang.String)}.
	 */
	@Test
	public void testDeleteSemesterSuccess2() {
		Semester s = new Semester();
		s.set_id("123333333333333333333333333333333333333333");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		
		Course c = new Course();
		c.set_id("123");
		List<Course> cls = new ArrayList<>();
		cls.add(c);
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		when(courseServiceMock.findAllCoursesInThisSemester(anyString())).thenReturn(cls);
		when(courseServiceMock.deleteCourse(anyString())).thenReturn(true);
		assertEquals(false, ss.deleteSemester("12333333333333333333333333333333333333333333333"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#updateSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testUpdateSemesterFail() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		when(semDaoMock.findSemesterById(anyString())).thenReturn(null);
		when(semDaoMock.updateSemester(anyObject())).thenReturn(null);
		assertEquals(null, ss.updateSemester(s));
		
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#updateSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testUpdateSemesterSuccess() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		
		Semester t = new Semester();
		t.set_id("123");
		t.setName("CS");
		t.setStatus("INACTIVE");
		
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		when(semDaoMock.updateSemester(anyObject())).thenReturn(t);
		assertEquals(t, ss.updateSemester(s));
		
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#updateSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testUpdateSemesterSuccess1() {
		Semester input = new Semester();
		input.set_id("123");
		input.setName("MSD");
		input.setStatus("ACTIVE");
		
		Semester find = new Semester();
		find.set_id("123");
		find.setName("CS");
		find.setStatus("INACTIVE");
		
		when(semDaoMock.findSemesterById(anyString())).thenReturn(find);
		when(semDaoMock.updateSemester(anyObject())).thenReturn(find);
		assertEquals(find, ss.updateSemester(input));
		
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#updateSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testUpdateSemesterSuccess2() {
		Semester input = new Semester();
		input.set_id("123");
		
		Semester find = new Semester();
		find.set_id("123");
		find.setName("CS");
		find.setStatus("INACTIVE");
		
		when(semDaoMock.findSemesterById(anyString())).thenReturn(find);
		when(semDaoMock.updateSemester(anyObject())).thenReturn(find);
		assertEquals(find, ss.updateSemester(input));
		
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findAllSemesters()}.
	 */
	@Test
	public void testFindAllSemesters() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semDaoMock.findAllSemesters()).thenReturn(semList);
		assertEquals(semList, ss.findAllSemesters());
		
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findSemesterById(java.lang.String)}.
	 */
	@Test
	public void testFindSemesterById() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		when(semDaoMock.findSemesterById(anyString())).thenReturn(s);
		assertEquals(s, ss.findSemesterById("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findAllActiveSemesters()}.
	 */
	@Test
	public void testFindAllActiveSemesters() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semDaoMock.findAllSemesters()).thenReturn(semList);
		assertEquals(semList, ss.findAllActiveSemesters());
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findAllActiveSemesters()}.
	 */
	@Test
	public void testFindAllActiveSemesters1() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semDaoMock.findAllSemesters()).thenReturn(null);
		assertEquals(new ArrayList<>(), ss.findAllActiveSemesters());
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findAllActiveSemesters()}.
	 */
	@Test
	public void testFindAllActiveSemesters2() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus(null);
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semDaoMock.findAllSemesters()).thenReturn(semList);
		assertEquals(new ArrayList<>(), ss.findAllActiveSemesters());
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.semester.SemesterServiceImpl#findAllActiveSemesters()}.
	 */
	@Test
	public void testFindAllActiveSemesters3() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("MSD");
		s.setStatus("INACTIVE");
		
		Semester s1 = new Semester();
		s1.set_id("123");
		s1.setName("MSD");
		s1.setStatus("");
		
		Semester s2 = new Semester();
		s2.set_id("123");
		s2.setName("MSD");
		
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		semList.add(s1);
		semList.add(s2);
		when(semDaoMock.findAllSemesters()).thenReturn(semList);
		assertEquals(new ArrayList<>(), ss.findAllActiveSemesters());
	}

}

/**
 * 
 */
package edu.neu.cs5500.dao.semester;

import static org.junit.Assert.*;
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

import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.repository.SemesterRepository;

/**
 * @author sanketmathur
 *
 */
@RunWith(SpringRunner.class)
public class SemesterDaoTest {

	
	@TestConfiguration
	static class SemesterDaoTestConfiguration {
		@Bean
		public SemesterDao semesterDao() {
			return new SemesterDaoImpl();
		}
	}
	
	@Autowired
	private SemesterDao semDao;
	
	@MockBean
	private SemesterRepository semRepoMock;
	
	/**
	 * Test method for {@link edu.neu.cs5500.dao.semester.SemesterDaoImpl#createSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testCreateSemester() {
		Semester s = new Semester();
		s.setName("Spring 2017");
		s.setStatus("ACTIVE");
		when(semRepoMock.save(s)).thenReturn(s);
		assertEquals(s, semDao.createSemester(s));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.semester.SemesterDaoImpl#deleteSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testDeleteSemester() {
		Semester s = new Semester();
		s.set_id("11111111111111111111111111111111111111111111111111111111111111111111");
		s.setName("Spring 2017");
		s.setStatus("ACTIVE");
		semDao.deleteSemester(s);
		when(semRepoMock.findOne(anyString())).thenReturn(null);
		assertEquals(null, semDao.findSemesterById("11111111111111111111111111111111111111111111111111111111111111111111"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.semester.SemesterDaoImpl#updateSemester(edu.neu.cs5500.domainObjects.Semester)}.
	 */
	@Test
	public void testUpdateSemester() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2017");
		s.setStatus("ACTIVE");
		when(semRepoMock.save(s)).thenReturn(s);
		assertEquals(s, semDao.updateSemester(s));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.semester.SemesterDaoImpl#findAllSemesters()}.
	 */
	@Test
	public void testFindAllSemesters() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2017");
		s.setStatus("ACTIVE");
		List<Semester> semList = new ArrayList<>();
		semList.add(s);
		when(semRepoMock.findAll()).thenReturn(semList);
		assertEquals(semList, semDao.findAllSemesters());
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.semester.SemesterDaoImpl#findSemesterById(java.lang.String)}.
	 */
	@Test
	public void testFindSemesterById() {
		Semester s = new Semester();
		s.set_id("123");
		s.setName("Spring 2017");
		s.setStatus("ACTIVE");
		when(semRepoMock.findOne(anyString())).thenReturn(s);
		assertEquals(s, semDao.findSemesterById("123"));
	}

}

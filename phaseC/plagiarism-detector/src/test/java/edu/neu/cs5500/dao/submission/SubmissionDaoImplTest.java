/**
 * Test for SubmissionDaoImpl
 */
package edu.neu.cs5500.dao.submission;

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

import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.repository.SubmissionRepository;

/**
 * @author sanketmathur
 *
 */
@RunWith(SpringRunner.class)
public class SubmissionDaoImplTest {

	
	@TestConfiguration
	static class SubmissionDaoTestConfiguration {
		@Bean
		public SubmissionDao semesterDao() {
			return new SubmissionDaoImpl();
		}
	}
	
	@Autowired
	SubmissionDao sd;
	
	@MockBean
	private SubmissionRepository submissionRepoMock;
	
	Submission s = new Submission();
	User u = new User();
	
	@Before
	public void createUser() {
		u.setFirstName("Frank");
		u.setLastName("Jr");
		u.setId("001");
	}
	
	@Before
	public void createSubmission() {
		s.set_id("111111111111111111111111111111111111111111111111111111111111111111111111111111");
		s.setStudentId("123");
		s.setStudentName("*le");
		s.setHomeworkId("A001");
		s.setCourseId("C001");
		s.setStatus("NEW");
		FileTuple ft = new FileTuple();
		ft.setFileText1("Test1.py");
		ft.setFileText2("https://s.amazonaws.com/msd-team-206/Test1.py");
		List<FileTuple> urls = new ArrayList<>();
		urls.add(ft);
		s.setUrl(urls);
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#findBy_id(java.lang.String)}.
	 */
	@Test
	public void testFindBy_id() {
		when(submissionRepoMock.findBy_id(anyString())).thenReturn(s);
		assertEquals(s, sd.findBy_id("11"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#createSubmission(edu.neu.cs5500.domainObjects.Submission)}.
	 */
	@Test
	public void testCreateSubmission() {
		when(submissionRepoMock.save(s)).thenReturn(s);
		assertEquals(s, sd.createSubmission(s));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#updateSubmission(edu.neu.cs5500.domainObjects.Submission)}.
	 */
	@Test
	public void testUpdateSubmission() {
		when(submissionRepoMock.save(s)).thenReturn(s);
		assertEquals(s, sd.updateSubmission(s));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#deleteSubmissionBy_id(java.lang.String)}.
	 */
	@Test
	public void testDeleteSubmissionBy_id() {
		when(submissionRepoMock.findBy_id(anyString())).thenReturn(s);
		assertEquals(true, sd.deleteSubmissionBy_id("111111111111111111111111111111111111111111111111111111111111111111111111111111"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#deleteAllSubmissions(java.util.List)}.
	 */
	@Test
	public void testDeleteAllSubmissions() {
		List<Submission> sls = new ArrayList<>();
		sls.add(s);
		assertEquals(true, sd.deleteAllSubmissions(sls));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#findByStudentId(java.lang.String)}.
	 */
	@Test
	public void testFindByStudentId() {
		List<Submission> sls = new ArrayList<>();
		sls.add(s);
		when(submissionRepoMock.findByStudentId("123")).thenReturn(sls);
		assertEquals(sls, sd.findByStudentId("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.submission.SubmissionDaoImpl#findByHomeworkId(java.lang.String)}.
	 */
	@Test
	public void testFindByHomeworkId() {
		List<Submission> sls = new ArrayList<>();
		sls.add(s);
		when(submissionRepoMock.findByHomeworkId("A001")).thenReturn(sls);
		assertEquals(sls, sd.findByHomeworkId("A001"));
	}

}

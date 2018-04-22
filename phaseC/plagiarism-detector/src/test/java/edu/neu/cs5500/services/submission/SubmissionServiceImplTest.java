/**
 * Test for SubmissionServiceImpl
 */
package edu.neu.cs5500.services.submission;

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
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.dao.submission.SubmissionDao;
import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 *
 */
@RunWith(SpringRunner.class)
public class SubmissionServiceImplTest {

	
	@TestConfiguration
    static class SubmissionServiceImplConfiguraton {
        @Bean
        public SubmissionService submissionService() {
            return new SubmissionServiceImpl();
        }
    }
	
	@Autowired
	SubmissionService ss;
	
	@MockBean
	private SubmissionDao submissionDaoMock;
	
	@MockBean
	private UserService userServiceMock;
	
	@MockBean
	private S3Services s3ServiceMock;
	
	@MockBean 
	private StorageService storageServiceMock;
	
	@MockBean 
	private AssignmentService assignService;
	
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
		s.set_id("11");
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
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#createSubmission(java.lang.String, java.lang.String, org.springframework.web.multipart.MultipartFile[])}.
	 */
	@Test
	public void testCreateSubmission() {
		when(s3ServiceMock.uploadFile(anyString(), anyObject())).thenReturn(Constants.SUCCESS);
		when(submissionDaoMock.createSubmission(anyObject())).thenReturn(s);
		when(userServiceMock.findUserById(anyString())).thenReturn(u);
		Assignment a = new Assignment();
		a.setSubmissionType("FILE");
		when(assignService.findAssignmentById(anyString())).thenReturn(a);
		MockMultipartFile firstFile = new MockMultipartFile("data", "filename.txt", "text/plain", "some xml".getBytes());
		MockMultipartFile[] m = {firstFile};
		assertEquals(s, ss.createSubmission("123", "A001", m));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#updateSubmission(edu.neu.cs5500.domainObjects.Submission)}.
	 * Success
	 */
	@Test
	public void testUpdateSubmission() {
		when(submissionDaoMock.findBy_id(anyString())).thenReturn(s);
		Submission s1 = new Submission();
		s1.set_id("11");
		s1.setStudentId("123");
		s1.setStudentName("*le");
		s1.setHomeworkId("A001");
		s1.setCourseId("C001");
		s1.setStatus("COMPARED");
		when(submissionDaoMock.updateSubmission(anyObject())).thenReturn(s1);
		assertEquals(s1, ss.updateSubmission(s1));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#updateSubmission(edu.neu.cs5500.domainObjects.Submission)}.
	 * Fail
	 */
	@Test
	public void testUpdateSubmissionFail() {
		when(submissionDaoMock.findBy_id(anyString())).thenReturn(null);
		assertEquals(null, ss.updateSubmission(s));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#updateSubmission(edu.neu.cs5500.domainObjects.Submission)}.
	 * Fail
	 */
	@Test
	public void testUpdateSubmissionFail2() {
		when(submissionDaoMock.findBy_id(anyString())).thenReturn(s);
		Submission s1 = new Submission();
		s1.set_id("11");
		s1.setStudentId("123");
		s1.setStudentName("*le");
		s1.setHomeworkId("A001");
		s1.setCourseId("C001");
		when(submissionDaoMock.updateSubmission(anyObject())).thenReturn(s);
		assertEquals(s, ss.updateSubmission(s1));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#deleteSubmission(java.lang.String)}.
	 */
	@Test
	public void testDeleteSubmission() {
		when(submissionDaoMock.deleteSubmissionBy_id(anyString())).thenReturn(true);
		assertEquals(true, ss.deleteSubmission("11"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#findByStudentId(java.lang.String)}.
	 * Success
	 */
	@Test
	public void testFindByStudentId() {
		List<Submission> sls = new ArrayList<>();
		sls.add(s);
		when(submissionDaoMock.findByStudentId(anyString())).thenReturn(sls);
		assertEquals(sls, ss.findByStudentId("123"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#findByStudentId(java.lang.String)}.
	 * Fail
	 */
	@Test
	public void testFindByStudentIdFail() {
		when(submissionDaoMock.findByStudentId(anyString())).thenReturn(null);
		assertEquals(new ArrayList<>(), ss.findByStudentId("123"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#findByHomeworkId(java.lang.String)}.
	 * Success
	 */
	@Test
	public void testFindByHomeworkId() {
		List<Submission> sls = new ArrayList<>();
		sls.add(s);
		when(submissionDaoMock.findByHomeworkId("A001")).thenReturn(sls);
		assertEquals(sls, ss.findByHomeworkId("A001"));
	}
	
	/**
	 * Test method for {@link edu.neu.cs5500.services.submission.SubmissionServiceImpl#findByHomeworkId(java.lang.String)}.
	 * Fail
	 */
	@Test
	public void testFindByHomeworkIdFail() {
		when(submissionDaoMock.findByHomeworkId("A001")).thenReturn(new ArrayList<>());
		assertEquals(new ArrayList<>(), ss.findByHomeworkId("A001"));
	}

}

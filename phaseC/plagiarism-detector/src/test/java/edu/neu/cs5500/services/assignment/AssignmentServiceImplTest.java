/**
 * 
 */
package edu.neu.cs5500.services.assignment;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyList;
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

import edu.neu.cs5500.dao.assignment.AssignmentDao;
import edu.neu.cs5500.dao.submission.SubmissionDao;
import edu.neu.cs5500.domainObjects.Assignment;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
public class AssignmentServiceImplTest {

	
	@TestConfiguration
	static class AssignmentServiceImplConfiguraton {
		@Bean
		public AssignmentService assignmentService() {
			return new AssignmentServiceImpl();
		}
	}
	
	@Autowired
	private AssignmentService as;
	
	@MockBean
	private AssignmentDao assignDao;
	
	@MockBean
	private SubmissionDao subDao;
	
	/**
	 * test for createAssignment
	 */
	@Test
	public void createAssignmentTestSuccess() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignDao.findAssignmentById(anyString())).thenReturn(null);
		when(assignDao.createAssignment(anyObject())).thenReturn(a);
		assertEquals(a, as.createAssignment(a));
	}
	
	/**
	 * test for createAssignment
	 */
	@Test
	public void createAssignmentTestFail() {
		Assignment a = new Assignment();
		a.setName("dssd");
		when(assignDao.findAssignmentById(anyString())).thenReturn(a);
		assertEquals(null, as.createAssignment(a));
	}
	
	/**
	 * test for createAssignment
	 */
	@Test
	public void createAssignmentTestFailNull() {
		assertEquals(null, as.createAssignment(null));
	}
	
	/**
	 * test for deleteAssignment
	 */
	@Test
	public void deleteAssignmentSuccess() {
		when(assignDao.findAssignmentById(anyString())).thenReturn(null);
		assertEquals(true, as.deleteAssignment("A0010"));
	}
	
	/**
	 * test for deleteAssignment
	 */
	@Test
	public void deleteAssignmentSuccess1() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignDao.findAssignmentById(anyString())).thenReturn(a);
		when(subDao.findByHomeworkId(anyString())).thenReturn(new ArrayList<>());
		when(subDao.deleteAllSubmissions(anyList())).thenReturn(true);
		assertEquals(false, as.deleteAssignment("1111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	/**
	 * test for deleteAssignment
	 */
	@Test
	public void deleteAssignmentFail1() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignDao.findAssignmentById(anyString())).thenReturn(a);
		when(subDao.findByHomeworkId(anyString())).thenReturn(new ArrayList<>());
		when(subDao.deleteAllSubmissions(anyList())).thenReturn(false);
		assertEquals(false, as.deleteAssignment("1111111111111111111111111111111111111111111111111111111111111111111"));
	}
	
	/**
	 * test for updateAssignment
	 */
	@Test
	public void updateAssignmentSuccess() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		
		Assignment b = new Assignment();
		b.set_id("A0010");
		b.setDocumentUrl("https://somw.com/assignment");
		b.setName("GIT2");
		b.setRelatedCourseId("125");
		b.setStatus("INACTIVE");
		b.setSubmissionType("ZIP");
		b.setDeadline("2018-05-03");
		
		when(assignDao.findAssignmentById(anyString())).thenReturn(a);
		when(assignDao.updateAssignment(anyObject())).thenReturn(b);
		assertEquals(b, as.updateAssignment(b));
	}
	
	/**
	 * test for updateAssignment
	 */
	@Test
	public void updateAssignmentSuccess2() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignDao.findAssignmentById(anyString())).thenReturn(null);
		when(assignDao.updateAssignment(anyObject())).thenReturn(null);
		assertEquals(null, as.updateAssignment(a));
	}
	
	/**
	 * test for updateAssignment
	 */
	@Test
	public void updateAssignmentSuccess3() {
		Assignment input = new Assignment();
		input.set_id("A0010");
		input.setDocumentUrl("https://someurl.com/assignment");
		input.setName("GIT");
		input.setRelatedCourseId("124");
		input.setStatus("ACTIVE");
		input.setSubmissionType("File");
		input.setDeadline("2018-04-03");
		
		Assignment find = new Assignment();
		find.set_id("A0010");
		find.setDocumentUrl("https://someurl.com/assignment");
		find.setName("GIT");
		find.setRelatedCourseId("124");
		find.setStatus("ACTIVE");
		find.setSubmissionType("File");
		find.setDeadline("2018-04-03");
		
		when(assignDao.findAssignmentById(anyString())).thenReturn(find);
		when(assignDao.updateAssignment(anyObject())).thenReturn(find);
		assertEquals(find, as.updateAssignment(input));
	}
	
	/**
	 * test for updateAssignment
	 */
	@Test
	public void updateAssignmentSuccess4() {
		Assignment input = new Assignment();
		input.set_id("A0010");
		
		Assignment find = new Assignment();
		find.set_id("A0010");
		find.setDocumentUrl("https://someurl.com/assignment");
		find.setName("GIT");
		find.setRelatedCourseId("124");
		find.setStatus("ACTIVE");
		find.setSubmissionType("File");
		find.setDeadline("2018-04-03");
		
		when(assignDao.findAssignmentById(anyString())).thenReturn(find);
		when(assignDao.updateAssignment(anyObject())).thenReturn(find);
		assertEquals(find, as.updateAssignment(input));
	}
	
	/**
	 * test for findAllAssignments
	 */
	@Test
	public void findAllAssignmentsSuccess() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		List<Assignment> assignList = new ArrayList<>();
		assignList.add(a);
		when(assignDao.findAllAssignments()).thenReturn(assignList);
		assertEquals(assignList, as.findAllAssignments());
	}
	
	/**
	 * test for findAssignmentById
	 */
	@Test
	public void findAssignmentByIdSuccess() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignDao.findAssignmentById(anyString())).thenReturn(a);
		assertEquals(a, as.findAssignmentById("A0010"));
	}
	
	/**
	 * test for findAllCourseRelatedAssignments
	 */
	@Test
	public void findAllCourseRelatedAssignmentsSuccess() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		a.setRelatedCourseId("123");
		List<Assignment> assignLs = new ArrayList<>();
		assignLs.add(a);
		Iterable<Assignment> assignItr = assignLs;
		when(assignDao.findAllAssignments()).thenReturn(assignItr);
		assertEquals(assignLs, as.findAllCourseRelatedAssignments("123"));
	}
	
	/**
	 * test for findAllCourseRelatedAssignments
	 */
	@Test
	public void findAllCourseRelatedAssignmentsSuccess2() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		
		Assignment a1 = new Assignment();
		a1.set_id("A0010");
		a1.setDocumentUrl("https://someurl.com/assignment");
		a1.setName("GIT");
		a1.setRelatedCourseId("124");
		a1.setStatus("ACTIVE");
		a1.setSubmissionType("File");
		a1.setDeadline("2018-04-03");
		a1.setRelatedCourseId("123");
		
		List<Assignment> assignLs = new ArrayList<>();
		assignLs.add(a1);
		assignLs.add(a);
		
		List<Assignment> assignLs1 = new ArrayList<>();
		assignLs1.add(a1);
		Iterable<Assignment> assignItr = assignLs;
		when(assignDao.findAllAssignments()).thenReturn(assignItr);
		assertEquals(assignLs1, as.findAllCourseRelatedAssignments("123"));
	}
	
	/**
	 * test for findAllCourseRelatedAssignments
	 */
	@Test
	public void findAllCourseRelatedAssignmentsSuccess1() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		List<Assignment> assignLs = new ArrayList<>();
		assignLs.add(a);
		Iterable<Assignment> assignItr = assignLs;
		when(assignDao.findAllAssignments()).thenReturn(null);
		assertEquals(new ArrayList<>(), as.findAllCourseRelatedAssignments("124"));
	}
	
}

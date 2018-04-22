/**
 * 
 */
package edu.neu.cs5500.dao.assignment;

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

import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.repository.AssignmentRepository;

/**
 * @author sanketmathur
 *
 */

@RunWith(SpringRunner.class)
public class AssignmentDaoTest {

	@TestConfiguration
	static class AssignmentDaoConfiguration {
		@Bean
		public AssignmentDao assignmentDao() {
			return new AssignmentDaoImpl();
		}
	}
	
	@Autowired
	private AssignmentDao assignDao; 
	
	@MockBean
	private AssignmentRepository assignRepoMock;
	
	/**
	 * Test method for {@link edu.neu.cs5500.dao.assignment.AssignmentDaoImpl#createAssignment(edu.neu.cs5500.domainObjects.Assignment)}.
	 */
	@Test
	public void testCreateAssignment() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignRepoMock.save((Assignment)anyObject())).thenReturn(a);
		assertEquals(a, assignDao.createAssignment(a));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.assignment.AssignmentDaoImpl#deleteAssignment(edu.neu.cs5500.domainObjects.Assignment)}.
	 */
	@Test
	public void testDeleteAssignment() {
		Assignment a = new Assignment();
		a.set_id("1111111111111111111111111111111111111111111111111111111111111111");
		assignDao.deleteAssignment(a);
		when(assignDao.findAssignmentById("1111111111111111111111111111111111111111111111111111111111111111")).thenReturn(null);
		assertEquals(null, assignRepoMock.findOne("1111111111111111111111111111111111111111111111111111111111111111"));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.assignment.AssignmentDaoImpl#updateAssignment(edu.neu.cs5500.domainObjects.Assignment)}.
	 */
	@Test
	public void testUpdateAssignment() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignRepoMock.save((Assignment)anyObject())).thenReturn(a);
		assertEquals(a, assignDao.updateAssignment(a));
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.assignment.AssignmentDaoImpl#findAllAssignments()}.
	 */
	@Test
	public void testFindAllAssignments() {
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
		Iterable<Assignment> assignIter = assignLs;
		when(assignRepoMock.findAll()).thenReturn(assignIter);
		assertEquals(assignIter, assignDao.findAllAssignments());
	}

	/**
	 * Test method for {@link edu.neu.cs5500.dao.assignment.AssignmentDaoImpl#findAssignmentById(java.lang.String)}.
	 */
	@Test
	public void testFindAssignmentById() {
		Assignment a = new Assignment();
		a.set_id("A0010");
		a.setDocumentUrl("https://someurl.com/assignment");
		a.setName("GIT");
		a.setRelatedCourseId("124");
		a.setStatus("ACTIVE");
		a.setSubmissionType("File");
		a.setDeadline("2018-04-03");
		when(assignRepoMock.findOne(anyString())).thenReturn(a);
		assertEquals(a, assignDao.findAssignmentById("A0010"));
	}

}

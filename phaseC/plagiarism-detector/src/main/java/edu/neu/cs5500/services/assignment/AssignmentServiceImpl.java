/**
 * This is the service layer implementation, which will
 * contain all the business logic for the assignment
 */
package edu.neu.cs5500.services.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cs5500.dao.assignment.AssignmentDao;
import edu.neu.cs5500.dao.submission.SubmissionDao;
import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.Submission;

/**
 * @author sanketmathur
 *
 */
@Service("assignService")
public class AssignmentServiceImpl implements AssignmentService {

	
	/**
	 * dao reference for the Assignment
	 */
	@Autowired
	private AssignmentDao assignDao;
	
	@Autowired
	private SubmissionDao subDao;
	
	/**
	 * called to create an assignment
	 * @param assign: the assignment object to be created
	 * @return the Assignment created
	 */
	@Override
	public Assignment createAssignment(Assignment assign) {
		if(assign != null) {
			Assignment assign1 = assignDao.findAssignmentById(assign.get_id());
			if(assign1 != null) {
				return null;
			}
			return assignDao.createAssignment(assign);
		}
		return null;
	}
	
	/**
	 * deletes an assignment from the database
	 * @param assign: the assignment object to be deleted
	 * @return true iff the Assignment is deleted from the database
	 */
	@Override
	public boolean deleteAssignment(String id) {
		Assignment assign = assignDao.findAssignmentById(id);
		if(assign != null) {
			List<Submission> listAssignment = subDao.findByHomeworkId(id);
			if(subDao.deleteAllSubmissions(listAssignment)) {
				assignDao.deleteAssignment(assign);
			}
		}
		return assignDao.findAssignmentById(id) == null;
	}
	
	/**
	 * Updates the assingment
	 * @param assign: the new assignment object
	 * @return the Assignment updated
	 */
	@Override
	public Assignment updateAssignment(Assignment assign) {
		Assignment assign1 = assignDao.findAssignmentById(assign.get_id());
		if(assign1 != null) {
			if(assign.getName() != null && !assign.getName().equals(assign1.getName())) {
				assign1.setName(assign.getName());
			}
			if(assign.getStatus() != null && !assign.getStatus().equals(assign1.getStatus())) {
				assign1.setStatus(assign.getStatus());
			}
			if(assign.getDeadline() != null && !assign.getDeadline().equals(assign1.getDeadline())) {
				assign1.setDeadline(assign.getDeadline());
			}
			if(assign.getDocumentUrl() != null && !assign.getDocumentUrl().equals(assign1.getDocumentUrl())) {
				assign1.setDocumentUrl(assign.getDocumentUrl());
			}
			if(assign.getSubmissionType() != null && !assign.getSubmissionType().equals(assign1.getSubmissionType())) {
				assign1.setSubmissionType(assign.getSubmissionType());
			}
			if(assign.getRelatedCourseId() != null && !assign.getRelatedCourseId().equals(assign1.getRelatedCourseId())) {
				assign1.setRelatedCourseId(assign.getRelatedCourseId());
			}
 		}
		return assignDao.updateAssignment(assign1);
	}
	
	/**
	 * 
	 * @return list of all the Assignments
	 */
	@Override
	public List<Assignment> findAllAssignments() {
		return (List<Assignment>) assignDao.findAllAssignments();
	}
	
	/**
	 * 
	 * @param id: the assignment id to find
	 * @return the Assignment associated with the given id 
	 */
	@Override
	public Assignment findAssignmentById(String id) {
		return assignDao.findAssignmentById(id);
	}
	

	/**
	 * @param courseId
	 * @return list of all the Assignments related to this course
	 */
	@Override
	public List<Assignment> findAllCourseRelatedAssignments(String courseId) {
		Iterable<Assignment> it = assignDao.findAllAssignments();
		List<Assignment> assigns = new ArrayList<>();
		if(it != null) {
			assigns = StreamSupport.stream(it.spliterator(), false)
					.filter(s -> s.getRelatedCourseId()!=null)
					.filter(s -> s.getRelatedCourseId().equals(courseId))
					.collect(Collectors.toList());
		}
		return assigns;
	}
}

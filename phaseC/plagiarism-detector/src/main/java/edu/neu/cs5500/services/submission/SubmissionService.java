package edu.neu.cs5500.services.submission;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.domainObjects.Submission;

/**
 * 
 * @author sanketmathur
 */

public interface SubmissionService {
	
	/**
	 * creates a new submission
	 * @param sub: submission object to be created
	 * @return the submission created
	 */
	public Submission createSubmission(String userId, String assignmentId, MultipartFile[] uploadingFiles);
	
	/**
	 * update en existing submission with the given course
	 * @param sub: the given submission
	 * @return the updated submission
	 */
	public Submission updateSubmission(Submission sub);
	
	/**
	 * deletes a submission with the given id
	 * @param id: submission id to be deleted
	 * @return true iff the submission is successfully deleted
	 */
	public Boolean deleteSubmission(String id);

	
	/**
	 * To find all submissions belonging to a particular student
	 * @param studentId: user id of the student
	 * @return list of submission objects associated with the given user id
	 */

	public List<Submission> findByStudentId(String studentId);
	
	/**
	 * To find all submissions belonging to a particular homework
	 * @param homeworkId: assignment id
	 * @return list of submission objects associated with the given assignment id
	 */
	public List<Submission> findByHomeworkId(String homeworkId);
	
	
	public Submission findSubmissionById(String submissionId);

}

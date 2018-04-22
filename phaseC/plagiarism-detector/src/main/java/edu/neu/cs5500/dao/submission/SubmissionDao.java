package edu.neu.cs5500.dao.submission;
import java.util.List;

import edu.neu.cs5500.domainObjects.Submission;
/**
 * SubmissionDao represents data access object for Submission
 * @author JayanthGangadhar
 *
 */
public interface SubmissionDao {
	
	/**
	 * To find submission by Id
	 * @param subId represents id of submission
	 * @return submission object of subId
	 */
	public Submission findBy_id(String subId);
	
	/**
	 * To create a new Submission
	 * @param sub represents a submission object
	 * @return created submission object
	 */
	public Submission createSubmission(Submission sub);
	
	/**
	 * To update an existing submission
	 * @param sub represents the updated submission object
	 * @return true iff submission has been updated else false
	 */
	public Submission updateSubmission(Submission sub);

	/**
	 * To delete an existing submission
	 * @param id represents id of the submission to be deleted
	 * @return true iff the submission exists and is deleted
	 */
	public Boolean deleteSubmissionBy_id(String id);
	
	/**
	 * delete all submissions
	 * @param submissions
	 * @return
	 */
	public Boolean deleteAllSubmissions(List<Submission> submissions);

	/**
	 * To return all submission of a particular student enrolled in a particular course
	 * @param studentId represents id of the student 
	 * @param courseId represents id of course
	 * @return list of all submissions belonging to a student 
	 */
	public List<Submission> findByStudentId(String studentId);
	
	/**
	 * To return all submission of a particular homework
	 * @param homeworkId represents id of the homework
	 * @return list of all submissions belonging to a homework
	 */
	public List<Submission> findByHomeworkId(String homeworkId);

}

/**
 * This is the DAO (data access object) layer implementation, which will interact
 * with the database
 * Implements SubmissionDao
 */
package edu.neu.cs5500.dao.submission;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.repository.SubmissionRepository;
import edu.neu.cs5500.utils.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * SubmissionDaoImpl is a class that implements all methods of Submission Data Access Object
 * @author JayanthGangadhar
 *
 */
@Repository("submissionDao")
public class SubmissionDaoImpl implements SubmissionDao {
	// Logger
	private static Logger logger = Logger.getLogger(SubmissionDaoImpl.class.getName());
	@Autowired
	private SubmissionRepository submissionRepo;
	
	/**
	 * find a submission by given id
	 * @param subId: given submission id
	 * @return found submission object
	 */
	@Override
	public Submission findBy_id(String subId) {
		Submission s1 = null;
		try {
			s1 = submissionRepo.findBy_id(subId);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return s1;
	}

	
	/**
	 * creates a new submission
	 * @param sub: submission object to be created
	 * @return the submission created	
	 * To create a new submission

	 */
	@Override
	public Submission createSubmission(Submission sub) {
		try {
			return submissionRepo.save(sub);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return null;
	}
	
	/**
	 * update en existing submission with the given course
	 * @param sub: the given submission
	 * @return the updated submission
	 */
	@Override
	public Submission updateSubmission(Submission sub) {
		try {
			return submissionRepo.save(sub);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return null;
	}
	
	/**
	 * deletes a submission with the given id
	 * @param id: submission id to be deleted
	 * @return true iff the submission is successfully deleted
	 */
	@Override
	public Boolean deleteSubmissionBy_id(String id) {
		Submission sub = submissionRepo.findBy_id(id);
		if (sub!=null) {
			submissionRepo.delete(sub);
			return true;
		}

		return false;
	}
	
	/**
	 * To delete all submission with the provided list
	 * @param submissions: list of submissions object to be deleted
	 * @return true iff all the submissions were deleted
	 */
	@Override
	public Boolean deleteAllSubmissions(List<Submission> submissions) {
		try {
			submissionRepo.delete(submissions);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return false;
		}
		return true;
	}
	
	/**
	 * To find all submissions belonging to a particular student
	 * @param studentId: user id of the student
	 * @return list of submission objects associated with the given user id
	 */
	@Override
	public List<Submission> findByStudentId(String studentId) {
		List<Submission> result = null;
		try {
			Iterable<Submission> it = submissionRepo.findByStudentId(studentId);
			if(it != null) {
				result = new ArrayList<>();
				for(Submission sub: it) {
					result.add(sub);
				}
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
	}
	
	/**
	 * To find all submissions belonging to a particular homework
	 * @param homeworkId: assignment id
	 * @return list of submission objects associated with the given assignment id
	 */

	@Override
	public List<Submission> findByHomeworkId(String homeworkId) {
		List<Submission> result = null;
		try {
			Iterable<Submission> it = submissionRepo.findByHomeworkId(homeworkId);
			if(it != null) {
				result = new ArrayList<>();
				for(Submission sub: it) {
					result.add(sub);
				}
			}
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return result;
	}
}

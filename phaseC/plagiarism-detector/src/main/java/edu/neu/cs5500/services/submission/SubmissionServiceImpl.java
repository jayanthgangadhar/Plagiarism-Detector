/**
 * This is the service layer implementation, which will
 * contain all the business logic for the submission object 
 * Implements SubmissionService
 */
package edu.neu.cs5500.services.submission;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.dao.submission.SubmissionDao;
import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.file.S3Services;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.storage.StorageService;
import edu.neu.cs5500.utils.Constants;

/**
 * 
 * Service to implement all the functionality related to submissions
 * @author Asim 
 *
 */
@Service("submissionService")
public class SubmissionServiceImpl implements SubmissionService {
	
	private static Logger logger = Logger.getLogger(SubmissionServiceImpl.class.getName());
	
	@Autowired
	private SubmissionDao submissionDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private S3Services s3Service;
	
	@Autowired 
	private StorageService storageService;
	
	@Autowired 
	private AssignmentService assignService;
	
	/**
	 * creates a new submission
	 * @param sub: submission object to be created
	 * @return the submission created
	 */
	@Override
	public Submission createSubmission(String userId, String assignmentId, MultipartFile[] uploadingFiles) {
		List<FileTuple> urls = new ArrayList<>();
		try {
			storageService.init(userId);
			for(MultipartFile file: uploadingFiles) {
				File f = storageService.store(file,Constants.EMPTY_STRING);
				Long filePath = System.currentTimeMillis();
				String f1 = s3Service.uploadFile(filePath.toString() + ".py", f);
				if(!Constants.SUCCESS.equals(f1)) {
					return null;
				}
				
				FileTuple ft = new FileTuple();
				ft.setFileText1(file.getOriginalFilename());
				ft.setFileText2("https://s3.amazonaws.com/msd-team-206/" + filePath.toString() + ".py");
				urls.add(ft);
			}
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
			return null;
		}

		User u = userService.findUserById(userId);
		Submission sub = new Submission();
		sub.setStudentId(userId);
		sub.setHomeworkId(assignmentId);
		sub.setStatus("NEW");
		sub.setUrl(urls);
		sub.setStudentName(u.getFirstName() + " " + u.getLastName());
		sub.setName(assignmentId + "_" + u.getLastName() + "_" + u.getFirstName());
		sub.setSubmissionDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
		sub.setSubmissionType(assignService.findAssignmentById(assignmentId).getSubmissionType());
		return submissionDao.createSubmission(sub);
	}

	/**
	 * update en existing submission with the given course
	 * @param sub: the given submission
	 * @return the updated submission
	 */
	@Override
	public Submission updateSubmission(Submission sub) {
		Submission s = submissionDao.findBy_id(sub.get_id());
		if(s!=null) {
			if(sub.getSubmissionType() != null) {
				s.setSubmissionType(sub.getSubmissionType());
			}
			if(sub.getStatus() != null) {
				s.setStatus(sub.getStatus());
			}
      return submissionDao.updateSubmission(s);
		}
		return null;
	}

	/**
	 * deletes a submission with the given id
	 * @param id: submission id to be deleted
	 * @return true iff the submission is successfully deleted
	 */
	@Override
	public Boolean deleteSubmission(String id) {
		return submissionDao.deleteSubmissionBy_id(id);
	}

	/**
	 * To find all submissions belonging to a particular student
	 * @param studentId: user id of the student
	 * @return list of submission objects associated with the given user id
	 */
	@Override
	public List<Submission> findByStudentId(String studentId) {
		List<Submission> submissions = submissionDao.findByStudentId(studentId); 
		if(submissions != null && !submissions.isEmpty()) {
			return submissions; 
		}
		return new ArrayList<>();
	}

	
	/**
	 * To find all submissions belonging to a particular homework
	 * @param homeworkId: assignment id
	 * @return list of submission objects associated with the given assignment id
	 */
	@Override
	public List<Submission> findByHomeworkId(String homeworkId) {
		List<Submission> submissions = submissionDao.findByHomeworkId(homeworkId); 
		if(submissions != null && !submissions.isEmpty()) {
			return submissions; 
		}
		return new ArrayList<>();
	}

	@Override
	public Submission findSubmissionById(String submissionId) {
		return submissionDao.findBy_id(submissionId);
	}
}

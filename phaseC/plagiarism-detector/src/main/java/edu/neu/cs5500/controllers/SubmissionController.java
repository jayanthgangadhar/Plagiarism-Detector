/**
 * Submission Controller represents the controller layer for Submission
 * This class will have all the apis related to the submission
 * Will be used to interact with the front end
 */
package edu.neu.cs5500.controllers;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.domainObjects.Assignment;

import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.StringList;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.file.FileService;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.submission.SubmissionService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

/**
 * @author sanketmathur
 * Submission Controller represents the controller layer for Submission Enity
 * it has all CRUD operations for the submissions along with other getters
 * @author JayanthGangadhar
 *

 */
@RestController
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private FileService fileService;

	@Autowired
	private ReportService reportService;


	@Autowired
	private UserService userService;



	@Autowired
	private AssignmentService assignService;



	/**
	 * Create a new submission
	 * @param userId: user logged in and performing this task
	 * @param assignmentId: the assignment id under which this submission will be created
	 * @param uploadingFiles: submission files
	 * @return submission object as response
	 */
	@RequestMapping(value = "/api/{userId}/{assignmentId}/submission", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<ServiceResponse> createSubmission(@PathVariable("userId") String userId,
			@PathVariable("assignmentId") String assignmentId,
			@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles) {

		ServiceResponse response = new ServiceResponse();
		if (uploadingFiles == null || uploadingFiles.length < 1) {
			Utility.setResponseObject(null, "400", "Invalid Input", response);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

		Submission s = submissionService.createSubmission(userId, assignmentId, uploadingFiles);
		if (s != null) {
			Utility.setResponseObject(s, Constants.SUCCESS, "Created Submission Successfully", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(s, "500", "Submission Not Created", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Updates the Submission data with the given submission object
	 * @param id: user logged in and performing this task
	 * @param submission: the new submission object which will update the old one
	 * @return response object
	 */
	@RequestMapping(value = "/api/user/{userId}/submission", method = RequestMethod.PUT)
	public ResponseEntity<ServiceResponse> updateSubmission(@PathVariable("userId") String id, @RequestBody Submission sub) {

		ServiceResponse response = new ServiceResponse();
		Submission s = submissionService.updateSubmission(sub);
		if (s != null) {
			Utility.setResponseObject(sub, Constants.SUCCESS, "Updated the submission", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}



		Utility.setResponseObject(null, "404", Constants.SUBMISSION_NOT_FOUND, response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}


	/**
	 * Search for all submission with the given homeworkId
	 * @param id: the user id of the person who is logged in
	 * @param homeworkId: the assignment id whose submission shall be the outpur
	 * @return submission object as response
	 */
	@RequestMapping(value = "/api/{userId}/{homeworkId}/submission", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findSubmissionByHomeworkId(@PathVariable("userId") String id, @PathVariable("homeworkId") String hwId) {

		ServiceResponse response = new ServiceResponse();

		List<Submission> submissions = submissionService.findByHomeworkId(hwId);

		if (submissions.isEmpty()) {

			Utility.setResponseObject(null, "404", Constants.SUBMISSION_NOT_FOUND, response);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(submissions, Constants.SUCCESS, "Found the Submissions", response);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	/**
	 * find the submission with the given student id 
	 * @param id: the user id of the person who is logged in
	 * @param stdId: student id whose submission will be the output
	 * @return list of submission objects as response
	 */

	@RequestMapping(value="/api/{userId}/submission/{studentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> findByStudentId(@PathVariable("userId") String id, @PathVariable("studentId") String stdId){
		ServiceResponse response = new ServiceResponse();
		List<Submission> submissions = submissionService.findByStudentId(stdId);
		if(submissions.isEmpty()) {

			Utility.setResponseObject(null, "404", Constants.SUBMISSION_NOT_FOUND, response);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Utility.setResponseObject(submissions, Constants.SUCCESS, "Found " + submissions.size() + " submissions.", response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	/**
	 * compare all the submission by the given assignment id
	 * @param userId: the user id of the person who is logged in
	 * @param assignmentId: whose submissions will be compared
	 * @return operation object in response
	 */
	@RequestMapping(value="/api/{userId}/submission/cmpallsubmissions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> compareAllSubmissionsByAssignmentId(@PathVariable("userId") String userId, @RequestParam("asId") String assignmentId){
		ServiceResponse response = new ServiceResponse();
		List<Submission> allSubmissions = submissionService.findByHomeworkId(assignmentId);
		String operationIdGenerated=null;

		if (userId==null || userId.isEmpty() || userService.findUserById(userId)==null) {
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.USER_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}



		if (assignmentId==null || assignmentId.isEmpty()) {
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "Invalid Assignment ID", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}


		Assignment a = assignService.findAssignmentById(assignmentId);
		String submissionType = a.getSubmissionType();

		try {
			List<StudentCompareResult> lspr = new ArrayList<>();

			for (int i = 0; i < allSubmissions.size()-1;i++) {
				Submission submission1 = allSubmissions.get(i);
				for (int j = i+1; j < allSubmissions.size();j++) {					
					Submission submission2 = allSubmissions.get(j);
					if (!submission1.get_id().equals(submission2.get_id())) {						
						StudentCompareResult scr = 
								fileService.compareTwoSubmissionFolders
								(submission1.getUrl(), submission2.getUrl(), userId, submission1.getStudentId(), submission2.getStudentId(), submissionType);
						if (scr!=null) {
							lspr.add(scr);	
						}
					}
				}
			}

			Operation op = new Operation();
			op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

			op.setOperationType("Submission Comparison");		
			op.setStudentResult(lspr);
			op.setUserId(userId);
			op.setInitiatedBy("User");

			operationIdGenerated = reportService.saveOperation(op);

			if (operationIdGenerated == null) {
				throw new Exception("Error while save the operation");

			}

			Utility.setResponseObject(operationIdGenerated, Constants.SUCCESS, "Submission Comparison Successfull", response);
			return new ResponseEntity<>(response, HttpStatus.OK);

		}catch (Exception e) {
			Utility.setResponseObject(null, "404", Constants.SUBMISSION_NOT_FOUND, response);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}


	// Compare selective submissions
	/**
	 * compare Only the submissions that are selected by the user
	 * @param userId: the user id of the person who is logged in
	 * @param assignmentId: whose submissions will be compared
	 * @return operation object in response
	 */
	@RequestMapping(value="/api/{userId}/submission/cmpallsubmissions", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> compareSelectiveSubmissions(@PathVariable("userId") String userId, @RequestBody StringList inputSubmissionIds){
		ServiceResponse response = new ServiceResponse();

		String operationIdGenerated=null;
		

		if (inputSubmissionIds == null || inputSubmissionIds.getInputList()==null || inputSubmissionIds.getInputList().size()<2) {
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "Enter atleast 2 submissions", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		if (userId==null || userId.isEmpty() || userService.findUserById(userId)==null) {
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.USER_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		
		List<Submission> allSubmissions = inputSubmissionIds.getInputList().stream().map(item -> {
			return submissionService.findSubmissionById(item);
		}).collect(Collectors.toList());



		Assignment a = assignService.findAssignmentById(allSubmissions.get(0).getHomeworkId());
		String submissionType = a.getSubmissionType();

		try {
			List<StudentCompareResult> lspr = new ArrayList<>();

			for (int i = 0; i < allSubmissions.size()-1;i++) {
				Submission submission1 = allSubmissions.get(i);
				for (int j = i+1; j < allSubmissions.size();j++) {					
					Submission submission2 = allSubmissions.get(j);
					if (!submission1.get_id().equals(submission2.get_id())) {						
						StudentCompareResult scr = 
								fileService.compareTwoSubmissionFolders
								(submission1.getUrl(), submission2.getUrl(), userId, submission1.getStudentId(), submission2.getStudentId(), submissionType);
						if (scr!=null) {
							lspr.add(scr);	
						}
					}
				}
			}

			Operation op = new Operation();
			op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));

			op.setOperationType("Submission Comparison");		
			op.setStudentResult(lspr);
			op.setUserId(userId);
			op.setInitiatedBy("User");

			operationIdGenerated = reportService.saveOperation(op);

			if (operationIdGenerated == null) {
				throw new Exception("Error while save the operation");

			}

			Utility.setResponseObject(operationIdGenerated, Constants.SUCCESS, "Submission Comparison Successfull", response);
			return new ResponseEntity<>(response, HttpStatus.OK);

		}catch (Exception e) {
			Utility.setResponseObject(null, "404", Constants.SUBMISSION_NOT_FOUND, response);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}





}

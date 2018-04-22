package edu.neu.cs5500.controllers;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.cs5500.domainObjects.EMail;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.OperationComparator;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.ReportComparator;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.email.MailService;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

@RestController
public class ReportController {

	// Logger
	private static Logger logger = Logger.getLogger(FileController.class.getName());

	@Autowired
	private ReportService reportService;
	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;


	/**
	 * @param id
	 * @return
	 * 
	 * Returns all operations performed by the user based on input user ID
	 */
	@RequestMapping(value = "/api/user/{userId}/operation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> getOperationsByUserId(@PathVariable("userId") String userId) {

		ServiceResponse response = new ServiceResponse();

		if (userService.findUserById(userId)!=null) {
			List<Operation> operations= reportService.getOperationsByUserId(userId);

			if (operations != null && !operations.isEmpty()) {

				Collections.sort(operations, new OperationComparator());

				Utility.setResponseObject(operations, Constants.SUCCESS, "Found operations for the user", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);

		}else {
			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.USER_NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);

		}

	}


	/**
	 * @param id
	 * @return
	 * Returns all Student Pair reports based on Operation ID
	 */
	@RequestMapping(value = "/api/user/{userId}/operation/{opId}/studentsInvolved", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> getStudentsDetailsByOperationsId(@PathVariable("userId") String userId,@PathVariable("opId") String opId) {

		ServiceResponse response = new ServiceResponse();

		if (reportService.findOperationById(opId)!=null) {
			List<StudentCompareResult> results= reportService.getStudentCompareResultByOpId(opId);	
			if (results != null && !results.isEmpty()) {

				Utility.setResponseObject(results, Constants.SUCCESS, "Found results for the operationID", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {

			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "Operation ID Does not exist", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}



	/**
	 * @param id
	 * @return
	 * 
	 * returns all the reports based on input comparison ID
	 */
	@RequestMapping(value = "/api/user/{userId}/operation/{opId}/studentsInvolved/{stcid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> getReportsOnStudentCompareId(@PathVariable("userId") String userId,
			@PathVariable("opId") String opId,
			@PathVariable("stcid") String stcid) {

		ServiceResponse response = new ServiceResponse();

		if (reportService.findStudentCompById(stcid) != null) {
			List<Report> results= reportService.getAllReportsByStudentCompareId(stcid);
			if (results != null && !results.isEmpty()) {
				Collections.sort(results,new ReportComparator());
				Utility.setResponseObject(results, Constants.SUCCESS, "Found the reports", response);
				return new ResponseEntity<>(response, HttpStatus.OK);
			}

			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, Constants.NOT_FOUND, response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}else {

			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "ID Does not exist", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	/**
	 * @param id
	 * @return
	 * 
	 * Send plagiarism report two the selected students
	 */
	@RequestMapping(value = "/api/user/studentNotif", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> sendEmailToDefaulterStudents(@RequestParam("userId") String userId,
			@RequestParam("st1Id") String st1Id,
			@RequestParam("st2Id") String st2Id,
			@RequestParam("sim") String matchValue) {

		ServiceResponse response = new ServiceResponse();


		if (userId == null || st1Id == null || st2Id == null || matchValue==null) {
			Utility.setResponseObject(null, Constants.BAD_REQUEST, "Invalid Input", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}


		User prof = userService.findUserById(userId);
		User stu1 = userService.findUserById(st1Id);
		User stu2 = userService.findUserById(st2Id);

		if (prof != null && stu1!=null && stu2!=null) {

			createEmail(prof,stu1,matchValue);
			createEmail(prof,stu2,matchValue);
			Utility.setResponseObject(null, Constants.SUCCESS, "Email Sent to the students!", response);
			return new ResponseEntity<>(response, HttpStatus.OK);

		}else {

			Utility.setResponseObject(null, Constants.ERROR_CODE_NOTFOUND, "ID Does not exist", response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

	}

	private void createEmail(User prof, User stu,String matchValue) {


		// Send Email to registered user

		String message = "Hi, " +"\n\n\n"+
				"A possible case of plagiarism has been found in an assignment that you submitted with another student ( Similarity of "+ matchValue+"% )"

				+ "\n\nPlease visit Prof. " +prof.getFirstName() + " " + prof.getLastName() + " for further discussion."+
				"\n\n\nThanks,\nSupport Team";
		String to = stu.getEmailAddress();
		String from = "asim.khan17790@gmail.com";
		String subject = "DO NOT REPLY - Your Submission has been identified in a Plagiarism Act";

		EMail mail = new EMail();
		mail.setEmailMessage(message);
		mail.setEmailSubject(subject);
		mail.setTo(to);
		mail.setFrom(from);
		mail.setCc(prof.getEmailAddress());

		String emailSentResult = mailService.sendEmail(mail);
		if (emailSentResult!=null && emailSentResult.equals(Constants.SENT)) {
			logger.info("Plagiarism detection mail SENT to  Student: " + stu.getEmailAddress());	
		}else {
			logger.info("Plagiarism detection Mail could not be sent to Student: " + stu.getEmailAddress());
		}
	}


}

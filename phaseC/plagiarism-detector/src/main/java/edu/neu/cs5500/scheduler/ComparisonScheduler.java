package edu.neu.cs5500.scheduler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import edu.neu.cs5500.domainObjects.Assignment;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.EMail;
import edu.neu.cs5500.domainObjects.Operation;
import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.domainObjects.ServiceResponse;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.assignment.AssignmentService;
import edu.neu.cs5500.services.course.CourseService;
import edu.neu.cs5500.services.email.MailService;
import edu.neu.cs5500.services.file.FileService;
import edu.neu.cs5500.services.report.ReportService;
import edu.neu.cs5500.services.semester.SemesterService;
import edu.neu.cs5500.services.submission.SubmissionService;
import edu.neu.cs5500.services.user.UserService;
import edu.neu.cs5500.utils.Constants;

/**
 * @author Asim
 * 
 * Scheduler CRON JOB which checks iteratively if there are new submissions uploaded by students and hence checks for plagiarism on the newly uploaded submissions every 11 pm every day
 *
 */
@Component
public class ComparisonScheduler {


	// Logger
	private static Logger logger = Logger.getLogger(ComparisonScheduler.class.getName());

	@Autowired
	private SemesterService semService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private AssignmentService assignService;

	@Autowired
	private SubmissionService submissionService;


	@Autowired
	private UserService userService;


	@Autowired
	private FileService fileService;


	@Autowired
	private ReportService reportService;
	
	
	@Autowired
	private MailService mailService;



	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	// Scheduled for 11pm everyday
	/**
	 * Scheduler method which checks for plagiarism iteratively
	 */
	@Scheduled(cron="0 * */2 * * *")
	public void generateReportCurrentTime() {

		

		logger.info(String.format("Scheduled Comparison Started at  {%s}", dateFormat.format(new Date())));

		// Find all All Active semesters
		// Find all ActiveCourses in each semester
		// Find All Home Works in each Course
		// Find All New Submissions in that assignment
		// Find All Submissions in that that assignment
		// Compare New Assignments with All the other assignments	
		// find all submissions
		// find all active subsmissions

		List<Semester> semesters = semService.findAllActiveSemesters();

		for (Semester eachSem: semesters) {

			if (eachSem.get_id() !=null && !eachSem.get_id().isEmpty()) {

				List<Course> courses = courseService.findAllCoursesInThisSemester(eachSem.get_id());
				for (Course eachCourse : courses) {

					if (eachCourse.get_id()!=null && !eachCourse.get_id().isEmpty()) {
						List<Assignment> assignments = assignService.findAllCourseRelatedAssignments(eachCourse.get_id());

						for (Assignment assignment : assignments) {
							if (assignment.get_id()!=null && !assignment.get_id().isEmpty()) {

								// Compare all new submissions only with existing submissions
								// And also new submissions among each other


								List<Submission> allSubmissions = submissionService.findByHomeworkId(assignment.get_id());

								List<Submission> allActiveSubmissions = allSubmissions.stream()
										.filter(eachSubmission -> eachSubmission.getStatus()!=null && Constants.NEW.equals(eachSubmission.getStatus()))
										.collect(Collectors.toList());




								String operationIdGenerated=null;
								String userId = eachCourse.getFacultyID();
								User user = userService.findUserById(userId);
								if (userId==null || userId.isEmpty() || userService.findUserById(userId) == null) {
									logger.info("user ID Not Found :" + userId);
									continue;
								}
								Map<String, String> comparedSubmissions = new HashMap<String,String>();
								boolean shouldSendEmail = false;

								if (allActiveSubmissions!=null && !allActiveSubmissions.isEmpty()) {
									try {
										List<StudentCompareResult> lspr = new ArrayList<>();
										
										

										for (int i = 0; i < allActiveSubmissions.size();i++) {
											Submission submission1 = allActiveSubmissions.get(i);

										
												for (int j = 0; j < allSubmissions.size();j++) {					
													Submission submission2 = allSubmissions.get(j);
													if (!submission1.get_id().equals(submission2.get_id()) 
															&& (comparedSubmissions.get(submission1.get_id()+submission2.get_id())==null && comparedSubmissions.get(submission2.get_id()+submission1.get_id())==null)) {						
														StudentCompareResult scr = 
																fileService.compareTwoSubmissionFolders(submission1.getUrl(),
																		submission2.getUrl(), userId, submission1.getStudentId(), 
																		submission2.getStudentId(),assignment.getSubmissionType() );
														if (scr!=null) {

															
															// Sending Email in case of plagiarism
															if (scr.getPlagiarismExists()!=null && Constants.YES.equals(scr.getPlagiarismExists())) {
																shouldSendEmail = true;
															}
															lspr.add(scr);	
															comparedSubmissions.put(submission1.get_id()+submission2.get_id(), Constants.COMPARED);
															
														}
													}
												}
											

										}
										
										for (Submission eachSub: allActiveSubmissions) {
											eachSub.setStatus(Constants.COMPARED);
											submissionService.updateSubmission(eachSub);
										}
										

										Operation op = new Operation();
										op.setDate(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
										op.setOperationType("Submission Comparison");		
										op.setStudentResult(lspr);
										op.setUserId(userId);
										op.setInitiatedBy("System");

										operationIdGenerated = reportService.saveOperation(op);

										// We Also need to send email to professor if something worth checking is found. based on some threshold value

										if (operationIdGenerated == null) {
											throw new Exception("Error while save the operation");
										}		
										
										if (shouldSendEmail) {
											sendPlagiarismEmail(eachCourse.getCourseName(), assignment.getName() , user.getEmailAddress());
										}


									}catch (Exception e) {
										logger.log(Level.SEVERE, "Error Occurred during CRON JOB Execution ---", e);
									}
								}
								


							}

						}


					}
				}
			}


		}

		logger.info(String.format("Scheduled Comparison End at  {%s}", dateFormat.format(new Date())));
	}
	
	private void sendPlagiarismEmail(String courseName, String assignmentName, String userMailAddress) {

	
			// Send Email to registered user
			
			String message = "Hi, " +"\n\n\n"+
							"A possible case of plagiarism has been found in a submission for HomeWork Name: " + assignmentName +" and Course Name: " + courseName+
							
					"\n\nPlease login to the portal and check the report on the History tab. \n\n\nThanks,\nSupport Team";
			String to = userMailAddress;
			String from = "asim.khan17790@gmail.com";
			String subject = "DO NOT REPLY - Possible Plagiarism Detected for a Homework in Course:>"+ courseName;
			
			EMail mail = new EMail();
			mail.setEmailMessage(message);
			mail.setEmailSubject(subject);
			mail.setTo(to);
			mail.setFrom(from);
			
			String emailSentResult = mailService.sendEmail(mail);
			if (emailSentResult!=null && emailSentResult.equals(Constants.SENT)) {
				logger.info("Plagiarism detection mail SENT to  " + userMailAddress);	
			}else {
				logger.info("Plagiarism detection Mail could not be sent to userID: " + userMailAddress);
			}
		}
}

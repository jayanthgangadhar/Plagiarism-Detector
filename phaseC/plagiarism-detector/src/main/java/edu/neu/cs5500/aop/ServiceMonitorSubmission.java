/**
 * 
 */
package edu.neu.cs5500.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.neu.cs5500.dao.user.UserDao;
import edu.neu.cs5500.domainObjects.EMail;
import edu.neu.cs5500.domainObjects.Submission;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.email.MailService;

/**
 * @author sanketmathur
 *
 */
@Aspect
@Component
public class ServiceMonitorSubmission {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	private MailService mailService;
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.submission.*.createSubmission(*,*,*))", returning="result")
	public void monitorCreateSubmission(JoinPoint jp, Submission result) {		
		if(result != null) {
			logger.info("Submission created successfully with id " + result.get_id());
			// Send Email to registered user

			String message = "Hi " + result.getStudentName() +"\n\n\n"+
							"Your submission with ID: "+ result.get_id() + "has been successfully submitted with our system.\n\n" +
					"Thanks,\nSupport Team";
			User u = userDao.findUserById(result.getStudentId());
			String to = u.getEmailAddress();
			String from = "asim.khan17790@gmail.com";
			String subject = "DO NOT REPLY - USER Submission Notification";
			
			EMail mail = new EMail();
			mail.setEmailMessage(message);
			mail.setEmailSubject(subject);
			mail.setTo(to);
			mail.setFrom(from);
			
			String emailSentResult = mailService.sendEmail(mail);
			if (emailSentResult!=null && emailSentResult.equals("SENT")) {
				logger.info("User Submission Mail sent successfully for email " + u.getEmailAddress());	
			}else {
				logger.info("User submission Mail could not be sent to user: " + u.getEmailAddress());
			}
		}
		else {
			logger.info("Invalid semester creation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.submission.*.updateSubmission(*))", returning="result")
	public void monitorUpdateSubmission(JoinPoint jp, Submission result) {		
		if(result != null) {
			logger.info("Submission updated successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid submission updation attempt ");
		}
	}
}

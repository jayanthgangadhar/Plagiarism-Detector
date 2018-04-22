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

import edu.neu.cs5500.domainObjects.EMail;
import edu.neu.cs5500.domainObjects.User;
import edu.neu.cs5500.services.email.MailService;

/**
 * @author sanketmathur
 *
 */

@Aspect
@Component
public class ServiceMonitorUser {

	@Autowired
	private MailService mailService;

	private Logger logger = Logger.getLogger(getClass().getName());

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.createUser(*))", returning="result")
	public void monitorCreateUserSuccess(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User regitered successfully with email " + result.getEmailAddress());


			// Send Email to registered user
			sendEmail(result);


		}
		else {
			logger.info("User Registeration failed...");
		}
	}

	private void sendEmail(User result) {
		String message = "Hi " + result.getFirstName() +",\n\n\n"+
				"Your account with used ID: "+ result.getEmailAddress() + " has been registered with our system and request is sent to the System administrator for approval.\n\n"
				+ "Once approved, you can login to the system with the password you have created.\n\n\n\n"+

		"Thanks,\nSupport Team";
		String to = result.getEmailAddress();
		String from = "asim.khan17790@gmail.com";
		String subject = "DO NOT REPLY - USER Registeration Notification";

		EMail mail = new EMail();
		mail.setEmailMessage(message);
		mail.setEmailSubject(subject);
		mail.setTo(to);
		mail.setFrom(from);

		String emailSentResult = mailService.sendEmail(mail);
		if (emailSentResult!=null && emailSentResult.equals("SENT")) {
			logger.info("User registeration Mail sent successfully for email " + result.getEmailAddress());	
		}else {
			logger.info("User registeration Mail could not be sent to userID: " + result.getEmailAddress());
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.getUserByCredential(*,*))", returning="result")
	public void monitorLoginUser(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User login successfully with email " + result.getEmailAddress());
		}
		else {
			logger.info("Invalid login attempt ");
		}
	}


	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.approveUser(*))", returning="result")
	public void monitorUserApproval(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User with email:" + result.getEmailAddress()+" has been aproved");

			// Send Email to registered user

			String message = "Hi " + result.getFirstName() +"\n\n\n"+
					"Your account with used ID: "+ result.getEmailAddress() + "has been approved.\n\n\n"+

					"Thanks,\nSupport Team";
			String to = result.getEmailAddress();
			String from = "asim.khan17790@gmail.com";
			String subject = "DO NOT REPLY - USER Approval Notification";						
			EMail mail = new EMail();
			mail.setEmailMessage(message);
			mail.setEmailSubject(subject);
			mail.setTo(to);
			mail.setFrom(from);

			String emailSentResult = mailService.sendEmail(mail);
			if (emailSentResult!=null && emailSentResult.equals("SENT")) {
				logger.info("User Approval Mail sent successfully for email " + result.getEmailAddress());	
			}else {
				logger.info("User Approval Mail could not be sent to userID: " + result.getEmailAddress());
			}
		}
		else {
			logger.info("Error occurred with user approval for user:");
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.updateUser(*))", returning="result")
	public void monitorUpdateUser(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User update successfully with email " + result.getEmailAddress());
		}
		else {
			logger.info("Invalid login attempt ");
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.deleteUser(*))", returning="result")
	public void monitorDeleteUser(JoinPoint jp, Boolean result) {
		if(result != null) {
			logger.info("User deleted successfully");
		}
		else {
			logger.info("Invalid login attempt ");
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.rejectUser(*))", returning="result")
	public void monitorUserReject(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User with email:" + result.getEmailAddress()+" has been rejected");

			// Send Email to registered user

			String message = "Hi " + result.getFirstName() +"\n\n\n"+
					"Your account with used ID: "+ result.getEmailAddress() + "has been rejected by admin.\n\n\n"+

					"Thanks,\nSupport Team";
			String to = result.getEmailAddress();
			String from = "asim.khan17790@gmail.com";
			String subject = "DO NOT REPLY - USER Rejection Notification";						
			EMail mail = new EMail();
			mail.setEmailMessage(message);
			mail.setEmailSubject(subject);
			mail.setTo(to);
			mail.setFrom(from);

			String emailSentResult = mailService.sendEmail(mail);
			if (emailSentResult!=null && emailSentResult.equals("SENT")) {
				logger.info("User Rejected Mail sent successfully for email " + result.getEmailAddress());	
			}else {
				logger.info("User Rejection Mail could not be sent to userID: " + result.getEmailAddress());
			}
		}
		else {
			logger.info("Error occurred with user rejection for user:");
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.enrollInCourse(*,*))", returning="result")
	public void monitorEnrollInCourseUser(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User with email " + result.getEmailAddress() + "successfully enrolled in the course ");
		}
		else {
			logger.info("Invalid enrollment attempt ");
		}
	}

	@AfterReturning(value = "execution(* edu.neu.cs5500.services.user.*.dropCourse(*,*))", returning="result")
	public void monitorDropInCourseUser(JoinPoint jp, User result) {
		if(result != null) {
			logger.info("User with email " + result.getEmailAddress() + "successfully dropped in the course ");
		}
		else {
			logger.info("Invalid course drop attempt ");
		}
	}
}

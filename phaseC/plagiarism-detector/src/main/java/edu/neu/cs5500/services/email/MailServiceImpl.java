package edu.neu.cs5500.services.email;


import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;

import edu.neu.cs5500.domainObjects.EMail;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.GmailModule;


/**
 * @author Asim
 * 
 * Service to implement the GMAIL API
 *
 */
@Service("mailService")
public class MailServiceImpl implements MailService {

	
	// Logger
	private static Logger logger = Logger.getLogger(MailServiceImpl.class.getName());
    /* (non-Javadoc)
     * @see edu.neu.cs5500.services.email.MailService#sendEmail(edu.neu.cs5500.domainObjects.EMail)
     */
    @Override
    public String sendEmail(EMail mail) {
    	logger.info("Sending Email start...");
        
        try {
        	 Gmail service = GmailModule.getGmailService();

             // Print the labels in the user's account.
             String user = "me";
             ListLabelsResponse listResponse =
                     service.users().labels().list(user).execute();
             List<Label> labels = listResponse.getLabels();
             if (labels.size() == 0) {
            	 logger.info("No labels found.");
             } else {
            	 logger.info("Labels:");
                 for (Label label : labels) {
                     String msg = "-" + label.getName() +"\\n";
                     logger.info(msg);
                 }
             }
             MimeMessage m = null;
             try {
                 m = GmailModule.createEmail(mail.getTo(), mail.getFrom(),
                		 	mail.getEmailSubject(), mail.getEmailMessage(),mail.getCc(),null);
             } catch (MessagingException e) {
            	 logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
             }
             try {
             	GmailModule.sendMessage(service, "me", m);
             } catch (MessagingException e) {
            	 logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
            	 return null;
                
             }
        }
       
        catch (IOException e) {
        	logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
            return null;
        }


        return "SENT";
    }
}

package edu.neu.cs5500.domainObjects;

import java.io.File;
import java.io.Serializable;

/**
 * @author Asim
 * Email Object which contains the email related fields
 */
/**
 * @author Asim
 * Entity used to represent Email Objects
 *
 */
public class EMail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String to;
	private String from;
    private File attachment;
    private String emailType;
    private String emailMessage;
    private String emailSubject;
    private String cc;
    
	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
   
	
	/**
	 * 
	 * @return the attachments for this email
	 */
	public File getAttachment() {
		return attachment;
	}
	
	
	/**
	 * set the given file as attachment with this email
	 * @param attachment
	 */
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	
	/**
	 * @return type of this email
	 */
	public String getEmailType() {
		return emailType;
	}
	
	/**
	 * 
	 * @return return this email
	 */
	public String getEmailMessage() {
		return emailMessage;
	}
	
	/**
	 * set the type of the emial
	 * @param emailType
	 */
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	
	/**
	 * Set the emial message
	 * @param emailMessage
	 */
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}

	public String getEmailSubject() {
		return emailSubject;
	}

	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}



	public String getTo() {
		return to;
	}



	public void setTo(String to) {
		this.to = to;
	}



	public String getFrom() {
		return from;
	}



	public void setFrom(String from) {
		this.from = from;
	}



	public String getCc() {
		return cc;
	}



	public void setCc(String cc) {
		this.cc = cc;
	}
	
	
	
	
}

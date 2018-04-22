package edu.neu.model;

import java.io.File;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Asim
 * Email Object which contains the email related fields
 */
public class EMail implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
    private File attachment;
    private String emailType;
    private String emailMessage;
    
	
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User getUser() {
		return user;
	}
	public File getAttachment() {
		return attachment;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}
	public String getEmailType() {
		return emailType;
	}
	public String getEmailMessage() {
		return emailMessage;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public void setEmailMessage(String emailMessage) {
		this.emailMessage = emailMessage;
	}
	
    
	
    
    

}

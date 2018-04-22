package edu.neu.service;

import java.util.List;

import edu.neu.model.EMail;

public interface MailService {

    /**
     * @param mail
     * @return
     * 
     * send a single Email to the input user email
     */
    public String sendEmail(EMail mail);
    
    /**
     * @param mails
     * @return
     * 
     * send multiple emails
     */
    public String sendMultipleEmail(List<EMail> mails);
}

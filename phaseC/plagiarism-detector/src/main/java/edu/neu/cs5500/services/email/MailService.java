package edu.neu.cs5500.services.email;

import edu.neu.cs5500.domainObjects.EMail;

public interface MailService {

    public String sendEmail(EMail mail);
}

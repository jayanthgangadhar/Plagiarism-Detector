package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import edu.neu.cs5500.domainObjects.Report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * Class to define all the attributes of a user
 */
@Document(collection="userCollection")
public class User implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private Report report;
    private String role;
    private String status;
    private String approvedBy;
    private Date approvedOn;
    private List<String> courseEnrolled;
    private Date userCreationDate;
    private List<String> operations;
    private Double threshold;
    

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public List<String> getOperations() {
		return operations;
	}

	public void setOperations(List<String> operations) {
		this.operations = operations;
	}

	/**
     * @return role associated with this User
     */
	public String getRole() {
		return role;
	}

	/**
	 * set the given role for this user
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return id associated with this User
	 */
	public String getId() {
        return id;
    }

	/**
	 * set the given id for this user
	 * @param id
	 */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return firstName associated with this User
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return lastName associated with this User
     */
    public String getLastName() {
		return lastName;
	}

    /**
     * set the given lastName for this user
     * @param lastName
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return email associated with this User
	 */
	public String getEmailAddress() {
        return emailAddress;
    }

	/**
	 * set the given email for this user
	 * @param emailAddress
	 */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return password associated with this User
     */
    public String getPassword() {
        return password;
    }

    /**
     * set the given password for this user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the approvedOn
	 */
	public Date getApprovedOn() {
		return approvedOn;
	}

	/**
	 * @param approvedOn the approvedOn to set
	 */
	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}
	
	/**
	 * @return the courseEnrolled
	 */
	public List<String> getCourseEnrolled() {
		return courseEnrolled;
	}
	
	/**
	 * @param courseEnrolled the courseEnrolled to set
	 */
	public void setCourseEnrolled(List<String> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}
	
	/**
	 * @return the userCreationDate
	 */
	public Date getUserCreationDate() {
		return userCreationDate;
	}

	/**
	 * @param userCreationDate the userCreationDate to set
	 */
	public void setUserCreationDate(Date userCreationDate) {
		this.userCreationDate = userCreationDate;
	}

	/**
	 * @return the threshold
	 */
	public Double getThreshold() {
		return threshold;
	}

	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(Double threshold) {
		this.threshold = threshold;
	}

	/**
     * @return a string representation of email lastname firstname
     */
    @Override
    public String toString() {
        return String.format(
                "User[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}


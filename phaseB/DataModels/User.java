package edu.neu.model;

/**
 *
 * Class to define all the attributes of a user
 */
public class User {

    //id is the primary key which is used for identifying the column
    
    private int id;
    private String firstName;
    private String LastName;
    private String emailAddress;
    private String password;
    private Report report;
    private String role;
    
    
    
    

    public Report getReport() {
		return report;
	}

	public String getRole() {
		return role;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


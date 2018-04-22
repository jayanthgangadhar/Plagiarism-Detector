package edu.neu.model;

/**
 * @author Asim
 * 
 * Class to define all the attributes of a Student
 *
 */
public class StudentDetail {

	private String lastName;
	private String firstname;
	private String email;
	private String studentId;
	
	public String getLastName() {
		return lastName;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getEmail() {
		return email;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	
	
	
	
	
}

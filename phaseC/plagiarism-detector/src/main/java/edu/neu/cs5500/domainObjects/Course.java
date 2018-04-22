/**
 * class to define all the attributes of the course
 */

package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sanketmathur
 * Entity used to represent Course Objects
 *
 */

@Document(collection="courseCollection")
public class Course implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * _id
	 * courseName:
	 * facultyID: faculty user in-charge of this course
	 * status: status
	 * studentsEnrolled: list of all the students enrolled in this course
	 */
	
	@Id
	private String _id;
	private String courseName;
	private String facultyID;
	private String status;
	private String semesterId;
	private List<String> studentsEnrolled;
	
	
	/**
	 * @return the 
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * @param _id the id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/**
	 * @return the facultyID
	 */
	public String getFacultyID() {
		return facultyID;
	}
	
	/**
	 * @param facultyID the facultyID to set
	 */
	public void setFacultyID(String facultyID) {
		this.facultyID = facultyID;
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
	 * @return the semesterId
	 */
	public String getSemesterId() {
		return semesterId;
	}

	/**
	 * @param semesterId the semesterId to set
	 */
	public void setSemesterId(String semesterId) {
		this.semesterId = semesterId;
	}

	/**
	 * @return the studentsEnrolled
	 */
	public List<String> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	/**
	 * @param studentsEnrolled the studentsEnrolled to set
	 */
	public void setStudentsEnrolled(List<String> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}	
}

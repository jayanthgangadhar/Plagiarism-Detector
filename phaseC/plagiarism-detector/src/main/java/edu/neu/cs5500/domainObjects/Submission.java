package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Class to define all the attributes of a Submission
 * @author JayanthGangadhar
 *
 */

@Document(collection="submissionCollection")
public class Submission implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String _id;
	private String name;
	private String submissionType;
	private String studentId;
	private String courseId;
	private String homeworkId;
	private List<FileTuple> url;
	private String status;
	private String studentName;
	private String submissionDate;
	
	/**
	 * To return the submission Id
	 * @return submissionId
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * To set the submissionId
	 * @param id represents id of submission
	 */
	public void set_id(String id) {
		this._id = id;
	}
	
	/**
	 * To get the type of submission
	 * @return submission type
	 */
	public String getSubmissionType() {
		return submissionType;
	}
	
	/**
	 * To set the type of submission
	 * @param submissionType represents type of submission
	 */
	public void setSubmissionType(String submissionType) {
		this.submissionType = submissionType;
	}
	
	/**
	 * To get id of the student who submitted the assignment
	 * @return Student Id
	 */
	public String getStudentId() {
		return studentId;
	}
	
	/**
	 * To set id of the student who submitted the assignment
	 * @param studentId represents the id of student
 	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * To get the id of the course to which the submission belongs
	 * @return courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	
	/**
	 * To set the id of the course to which the submission belongs
	 * @param courseId represents the id of course
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	/**
	 * To get the id of the homework to which the submission belongs
	 * @return homeworkId
	 */
	public String getHomeworkId() {
		return homeworkId;
	}
	
	/**
	 * To set the id of the homework to which the submission belongs
	 * @param homeworkId repesents id of homework
	 */
	public void setHomeworkId(String homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	/**
	 * To get the url of the submission
	 * @return url
	 */
	public List<FileTuple> getUrl() {
		return url;
	}
	
	/**
	 * To set the url of the submission
	 * @param url
	 */
	public void setUrl(List<FileTuple> url) {
		this.url = url;
	}
	
	/**
	 * To get the status check of submission
	 * @return status of submission
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * To set the status check of submission
	 * @param status of submission
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * to get the serial version UID
	 * @return UID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the submissionDate
	 */
	public String getSubmissionDate() {
		return submissionDate;
	}

	/**
	 * @param submissionDate the submissionDate to set
	 */
	public void setSubmissionDate(String submissionDate) {
		this.submissionDate = submissionDate;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 
 */
package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sanketmathur
 * 
 * Entity used to represent Assignment objects
 *
 */
@Document(collection = "assignmentCollection")
public class Assignment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * _id: id of the homework
	 * name: name of the homework
	 * deadline: deadline date for the homework
	 * documentUrl: string s3 bucket link
	 * relatedCourseId: related course id
	 * status: status
	 */
	@Id
	private String _id;
	private String name;
	private String deadline;
	private String submissionType;
	private String documentUrl;
	private String relatedCourseId;
	private String status;
	private Date creationDate;
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
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
	/**
	 * @return the deadline
	 */
	public String getDeadline() {
		return deadline;
	}
	/**
	 * @param deadline the deadline to set
	 */
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	/**
	 * @return the documentUrl
	 */
	public String getDocumentUrl() {
		return documentUrl;
	}
	/**
	 * @param documentUrl the documentUrl to set
	 */
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	/**
	 * @return the relatedCourseId
	 */
	public String getRelatedCourseId() {
		return relatedCourseId;
	}
	/**
	 * @param relatedCourseId the relatedCourseId to set
	 */
	public void setRelatedCourseId(String relatedCourseId) {
		this.relatedCourseId = relatedCourseId;
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the assignmentType
	 */
	public String getSubmissionType() {
		return submissionType;
	}
	/**
	 * @param assignmentType the assignmentType to set
	 */
	public void setSubmissionType(String submissionType) {
		this.submissionType = submissionType;
	}
}

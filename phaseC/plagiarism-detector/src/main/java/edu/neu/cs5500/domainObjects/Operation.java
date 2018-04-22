package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Asim
 *
 * Class to define the activity performed by the used
 * this classwill be used to generate the history of the user
 */

@Document(collection="operations")
public class Operation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	@Id
	private String id;
	
	@Transient
	private List<StudentCompareResult> studentResult;

	private String date;

	private String operationType;
	private String userId;
	private String initiatedBy;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInitiatedBy() {
		return initiatedBy;
	}
	public void setInitiatedBy(String initiatedBy) {
		this.initiatedBy = initiatedBy;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<StudentCompareResult> getStudentResult() {
		return studentResult;
	}
	public void setStudentResult(List<StudentCompareResult> studentResult) {
		this.studentResult = studentResult;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
}

package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="studentCompareResults")
public class StudentCompareResult implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String student1Name;
	private String student2Name;
	private String student1Id;
	private String student2Id;
	private String parentOperationId;
	private String plagiarismExists;
	private String maxSimilarityInAnyTwoFiles;
	
	
	
	
	// FILE | FOLDER | ZIP | TEXT
	private String comparisonType;
	
	
	// List comparisonType = FILE and List size = 1 means --> FILE/TEXT compare
	// else FOLDER/ZIP COMPARE 
	
	@Transient
	private List<Report> reports;

	
	public String getParentOperationId() {
		return parentOperationId;
	}


	public void setParentOperationId(String parentOperationId) {
		this.parentOperationId = parentOperationId;
	}


	public String getStudent1Name() {
		return student1Name;
	}


	public void setStudent1Name(String student1Name) {
		this.student1Name = student1Name;
	}


	public String getStudent2Name() {
		return student2Name;
	}


	public void setStudent2Name(String student2Name) {
		this.student2Name = student2Name;
	}


	public String getStudent1Id() {
		return student1Id;
	}


	public void setStudent1Id(String student1Id) {
		this.student1Id = student1Id;
	}


	public String getStudent2Id() {
		return student2Id;
	}


	public void setStudent2Id(String student2Id) {
		this.student2Id = student2Id;
	}


	public List<Report> getReports() {
		return reports;
	}


	public void setReports(List<Report> reports) {
		this.reports = reports;
	}


	public String getComparisonType() {
		return comparisonType;
	}


	public void setComparisonType(String comparisonType) {
		this.comparisonType = comparisonType;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPlagiarismExists() {
		return plagiarismExists;
	}


	public void setPlagiarismExists(String plagiarismExists) {
		this.plagiarismExists = plagiarismExists;
	}


	public String getMaxSimilarityInAnyTwoFiles() {
		return maxSimilarityInAnyTwoFiles;
	}


	public void setMaxSimilarityInAnyTwoFiles(String maxSimilarityInAnyTwoFiles) {
		this.maxSimilarityInAnyTwoFiles = maxSimilarityInAnyTwoFiles;
	}
	
	
	
}

package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Asim
 *
 * The final report generated after the comparison analysis is done
 */
@Document(collection="comparisonreports")
public class Report implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private List<SimilarityMetric> metrics;
	private String file1Name;
	private String file2Name;	
	private String file1Path;
	private String file2Path;
	@Transient
	private String file1Data;
	@Transient
	private String file2Data;
	private String parentStudentsCompareId;
	private Double averageScore;
	private List<Range> similarLines;
	private Double thresholdUsed;
	private String plagiarismExists;
	
	
	public String getParentStudentsCompareId() {
		return parentStudentsCompareId;
	}

	public void setParentStudentsCompareId(String parentStudentsCompareId) {
		this.parentStudentsCompareId = parentStudentsCompareId;
	}

	public List<Range> getSimilarLines() {
		return similarLines;
	}
	
	public void setSimilarLines(List<Range> similarLines) {
		this.similarLines = similarLines;
	}
	
	public Report() {}
	
	public Report(List<SimilarityMetric> metrics, String file1Name, String file2Name, Double averageScore,
			List<Range> similarLines) {
		super();
		
		this.metrics = metrics;
		this.file1Name = file1Name;
		this.file2Name = file2Name;
		this.averageScore = averageScore;
		this.similarLines = similarLines;
	}


	public String toString() {
		return averageScore+";"+metrics;
	}

	public List<SimilarityMetric> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<SimilarityMetric> metrics) {
		this.metrics = metrics;
	}
	public String getFile1Name() {
		return file1Name;
	}
	public void setFile1Name(String file1Name) {
		this.file1Name = file1Name;
	}
	public String getFile2Name() {
		return file2Name;
	}
	public void setFile2Name(String file2Name) {
		this.file2Name = file2Name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}
	public String getFile1Path() {
		return file1Path;
	}
	public void setFile1Path(String file1Path) {
		this.file1Path = file1Path;
	}
	public String getFile2Path() {
		return file2Path;
	}
	public void setFile2Path(String file2Path) {
		this.file2Path = file2Path;
	}
	public String getFile1Data() {
		return file1Data;
	}
	public void setFile1Data(String file1Data) {
		this.file1Data = file1Data;
	}
	public String getFile2Data() {
		return file2Data;
	}
	public void setFile2Data(String file2Data) {
		this.file2Data = file2Data;
	}

	public Double getThresholdUsed() {
		return thresholdUsed;
	}

	public void setThresholdUsed(Double thresholdUsed) {
		this.thresholdUsed = thresholdUsed;
	}

	public String getPlagiarismExists() {
		return plagiarismExists;
	}

	public void setPlagiarismExists(String plagiarismExists) {
		this.plagiarismExists = plagiarismExists;
	}
	
	
}

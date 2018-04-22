package edu.neu.cs5500.domainObjects;

import java.io.Serializable;

/**
 * @author Asim
 *
 *Data structure that will hold all the comparison results generated between two files
 */
public class SimilarityMetric implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1945028570832546898L;
	// the metric names will be decided later
	
	private String metricType;
	private Double score;
	public SimilarityMetric() {}
	public String getMetricType() {
		return metricType;
	}
	
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public SimilarityMetric(String metricType, Double score) {
		super();
		this.metricType = metricType;
		this.score = score;
	} 
	public String toString() {
		return "Metric: " + metricType + "; Score: "+score;
	}
	
}

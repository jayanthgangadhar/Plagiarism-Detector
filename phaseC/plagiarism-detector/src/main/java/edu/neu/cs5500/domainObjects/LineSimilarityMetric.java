package edu.neu.cs5500.domainObjects;
/**
 * LineSimilarityMetric is a class to encapsulate the length of files and the number of similar lines
 * @author JayanthGangadhar
 *
 */
public class LineSimilarityMetric {
	//to store length of file
	private int length;
	//to store length of similar lines of file
	private int similarLength;
	//constructor
	public LineSimilarityMetric(int length, int similarLength) {
		super();
		this.length = length;
		this.similarLength = similarLength;
	}
	
	//getters and setters
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getSimilarLength() {
		return similarLength;
	}
	public void setSimilarLength(int similarLength) {
		this.similarLength = similarLength;
	}
	
	
}

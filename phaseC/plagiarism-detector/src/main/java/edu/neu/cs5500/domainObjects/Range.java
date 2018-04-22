package edu.neu.cs5500.domainObjects;

/**
 * Range class represents range of similar/plagiarized lines  
 * @author JayanthGangadhar
 *
 */
public class Range {
	/**
	 * from1 represents the source line number of the block of code that is similar of file1
	 */
	private Integer from1;
	/**
	 * to1 represents the source line number of the block of code that is similar of file1
	 */
	private Integer to1;
	/**
	 * from2 represents the source line number of the block of code that is similar of file2
	 */
	private Integer from2;
	/**
	 * to2 represents the destination line number of the block of code that is similar of file2
	 */
	private Integer to2;
	/**
	 * Constructor
	 * @param from1 represents the source line number of the block of code that is similar of file1
	 * @param to1 represents the source line number of the block of code that is similar of file1
	 * @param from2 represents the source line number of the block of code that is similar of file2
	 * @param to2 represents the destination line number of the block of code that is similar of file2
	 */
	public Range(Integer from1, Integer to1, Integer from2, Integer to2) {
		super();
		this.from1 = from1;
		this.to1 = to1;
		this.from2 = from2;
		this.to2 = to2;
	}
	
	//Getters and Setters
	public Integer getFrom1() {
		return from1;
	}
	public void setFrom1(Integer from1) {
		this.from1 = from1;
	}
	public Integer getTo1() {
		return to1;
	}
	public void setTo1(Integer to1) {
		this.to1 = to1;
	}
	public Integer getFrom2() {
		return from2;
	}
	public void setFrom2(Integer from2) {
		this.from2 = from2;
	}
	public Integer getTo2() {
		return to2;
	}
	public void setTo2(Integer to2) {
		this.to2 = to2;
	}
}

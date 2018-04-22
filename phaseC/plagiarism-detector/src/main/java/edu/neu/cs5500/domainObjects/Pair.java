package edu.neu.cs5500.domainObjects;

/**
 * Pair Class used to store two integers 
 * @author JayanthGangadhar
 *
 */
public class Pair {
	//number1 and number2 represents the two numbers
	Integer number1;
	Integer number2;
	//constructor
	public Pair() {
		super();
	}
	
	public Pair(Integer number1, Integer number2) {
		super();
		this.number1 = number1;
		this.number2 = number2;
	}
	//getters and setters
	public Integer getNumber1() {
		return number1;
	}
	public void setNumber1(Integer number1) {
		this.number1 = number1;
	}
	public Integer getNumber2() {
		return number2;
	}
	public void setNumber2(Integer number2) {
		this.number2 = number2;
	}
	

}

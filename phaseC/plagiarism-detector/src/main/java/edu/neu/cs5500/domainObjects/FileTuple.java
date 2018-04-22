package edu.neu.cs5500.domainObjects;

import java.io.Serializable;

/**
 * @author Asim
 * Entity used to hold file related data
 *
 */
public class FileTuple implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String fileText1;
	String fileText2;
	
	
	public String getFileText1() {
		return fileText1;
	}
	public void setFileText1(String fileText1) {
		this.fileText1 = fileText1;
	}
	public String getFileText2() {
		return fileText2;
	}
	public void setFileText2(String fileText2) {
		this.fileText2 = fileText2;
	}
	
	

}

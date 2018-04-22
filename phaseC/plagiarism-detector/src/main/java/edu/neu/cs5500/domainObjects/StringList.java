package edu.neu.cs5500.domainObjects;

import java.io.Serializable;
import java.util.List;

public class StringList implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> inputList;

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}
}

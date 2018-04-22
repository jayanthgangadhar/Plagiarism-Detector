package edu.neu.service;

import java.io.File;

import edu.neu.model.SimilarityMetric;

public interface DetectorService {
	
	
	/**
	 * @param folder1
	 * @param folder2
	 * @return
	 * 
	 * method to compare the two uploaded folders
	 */
	public SimilarityMetric compareFolders(byte[] folder1,byte[] folder2);
	/**
	 * @param folder1
	 * @param folder2
	 * @return
	 * 
	 * method to compare the two uploaded files
	 */
	public SimilarityMetric compareTwoFiles(byte[] folder1,byte[] folder2);
	

}

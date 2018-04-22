package edu.neu.service;

import java.io.File;

public interface FileService {
	
	/**
	 * @param csvFile
	 * @return
	 * 
	 * used to upload the Student details for the students of the class
	 */
	public String uploadCSV(File csvFile);
	/**
	 * @param folder
	 * @return
	 * upload folder in cache
	 */
	public String uploadFolder(File folder);
	/**
	 * @param file
	 * @return
	 * upload file in cache
	 */
	public String uploadFile(File file);	

}

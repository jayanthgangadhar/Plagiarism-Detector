package edu.neu.cs5500.services.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.neu.cs5500.domainObjects.FileTuple;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.StudentCompareResult;

public interface FileService {
	
	public Report compareTwoFiles(File file1, File file2, Double threshold) throws FileNotFoundException, IOException;	

	/**
	 * @param csvFile
	 * @return
	 * 
	 * used to upload the Student details for the students of the class
	 */
	
	
	/**
	 * @param file1
	 * @param file2
	 * @return
	 * 
	 * returns result of comparison of two folders
	 */
	public String compareTwoFolders(MultipartFile[] fileList1, MultipartFile[] fileList2, String userID, String student1Id, String student2Id) throws FileNotFoundException, IOException;
	
	/**
	 * @param file1Text
	 * @param file2Text
	 * @return
	 * 
	 * returns result of comparison of two texts
	 */
	public Report compareTwoTexts(String file1Text, String file2Text, String userID, String student1Id, String student2Id) throws FileNotFoundException, IOException;
	
	
	
	
	public StudentCompareResult compareTwoSubmissionFolders(List<FileTuple> fileList1, List<FileTuple> fileList2, String userID, String student1Id,
			String student2Id, String submissionType) throws FileNotFoundException, IOException;

}

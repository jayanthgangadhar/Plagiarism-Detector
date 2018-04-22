package edu.neu.service;


import java.util.List;

import edu.neu.model.Report;

public interface ReportService {

	/**
	 * @param reportId
	 * @return
	 * generates the report for the comparison operation
	 */
	public Report generateReport(String reportId);
	/**
	 * @param reportId
	 * @return
	 * 
	 * download the report in the form of excel/pdf
	 */
	public Report downloadReport(String reportId);
	/**
	 * @param reportId
	 * @return
	 * get the details toof the report and response is sent to the front end for the display 
	 */
	public Report viewReport(String reportId);
	/**
	 * @param reportId
	 * @param emailId
	 * @return
	 * 
	 * Send an email to the input email id with the generated report as the atatchement
	 */
	public Report emailReport(String reportId,String emailId);
	/**
	 * @param email
	 * @return
	 * 
	 * Get the list of all reports of the selected User
	 */
	public List<Report> getAllReportsOfUser(String email);
	
	
}

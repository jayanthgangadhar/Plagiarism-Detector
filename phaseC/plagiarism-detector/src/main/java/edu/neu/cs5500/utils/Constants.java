package edu.neu.cs5500.utils;

/**
 * @author Asim
 * 
 * Global Constans
 *
 */
public class Constants {

	private Constants() {}



	// Status Codes
	public static final String SUCCESS = "200";
	public static final String FAILURE = "500";
	public static final String BAD_REQUEST = "400";
	public static final Double PLAG_THRESHOLD = 40.0;
	public static final String ERROR_CODE_NOTFOUND = "404";
	
	// Messages
	public static final String ERROR_OCCURRED = "Error Occurred!";
	public static final String USER_NOT_FOUND = "User Not Found";
	public static final String NOT_FOUND = "Not Found";
	public static final String STUDENT_NOT_FOUND = "Student Not Found";
	public static final String COURSE_NOT_FOUND = "Course Not Found";
	public static final String SEMESTER_NOT_FOUND = "Semester Not Found";
	public static final String ASSIGNMENT_NOT_FOUND = "Assignment Not Found";
	public static final String SUBMISSION_NOT_FOUND = "Submission Not Found";
	public static final String ACTIVE = "ACTIVE";
	public static final String APPROVAL = "APPROVAL";
	public static final String REJECTED = "REJECTED";
	public static final String EMPTY_STRING = "";
	public static final String S3URL = "https://s3.amazonaws.com/msd-team-206/";
	public static final String ASSIGNMENT_DOCUMENT_NOT_UPDATED = "Assignment document not updated";


	// security constants
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/register";
	public static final String YES = "YES";
	public static final String COMPARED = "COMPARED";
	public static final String SENT = "SENT";
	public static final String NEW = "NEW";
	
	
}

/**
 * 
 */
package edu.neu.cs5500.domainObjects;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author sanketmathur
 * 
 * Class to define a semester
 *
 */

@Document(collection="semesterCollection")
public class Semester {

	@Id
	private String _id;
	private String name;
	private String status;
	
	// no need to maintain this list as we have function
	// findCoursesInThisSemesters method in the Course
	private List<Course> courses;
	
	/**
	 * @return the id
	 */
	public String get_id() {
		return _id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the courseList
	 */
	public List<Course> getCourses() {
		return courses;
	}
	
	/**
	 * @param courseList the courseList to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}

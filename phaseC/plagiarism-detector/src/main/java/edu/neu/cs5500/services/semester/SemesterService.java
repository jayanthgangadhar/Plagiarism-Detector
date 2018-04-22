/**
 * 
 */
package edu.neu.cs5500.services.semester;

import java.util.List;

import edu.neu.cs5500.domainObjects.Semester;

/**
 * @author sanketmathur
 *
 */
public interface SemesterService {

	/**
	 * 
	 * @param sem
	 * @return the semester created
	 */
	public Semester createSemester(Semester sem);
	
	/**
	 * 
	 * @param sem
	 * @return true iff the semester is deleted from the database
	 */
	public boolean deleteSemester(String id);
	
	/**
	 * 
	 * @param sem
	 * @return the semester updated
	 */
	public Semester updateSemester(Semester sem);
	
	/**
	 * 
	 * @return list of all the semesters
	 */
	public List<Semester> findAllSemesters();
	
	/**
	 * 
	 * @param id
	 * @return the semester associated with the given id 
	 */
	public Semester findSemesterById(String id);
	
	/**
	 * 
	 * @return list of all the active semesters
	 */
	public List<Semester> findAllActiveSemesters();
	
//	/**
//	 * 
//	 * @param sem
//	 * @return list of courses in the given semester
//	 */
//	List<Course> findAllCoursesInThisSemester(String id);	
}

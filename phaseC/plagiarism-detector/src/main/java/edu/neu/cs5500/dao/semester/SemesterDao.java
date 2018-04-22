/**
 * 
 */
package edu.neu.cs5500.dao.semester;

import edu.neu.cs5500.domainObjects.Semester;

/**
 * @author sanketmathur
 *
 */
public interface SemesterDao {

	/**
	 * 
	 * @param sem
	 * @return the semester created
	 */
	Semester createSemester(Semester sem);
	
	/**
	 * 
	 * @param sem
	 * @return true iff the semester is deleted from the database
	 */
	void deleteSemester(Semester sem);
	
	/**
	 * 
	 * @param sem
	 * @return the semester updated
	 */
	Semester updateSemester(Semester sem);
	
	/**
	 * 
	 * @return list of all the semesters
	 */
	Iterable<Semester> findAllSemesters();
	
	/**
	 * 
	 * @param id
	 * @return the semester associated with the given id 
	 */
	Semester findSemesterById(String id);
}

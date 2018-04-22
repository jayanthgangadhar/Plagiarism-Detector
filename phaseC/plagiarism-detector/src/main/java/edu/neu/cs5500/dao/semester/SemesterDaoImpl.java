/**
 * This is the DAO (data access object) layer implementation, which will interact
 * with the database
 * Implements SemesterDao
 */
package edu.neu.cs5500.dao.semester;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.repository.SemesterRepository;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 *
 */
@Repository("semDao")
public class SemesterDaoImpl implements  SemesterDao {

	private static Logger logger = Logger.getLogger(SemesterDaoImpl.class.getName());
	
	@Autowired
	private SemesterRepository semRepo;
	
	/**
	 * creates a semester
	 * @param sem: semester object to be created
	 * @return the semester created
	 */
	@Override
	public Semester createSemester(Semester sem) {
		Semester sem1 = null;
		try {
			sem1 = semRepo.save(sem);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return sem1;
	}
	
	/**
	 * deletes a semester
	 * @param sem: semester object to be deleted
	 */
	@Override
	public void deleteSemester(Semester sem) {
		try {
			semRepo.delete(sem);
		}
		catch (Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
	}
	
	/**
	 * update en existing semester with the given semester
	 * @param sem: the given semester
	 * @return the semester updated
	 */
	@Override
	public Semester updateSemester(Semester sem) {
		Semester sem1 = null;
		try {
			sem1 = semRepo.save(sem);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return sem1;
	}
	
	/**
	 * 
	 * @return list of all the semesters
	 */
	@Override
	public Iterable<Semester> findAllSemesters() {
		Iterable<Semester> it = null;
		try {
			it = semRepo.findAll();
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return it;
	}
	
	/**
	 * @param id: semester id
	 * @return the semester associated with the given id 
	 */
	@Override
	public Semester findSemesterById(String id) {
		Semester sem1 = null;
		try {
			sem1 = semRepo.findOne(id);
		}
		catch(Exception e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return sem1;
	}
}

/**
 * This is the service layer implementation, which will
 * contain all the business logic for the semester object 
 */
package edu.neu.cs5500.services.semester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.cs5500.dao.semester.SemesterDao;
import edu.neu.cs5500.domainObjects.Course;
import edu.neu.cs5500.domainObjects.Semester;
import edu.neu.cs5500.services.course.CourseService;
import edu.neu.cs5500.utils.Constants;

/**
 * @author sanketmathur
 *
 */
@Service("semService")
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterDao semDao;
	
	@Autowired
	private CourseService courseService;
	
	/**
	 * creates a semester
	 * @param sem: semester object to be created
	 * @return the semester created
	 */
	@Override
	public Semester createSemester(Semester sem) {
		if(sem != null) {
			Semester sem1 = semDao.findSemesterById(sem.get_id());
			if(sem1 != null) {
				return null;
			}
			return semDao.createSemester(sem);
		}
		return null;
	}
	
	/**
	 * 
	 * @param sem: semester object to be deleted
	 * @return true iff the semester is deleted from the database
	 */
	@Override
	public boolean deleteSemester(String id) {
		Semester sem = semDao.findSemesterById(id);
		if(sem != null) {
			List<Course> courses = courseService.findAllCoursesInThisSemester(id);
			List<String> courseIds = StreamSupport.stream(courses.spliterator(), false).map(c -> c.get_id()).collect(Collectors.toList());
			boolean result = true;
			for(String i: courseIds) {
				result = result && courseService.deleteCourse(i);
			}
			if(result) {
				semDao.deleteSemester(sem);
			}
		}
		return semDao.findSemesterById(id) == null;
	}
	
	/**
	 * 
	 * @param sem: new semester object which will update
	 * an existing semester from the given semester
	 * @return the semester updated
	 */
	@Override
	public Semester updateSemester(Semester sem) {
		Semester sem1 = semDao.findSemesterById(sem.get_id());
		if(sem1 != null) {
			if(sem.getName() != null && !sem.getName().equals(sem1.getName())) {
				sem1.setName(sem.getName());
			}
			if(sem.getStatus() != null && !sem.getStatus().equals(sem1.getStatus())) {
				sem1.setStatus(sem.getStatus());
			}
		}
		return semDao.updateSemester(sem1);
	}
	
	/**
	 * @return list of all the semesters
	 */
	@Override
	public List<Semester> findAllSemesters() {
		return (List<Semester>) semDao.findAllSemesters();
	}
	
	/**
	 * 
	 * @param id: semester id
	 * @return the semester associated with the given id 
	 */
	@Override
	public Semester findSemesterById(String id) {
		return semDao.findSemesterById(id);
	}
	
	/**
	 * @return list of all the active semesters
	 */
	public List<Semester> findAllActiveSemesters() {
		Iterable<Semester> it = semDao.findAllSemesters();
		List<Semester> sems = new ArrayList<>();
		if(it != null) {
			sems = StreamSupport.stream(it.spliterator(), false)
					.filter(s -> s.getStatus() != null && s.getStatus() != "" && s.getStatus().equalsIgnoreCase(Constants.ACTIVE))
					.collect(Collectors.toList());
		}
		return sems;
	}
}

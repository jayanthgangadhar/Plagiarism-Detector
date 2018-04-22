/**
 * 
 */
package edu.neu.cs5500.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.neu.cs5500.domainObjects.Course;

/**
 * @author sanketmathur
 *
 */
public interface CourseRepository extends MongoRepository<Course, String> {
	
	public List<Course> findCourseByFacultyID(String facultyID);
	
}

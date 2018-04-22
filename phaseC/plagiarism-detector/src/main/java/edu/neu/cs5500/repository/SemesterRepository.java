/**
 * 
 */
package edu.neu.cs5500.repository;

import org.springframework.data.repository.CrudRepository;

import edu.neu.cs5500.domainObjects.Semester;

/**
 * @author sanketmathur
 *
 */
public interface SemesterRepository extends CrudRepository<Semester, String> {

	
}

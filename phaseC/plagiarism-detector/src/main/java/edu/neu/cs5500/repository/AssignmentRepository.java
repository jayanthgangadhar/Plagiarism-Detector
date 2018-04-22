/**
 * A CRUDRepository interface which will interact with the
 * methods it provide implicitly without implementation
 */
package edu.neu.cs5500.repository;

import org.springframework.data.repository.CrudRepository;

import edu.neu.cs5500.domainObjects.Assignment;

/**
 * @author sanketmathur
 * 
 * Class to contain methods for the Assignment entity and its interaction with the Db
 *
 */
public interface AssignmentRepository extends CrudRepository<Assignment, String> {
	
}

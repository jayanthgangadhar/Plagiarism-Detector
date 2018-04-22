package edu.neu.cs5500.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.neu.cs5500.domainObjects.Operation;
import java.lang.String;

public interface OperationRepository extends MongoRepository<Operation, String> {
	
	public List<Operation> findByUserId(String userid);
	public Operation findById(String id);

}

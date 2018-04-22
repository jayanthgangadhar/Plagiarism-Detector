package edu.neu.cs5500.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.neu.cs5500.domainObjects.StudentCompareResult;
import java.lang.String;
import java.util.List;

public interface StudentComparisonRepository extends MongoRepository<StudentCompareResult, String> {

	
	public List<StudentCompareResult> findByParentOperationId(String parentoperationid);
	public StudentCompareResult findById(String id);
}

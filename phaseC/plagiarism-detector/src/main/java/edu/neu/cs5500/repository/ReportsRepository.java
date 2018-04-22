package edu.neu.cs5500.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.neu.cs5500.domainObjects.Report;
import java.lang.String;
import java.util.List;

public interface ReportsRepository extends MongoRepository<Report, String>  {

	
	public List<Report> findByParentStudentsCompareId(String parentstudentscompareid);
	
}

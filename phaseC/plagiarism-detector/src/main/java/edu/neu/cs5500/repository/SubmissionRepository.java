package edu.neu.cs5500.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.neu.cs5500.domainObjects.Submission;
/**
 * This class Represents the repository interface for submission
 * @author JayanthGangadhar
 *
 */

public interface SubmissionRepository extends CrudRepository<Submission, String> {
	public Submission findBy_id(String id);
	public Submission findByUrl(String url);
	public List<Submission> findByCourseId(String courseId);
	public List<Submission> findByStudentId(String studentId);
	public List<Submission> findByHomeworkId(String homeworkId);
	public List<Submission> findByStudentIdAndCourseId(String studentId, String courseId);
	public List<Submission> findByCourseIdAndHomeworkId(String courseId, String homeworkId);
	public Submission findByStudentIdAndHomeworkId(String studentId, String homeworkId);
}

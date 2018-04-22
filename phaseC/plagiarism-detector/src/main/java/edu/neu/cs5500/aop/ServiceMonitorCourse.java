/**
 * 
 */
package edu.neu.cs5500.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import edu.neu.cs5500.domainObjects.Course;

/**
 * @author sanketmathur
 *
 */

@Aspect
@Component
public class ServiceMonitorCourse {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.course.*.createCourse(*))", returning="result")
	public void monitorCreateCourse(JoinPoint jp, Course result) {		
		if(result != null) {
			logger.info("Course created successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid course creation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.course.*.updateCourse(*))", returning="result")
	public void monitorUpdateCourse(JoinPoint jp, Course result) {		
		if(result != null) {
			logger.info("Course updated successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid course updation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.course.*.deleteCourse(*))", returning="result")
	public void monitorDeleteCourse(JoinPoint jp, Boolean result) {		
		if(result) {
			logger.info("Course deleted successfully");
		}
		else {
			logger.info("Invalid course deletion attempt ");
		}
	}
}

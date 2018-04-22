/**
 * 
 */
package edu.neu.cs5500.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import edu.neu.cs5500.domainObjects.Semester;

/**
 * @author sanketmathur
 *
 */
@Aspect
@Component
public class ServiceMonitorSemester {

private Logger logger = Logger.getLogger(getClass().getName());
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.semester.*.createSemester(*))", returning="result")
	public void monitorCreateSemester(JoinPoint jp, Semester result) {
		if(result != null) {
			logger.info("Semester created successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid semester creation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.semester.*.deleteSemester(*))", returning="result")
	public void monitorDeleteSemester(JoinPoint jp, Boolean result) {
		if(result) {
			logger.info("Semester deleted successfully ");
		}
		else {
			logger.info("Invalid semester creation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.semester.*.updateSemester(*))", returning="result")
	public void monitorupdateSemester(JoinPoint jp, Semester result) {
		if(result != null) {
			logger.info("Semester updated successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid semester updation attempt ");
		}
	}
}

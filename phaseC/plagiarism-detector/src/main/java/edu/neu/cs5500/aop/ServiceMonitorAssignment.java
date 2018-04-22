/**
 * 
 */
package edu.neu.cs5500.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import edu.neu.cs5500.domainObjects.Assignment;

/**
 * @author sanketmathur
 *
 */

@Aspect
@Component
public class ServiceMonitorAssignment {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.assignment.*.createAssignment(*))", returning="result")
	public void monitorCreateAssignment(JoinPoint jp, Assignment result) {
		if(result != null) {
			logger.info("Assignment created successfully with id " + result.get_id());
		}
		else {
			logger.info("Invalid assignment creation attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.assignment.*.deleteAssignment(*))", returning="result")
	public void monitordeleteAssignment(JoinPoint jp, Boolean result) {
		if(result) {
			logger.info("Assignment deleted successfully");
		}
		else {
			logger.info("Invalid assignment deletion attempt ");
		}
	}
	
	@AfterReturning(value = "execution(* edu.neu.cs5500.services.assignment.*.updateAssignment(*))", returning="result")
	public void monitorUpdateAssignment(JoinPoint jp, Assignment result) {
		if(result != null) {
			logger.info("Assignment updated successfully with id: " + result.get_id());
		}
		else {
			logger.info("Invalid assignment updation attempt ");
		}
	}
}

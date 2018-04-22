package edu.neu.cs5500;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import edu.neu.cs5500.storage.StorageProperties;

/**
 * @author Asim
 * 
 * Core class which intializes the spring Boot application
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
public class PlagiarismDetectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlagiarismDetectorApplication.class, args);
	}
	
}

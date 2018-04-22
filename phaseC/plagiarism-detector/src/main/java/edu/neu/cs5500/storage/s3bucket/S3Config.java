/**
 * 
 */
package edu.neu.cs5500.storage.s3bucket;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @author Asim Khan
 * 
 * S3 Cofiguration setup
 *
 */

@Configuration
public class S3Config {

	@Value("${jsa.aws.access_key_id}")
	private String awsId;
 
	@Value("${jsa.aws.secret_access_key}")
	private String awsKey;
	
	@Value("${jsa.s3.region}")
	private String region;
 
	@Bean
	public AmazonS3 s3client() {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
		return AmazonS3ClientBuilder.standard()
								.withRegion(Regions.US_EAST_1)
		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
		                        .build();
	}
}

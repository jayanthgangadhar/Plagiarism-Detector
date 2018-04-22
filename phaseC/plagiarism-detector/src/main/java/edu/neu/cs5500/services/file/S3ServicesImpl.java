package edu.neu.cs5500.services.file;

import java.util.logging.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
 
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;

import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;

/**
 * @author Asim
 * 
 * Service to implement the S3 bucket integeration
 *
 */
@Service("s3Service")
public class S3ServicesImpl implements S3Services {
	
	
	// Logger
	private static Logger logger = Logger.getLogger(S3ServicesImpl.class.getName());

	@Autowired
	private AmazonS3 s3client;
 
	@Value("${jsa.s3.bucket}")
	private String bucketName;
 
	@Override
	public InputStream downloadFile(String keyName) {
		
		
		try {
			
            System.out.println("Downloading an object");
            S3Object s3object = s3client.getObject(new GetObjectRequest(bucketName, keyName));
            System.out.println("Content-Type: "  + s3object.getObjectMetadata().getContentType());            
            
            // return Utility.displayText(s3object.getObjectContent());
            logger.info("===================== Import File - Done! =====================");
            return s3object.getObjectContent();
            
        } catch (AmazonServiceException ase) {
        	logger.info("Caught an AmazonServiceException from GET requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
        	logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        } 
		
		return null;
	}
 
	@Override
	public String uploadFile(String keyName, File fileToBeUpoaded) {
		String uploadResult = null;
		
		try {
			PutObjectRequest uploadRequest = new PutObjectRequest(bucketName, keyName, fileToBeUpoaded);
			uploadRequest.setCannedAcl(CannedAccessControlList.PublicRead);
			s3client.putObject(uploadRequest);
			
			logger.info("===================== Upload File - Done! =====================");
			uploadResult = Constants.SUCCESS;
	        
		} catch (AmazonServiceException ase) {
			logger.info("Caught an AmazonServiceException from PUT requests, rejected reasons:");
			logger.info("Error Message:    " + ase.getMessage());
			logger.info("HTTP Status Code: " + ase.getStatusCode());
			logger.info("AWS Error Code:   " + ase.getErrorCode());
			logger.info("Error Type:       " + ase.getErrorType());
			logger.info("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            logger.info("Caught an AmazonClientException: ");
            logger.info("Error Message: " + ace.getMessage());
        }
		
		return uploadResult;
	}
 
}


package edu.neu.cs5500.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.neu.cs5500.domainObjects.ServiceResponse;

/**
 * @author Asim
 * 
 * Utility class which has reusable utility methods
 *
 */
public class Utility {
	
	private Utility() {}
	
	
	/**
	 * @param data
	 * @param status
	 * @param description
	 * @param response
	 * Private method to set the Custom response object
	 */
	public static void setResponseObject(Object data, String status, String description, ServiceResponse response) {
		response.setData(data);
		response.setStatus(status);
		response.setDescription(description);
	}
	
	
	public static String getFileStringData(InputStream input) throws IOException{
		// Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        StringBuilder b = new StringBuilder("");
        while (true) {
            String line = reader.readLine();            
            if (line == null) break;
            b.append(line).append("\n");
        }
        
        reader.close();
        return b.toString();
        
	}

}

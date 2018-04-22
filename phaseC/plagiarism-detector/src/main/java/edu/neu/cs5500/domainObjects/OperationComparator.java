package edu.neu.cs5500.domainObjects;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationComparator implements Comparator<Operation>{
	
	private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private static Logger logger = Logger.getLogger(OperationComparator.class.getName());
	@Override
	public int compare(Operation o1, Operation o2) {
		
		// Logger
		

		try {
			Date d1 = df.parse(o1.getDate());
			Date d2 = df.parse(o2.getDate());
			
			return -1 * d1.compareTo(d2);
		}catch (Exception e) {
			logger.log(Level.SEVERE,"Error Occurred while parsing date",e);
			return 0;
		}
		
	}

}

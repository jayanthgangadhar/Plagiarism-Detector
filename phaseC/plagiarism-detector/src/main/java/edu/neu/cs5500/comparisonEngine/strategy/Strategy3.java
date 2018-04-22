package edu.neu.cs5500.comparisonEngine.strategy;
import edu.neu.cs5500.comparisonEngine.lineSimilarity.LineSimilarity;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.domainObjects.LineSimilarityMetric;
import edu.neu.cs5500.domainObjects.Range;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Strategy3 corresponds to the finding similarity between files based on number of similar lines
 * @author JayanthGangadhar
 *
 */
public class Strategy3 implements Strategy {
	//represents the similarity score of two files
	Double metric;
	//represents length of file
	int length;
	//represents number of similar lines
	int similarlength;
	
	// Logger
	private static Logger logger = Logger.getLogger(Strategy2.class.getName());

	//to store list of ranges of similar lines among two files 
	List<Range> rangeList;
	
	public double compare(File f1, File f2) {
		//Get Similar lines
		LineSimilarity lineSim = new LineSimilarity();
		//To store similar lines between two files as a range of line numbers.
		rangeList = new ArrayList<>();

		try {
			rangeList = lineSim.similar(f1, f2);
		} catch (IOException e) {
			logger.log(Level.SEVERE,Constants.ERROR_OCCURRED, e);
		}
		
		LineSimilarityMetric lsm = lineSim.getLineSimilarityMetric();
		length = lsm.getLength();
		similarlength = lsm.getSimilarLength();
		
		if(length == 0 || similarlength == 0) {
			return 0;
		}
		metric =  (similarlength/Double.valueOf(length/2.0)) * 100;
		return metric;
	}
	@Override
	public String getStrategy() {
		return "Line Similarity Algorithm";
	}
	/**
	 * To return the similar lines of file of a range of values
	 * @return List of Range
	 */
	public List<Range> getRange(){
		return rangeList;
	}

}

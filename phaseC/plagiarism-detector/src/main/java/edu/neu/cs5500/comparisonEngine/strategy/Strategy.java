package edu.neu.cs5500.comparisonEngine.strategy;

import java.io.File;
/**
 * Strategy interface
 * @author JayanthGangadhar
 *
 */
public interface Strategy {
	/**
	 * Compare function to compare similarity between the two files
	 * @param f1 first file
	 * @param f2 second file
	 * @return a double value that represents similarity between the two files 
	 */
	public double compare(File f1, File f2);
	/**
	 * To get the name of the strategy used
	 * @return Strategy name
	 */
	public String getStrategy();
}

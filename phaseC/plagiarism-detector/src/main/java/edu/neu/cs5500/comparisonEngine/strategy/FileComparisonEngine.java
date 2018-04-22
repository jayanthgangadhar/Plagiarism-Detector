package edu.neu.cs5500.comparisonEngine.strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import edu.neu.cs5500.comparisonEngine.lineSimilarity.LineSimilarity;
import edu.neu.cs5500.domainObjects.Range;
import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.domainObjects.SimilarityMetric;
import edu.neu.cs5500.services.file.FileServiceImpl;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.Utility;
/**
 * FileComparisonEngine to Use the Context to see change in behavior when it changes its Strategy.
 * and returns a returns a report object contained an aggregated score from the three strategies and
 * list of similar lines
 * @author JayanthGangadhar
 *
 */

@Component("fileComparisonEngine")
public class FileComparisonEngine {
	// Logger
	private static Logger logger = Logger.getLogger(FileServiceImpl.class.getName());
	/**
	 * Returns a weighted similarity scored based on the three strategies
	 * @param f1 first file
	 * @param f2 second file
	 * @return Report object that captures similarity score and the range of line numbers that are plagiarized
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Report weightedCompare(File f1, File f2, Double threshold) throws FileNotFoundException, IOException {
		//Report object that includes report of each metric
		Report report;
		//To store list of similarity metrics
		List<SimilarityMetric> metrics = new ArrayList<SimilarityMetric>();
		//Metric1 based on EditDistance
		double metric1;
		//Metric2 based on LCS
		double metric2;
		//Metric3 based on pqGram
		double metric3;
		//weighted metric
		double metric;
		//File names
		String file1Name = f1.getName().substring(f1.getName().lastIndexOf("字")+1).replaceAll("啊", "/");
		String file2Name = f2.getName().substring(f2.getName().lastIndexOf("字")+1).replaceAll("啊", "/");
		DecimalFormat df = new DecimalFormat("#.##");  

		//Instantiate Context object
		Context context = new Context(new Strategy1());
		//Metric1
		metric1 = context.executeStrategy(f1, f2);
		SimilarityMetric m1 = new SimilarityMetric(context.getStrategy(), Double.valueOf(df.format(metric1)));
		metrics.add(m1);
		//Metric2
		context = new Context(new Strategy2());	
		metric2 = context.executeStrategy(f1, f2);
		SimilarityMetric m2 = new SimilarityMetric(context.getStrategy(), Double.valueOf(df.format(metric2)));
		metrics.add(m2);
		//Metric3
		context = new Context(new Strategy3());
		metric3 = context.executeStrategy(f1, f2);
		SimilarityMetric m3 = new SimilarityMetric(context.getStrategy(), Double.valueOf(df.format(metric3)));
		metrics.add(m3);
		//Get weighted score
		metric =  getWeightedAvg(metric1, 0.6, metric2, 0.2, metric3, 0.2);

		metric = Double.valueOf(df.format(metric));

		//Get similar Line as list of ranges of line numbers
		LineSimilarity lineSim = new LineSimilarity();
		List<Range> rangeList = new ArrayList<>();

		try {
			rangeList = lineSim.similar(f1, f2);
		} catch (IOException e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		//Generate Report
		report = new Report(metrics, file1Name, file2Name, metric, rangeList);
		String file1Data = Utility.getFileStringData(new FileInputStream(f1));
		String file2Data = Utility.getFileStringData(new FileInputStream(f2));
		report.setFile1Data(file1Data);
		report.setFile2Data(file2Data);
		report.setThresholdUsed(threshold);
		if (metric >= threshold) {
			report.setPlagiarismExists(Constants.YES);
		}
		

		return report;

	}
	/**
	 * To get weighted score of the metrics used
	 * @param score1 similarity generated from metric 1
	 * @param weight1 weight assigned to metric1
	 * @param score2 similarity generated from metric 2
	 * @param weight2 weight assigned to metric2
	 * @return Average Weighted Score
	 */
	private double getWeightedAvg(double score1, double weight1, double score2, double weight2, double score3, double weight3) {
		return weight1*score1 + weight2*score2 + weight3*score3; 
	}
}
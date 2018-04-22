package edu.neu.cs5500.services.file;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.neu.cs5500.domainObjects.Report;
import edu.neu.cs5500.comparisonEngine.strategy.Strategy3;
import edu.neu.cs5500.domainObjects.*;

public class FileServiceImplTests {
	ClassLoader classLoader = getClass().getClassLoader();
	File f1 = new File(classLoader.getResource("File1.py").getFile());
	File f2 = new File(classLoader.getResource("File2.py").getFile());

	//@Test
	public void test() throws FileNotFoundException, IOException {

		FileServiceImpl fs = new FileServiceImpl();
		Report repo = fs.compareTwoFiles(f1, f2,40d);
		double avgScore = repo.getAverageScore();
		List<SimilarityMetric> metricList = repo.getMetrics();
		SimilarityMetric m1 = metricList.get(0);
		SimilarityMetric m2 = metricList.get(1);
		String metric1Name = m1.getMetricType();
		String metric2Name = m2.getMetricType();
		Double score1 = m1.getScore();
		Double score2 = m2.getScore();
	
		assertTrue(avgScore>10 && avgScore<30);
		assertEquals("Zhang-Shasha ALgorithm", metric1Name);
		assertEquals("Longest Common Subsequence Algorithm", metric2Name);
		assertTrue(score1>10 && score1<30);
		assertTrue(score2>10 && score2<30);
	}

}

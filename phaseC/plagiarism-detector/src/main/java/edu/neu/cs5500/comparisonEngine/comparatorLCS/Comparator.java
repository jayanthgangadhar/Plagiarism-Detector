package edu.neu.cs5500.comparisonEngine.comparatorLCS;

import java.util.List;
/**
 * Comparator is used to parse two files and return a similarity score based on the length of
 * longest common subsequence.
 * @author JayanthGangadhar
 *
 */
public class Comparator {
	/**
	 * To return the similarity score of files f1 and f2
	 * @param file1 represents source file for comparison
	 * @param file2 represents target file for comparison
	 * @return similarity score of the two files
	 */
	public double compare(List<String> file1, List<String> file2) 
	{

		//to store length of file1
		int m = file1.size();
		//to store length of file1
		int n = file2.size();
		//table to store lengths of longest common suffixes of substrings of file1 and file2 .
		double min = m<n?m:n;
		int resultMatrix[][] = new int[m + 1][n + 1];
		// To store length of the longest common substring
		double result = 0;  
		double metric = 0;
		
		for (int i = 0; i <= m; i++) 
		{
			for (int j = 0; j <= n; j++) 
			{
				if (i == 0 || j == 0)
					resultMatrix[i][j] = 0;
				else if (file1.get(i - 1).equals(file2.get(j - 1)))
				{
					resultMatrix[i][j] = resultMatrix[i - 1][j - 1] + 1;
					result = Double.max(result, resultMatrix[i][j]);
				} 
				else
					resultMatrix[i][j] = 0;
			}
		}
		metric = ((result/min)*100);
		return metric;
		
	}}

package edu.neu.cs5500.comparisonEngine.lineSimilarity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.neu.cs5500.domainObjects.Range;
import edu.neu.cs5500.services.file.FileServiceImpl;
import edu.neu.cs5500.domainObjects.LineSimilarityMetric;
import edu.neu.cs5500.domainObjects.Pair;
/**
 * Line Similarity is used to detect exact lines of plagiarized code
 * @author JayanthGangadhar
 *
 */
public class LineSimilarity {
	//to store length of file
	private int length = 0;
	//to store number of similar lines
	private int similarLength = 0;
	
	private LineSimilarityMetric lsm;
	
	// Logger
	private static Logger logger = Logger.getLogger(FileServiceImpl.class.getName());
	ClassLoader classLoader = getClass().getClassLoader();
	/**
	 * To parse the input file 
	 * @param file
	 * @return a map where key : value represents Line number : Line
	 * @throws IOException
	 */
	private Map<Integer, String> parseFile(File file) throws IOException{
		//Map to stored the parsed file whose (key : value) is (LineNumber : Line)  
		Map<Integer, String> parsedFile = new HashMap<>();
		//To store each line
		String line = null;
		//To store the line numbers
		int lineNumber = 0;

		try(FileInputStream fis = new FileInputStream(file); BufferedReader br = new BufferedReader(new InputStreamReader(fis)))
		{
			while ((line = br.readLine()) != null) {
				if(!line.equals("")) {
					length++;
				}
				line = line.replaceAll("\\s+","");
				parsedFile.put(++lineNumber, line);
			}
		}
		catch (IOException e) {
			logger.log(Level.SEVERE, "Error Occurred while Parsing the files", e);
		}

		return parsedFile;
	}
	/**
	 * getKey is used to return key of map based on value
	 * @param lineNumberMap represents the parsed file as a hashmap of lineNumber : Line
	 * @param value represents value of the map whose key has to be searched
	 * @return key value
	 */
	private static Object getKey(Map<Integer, String> lineNumberMap, Object value) {
		
		for (Object o : lineNumberMap.keySet()) {
			if (lineNumberMap.get(o).equals(value)) {
				return o;
			}
		}
		return null;
	}
	
	/**
	 * getSimilarLines is used to iterate over the two files parsed to a map and return similar lines
	 * @param f1 represents the first parsed file
	 * @param f2 represents the second parsed file
	 * @return List of similar lines
	 */
	private List<Range> getSimilarLines(Map<Integer, String> f1, Map<Integer, String> f2) 
	{
		//Lists to store line numbers of plagiarised lines
		List<Integer> similarLines1 = new ArrayList<>();
		List<Integer> similarLines2 = new ArrayList<>();
		Iterator<String> it = f1.values().iterator();

		while(it.hasNext()) {
			String line = it.next();

			if(!line.equals("") && f2.containsValue(line)) {

				Integer s1 = (Integer)getKey(f1, line);
				Integer s2 = (Integer)getKey(f2, line);
				f2.values().remove(line);
				it.remove();
				similarLines1.add(s1);
				similarLines2.add(s2);
				similarLength++;
			}
		}
		
		if (similarLines1.isEmpty() || similarLines2.isEmpty()) {
			return new ArrayList<Range>();
		}

		return getRange(similarLines1, similarLines2);

	}
	/**
	 * Return similar lines of the two files
	 * @param f1 represents the first file
	 * @param f2 represents the second file
	 * @return List of Range of similar lines
	 * @throws IOException
	 */
	public List<Range> similar(File f1, File f2) throws IOException {
		Map<Integer, String> m1 = parseFile(f1);
		Map<Integer, String> m2 = parseFile(f2);
		return getSimilarLines(m1, m2);
	}
	
	// Helper function to get range of similar lines
	public List<Range> getRange(List<Integer>f1, List<Integer> f2) {
		Pair pair = new Pair();
		List<Pair> temp = new ArrayList<>();
		List<Range> rangeList = new ArrayList<>();
		int prev1;
		int prev2;
		int cur1;
		int cur2;
		cur1 = prev1 = f1.get(0);
		cur2 = prev2 = f2.get(0);
		pair.setNumber1(cur1);
		pair.setNumber2(cur2);
		temp.add(pair);

		Pair matchedLine = null;
		Range range = null;

		for(int i=1 ; i < f1.size() ; i++) {
			if((cur1 = f1.get(i)) == prev1+1 && (cur2 = f2.get(i)) == prev2+1) {
				matchedLine = new Pair(cur1,cur2);
				temp.add(matchedLine);
				prev1 = cur1;
				prev2 = cur2;
			}
			else {
				Pair p1 = temp.get(0);
				Pair p2 = temp.get(temp.size()-1);
				range = new Range(p1.getNumber1(), p2.getNumber1(), p1.getNumber2(), p2.getNumber2());
				rangeList.add(range);

				temp.clear();

				cur1 = prev1 = f1.get(i);
				cur2 = prev2 = f2.get(i);
				matchedLine = new Pair(cur1,cur2);
				temp.add(matchedLine);
			}
		}

		if(!temp.isEmpty()) {
			Pair p1 = temp.get(0);
			Pair p2 = temp.get(temp.size()-1);
			range = new Range(p1.getNumber1(), p2.getNumber1(), p1.getNumber2(), p2.getNumber2());
			rangeList.add(range);
		}
		
		return rangeList;

	}
	/*
	 * To return the similar lines of two files encapsulated as a LineSimilarityMetric metric
	 */
	public LineSimilarityMetric getLineSimilarityMetric() {
		lsm = new LineSimilarityMetric(length, similarLength);
		return lsm;
	}
}

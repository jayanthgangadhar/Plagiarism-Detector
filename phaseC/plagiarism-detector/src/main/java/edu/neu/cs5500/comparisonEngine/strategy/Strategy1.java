package edu.neu.cs5500.comparisonEngine.strategy;
import edu.neu.cs5500.comparisonEngine.ast.*;
import edu.neu.cs5500.comparisonEngine.editdistance.*;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.comparisonEngine.approxlib.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Strategy1 corresponds to the Zhang Sasha Algorithm used to generate a similarity between ASTs
 * @author JayanthGangadhar
 *
 */
public class Strategy1 implements Strategy {
	//To store the name of the strategy
	String strategy;
	//To get similarity as per the strategy
	double metric;
	/**
	 * implements compare methods to compare similarity of two files
	 */
	
	// Logger
	private static Logger logger = Logger.getLogger(Strategy1.class.getName());
	
	public double compare(File f1, File f2) {
		//represents the similarity of the two files in term of '%'
		metric=-1;
		//To Parse the first file
		ParserFacade parserFacade = new ParserFacade();
		AstPrinter astPrinter = new AstPrinter();
		//To Parse the second file
		ParserFacade parserFacade2 = new ParserFacade();
		AstPrinter astPrinter2 = new AstPrinter();

		try {
			//To get the ASTs in form of String
			String temp1 = astPrinter.getAst(parserFacade.parse(f1));
			String temp2 = astPrinter2.getAst(parserFacade2.parse(f2));
			//to get length of the files represented by the number of ast tokens
			int length1 = astPrinter.getLength();
			int length2 = astPrinter2.getLength();
			//Generating tree in the form required by approxlib
			LblTree t1 = LblTree.fromString(temp1);
			LblTree t2 = LblTree.fromString(temp2);
			//instantiate the EditDist object with value of 1 for insert, delete and update
			EditDist ed = new EditDist(1, 1, 1, false);
			//calculates the edit distance between the two files
			double dist = ed.treeDist(t2,t1);
			//to retrieve the length of the bigger file
			int bigger = length1>length2?length1:length2;
			//calculate the similarity
			metric = ((bigger - dist) / bigger)*100;
		} catch (IOException e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}
		return metric;	
	}
	@Override
	public String getStrategy() {
		return "Zhang-Shasha ALgorithm";
	}

}

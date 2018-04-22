package edu.neu.cs5500.comparisonEngine.strategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.neu.cs5500.comparisonEngine.ast.AstPrinter;
import edu.neu.cs5500.comparisonEngine.comparatorLCS.Comparator;
import edu.neu.cs5500.utils.Constants;
import edu.neu.cs5500.utils.GmailModule;
import edu.neu.cs5500.comparisonEngine.ast.ParserFacade;
/**
 * Strategy2 corresponds to the LCS Algorithm used to generate a similarity between ASTs
 * @author JayanthGangadhar
 *
 */
public class Strategy2 implements Strategy {
	double metric = -1;
	Comparator comp;
	/**
	 * implements compare methods to compare similarity of two files
	 */
	
	// Logger
	private static Logger logger = Logger.getLogger(Strategy2.class.getName());
	@Override
	public double compare(File f1, File f2) {
		//file1 represents an arraylist of nodes for the AST of first file
		List<String> file1 = new ArrayList<String>();
		//file1 represents an arraylist of nodes for the AST of first file
		List<String> file2 = new ArrayList<String>();
		//Instantiate Comparator object
		comp = new Comparator();
		//To Parse the first file
		ParserFacade parserFacade = new ParserFacade();
		AstPrinter astPrinter = new AstPrinter();
		//To Parse the second file
		ParserFacade parserFacade2 = new ParserFacade();
		AstPrinter astPrinter2 = new AstPrinter();
		try {
			//Get AST in form of arrayList
			file1=astPrinter.print(parserFacade.parse(f1));
			file2=astPrinter2.print(parserFacade2.parse(f2));
			metric = comp.compare(file1, file2);
		} catch (IOException e) {
			logger.log(Level.SEVERE, Constants.ERROR_OCCURRED, e);
		}

		return metric;
	}
	@Override
	public String getStrategy() {
		return "Longest Common Subsequence Algorithm";
	}

}

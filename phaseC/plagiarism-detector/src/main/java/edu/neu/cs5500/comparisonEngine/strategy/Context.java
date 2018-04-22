package edu.neu.cs5500.comparisonEngine.strategy;

import java.io.File;
/**
 * Context is a class that uses Strategy
 * @author JayanthGangadhar
 *
 */
public class Context {

	   private Strategy strategy;
//Constructor
	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }
/**
 * execute Strategy demonstrates change in Context behavior based on strategy
 * @param f1 first file
 * @param f2 second file
 * @return similarity of the two files 
 */
	   public double executeStrategy(File f1, File f2){
	      return strategy.compare(f1, f2);
	   }
	   /**
	    * To return the name of strategy
	    * @return strategy name
	    */
	   public String getStrategy() {
		   return strategy.getStrategy();
	   }
	}
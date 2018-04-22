package edu.neu.cs5500.comparisonEngine;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import edu.neu.cs5500.comparisonEngine.strategy.Context;
import edu.neu.cs5500.comparisonEngine.strategy.Strategy1;
import edu.neu.cs5500.comparisonEngine.strategy.Strategy2;
import edu.neu.cs5500.comparisonEngine.strategy.Strategy3;

@RunWith(SpringRunner.class)
public class ComparisonTests {
	
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	ClassLoader classLoader = getClass().getClassLoader();
	
	


	//Testing Zhang-Shasha Algorithm

	@Test
	public void testStrategy1() throws IOException {
		File f1 = resourceLoader.getResource("classpath:File1.py").getFile();
		File f2 = resourceLoader.getResource("classpath:File2.py").getFile();			
		Context context = new Context(new Strategy1());	
		double m1 =  context.executeStrategy(f1, f2);
		assertTrue(m1>10 && m1<30);
	}
	
	//Testing LCS Algorithm 

	@Test
	public void testStrategy2() throws IOException {
		File f1 = resourceLoader.getResource("classpath:File1.py").getFile();
		File f2 = resourceLoader.getResource("classpath:File2.py").getFile();;

		Context context = new Context(new Strategy2());	
		double m1 =  context.executeStrategy(f1, f2);
		assertTrue(m1>10 && m1<30 );
	}
	
	//Testing Similarity Lines Algorithm 

		@Test
		public void testStrategy3() throws IOException {
			File f1 = resourceLoader.getResource("classpath:File1.py").getFile();
			File f2 = resourceLoader.getResource("classpath:File2.py").getFile();;
			Strategy3 s3 = new Strategy3();	
			double dist =  s3.compare(f1, f2);
			assertTrue(dist>10 && dist<30 );
		}

		
	

}

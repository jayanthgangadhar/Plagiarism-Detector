package edu.neu.cs5500.comparisonEngine.approxlib;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Class to test HashValue implementation
 * @author JayanthGangadhar
 *
 */
public class HashValueTests {
	HashValue hv = new HashValue("hash");
	//test toString
	@Test
	public void testToString1() {
		assertEquals("hash", hv.toString());
	}
	
	//test compare functionality
	@Test
	public void testCompare() {
		HashValue temp = new HashValue("value");
		assertTrue(hv.compareTo(temp) < 0);
	}
	//test equals functionality
	@Test
	public void testIfEqual1() {
		assertTrue(!hv.equals(null));
	}
	//test equals functionality
	@Test
	public void testIfEqual2() {
		HashValue temp = new HashValue("hash");
		HashValue temp2 = hv.maxValue(10);
		assertTrue(hv.equals(temp));
	}
	//test parameterized constructor
	@Test
	public void testConstruct() {
		HashValue temp = new HashValue(10, 1);
		assertTrue(temp.compareTo(hv)<0);
	}

}

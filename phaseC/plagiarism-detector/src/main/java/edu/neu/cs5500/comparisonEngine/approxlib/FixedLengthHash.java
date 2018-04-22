package edu.neu.cs5500.comparisonEngine.approxlib;

/**
 * Reference : http://www.cosy.sbg.ac.at/~augsten
 * @author JayanthGangadhar
 *
 */
public abstract class FixedLengthHash {
	
	private int length;
	
	/**
	 * @param length length of the hash value (in bytes) produced by this function.
	 */
	public FixedLengthHash(int length) {
		this.length = length;
	}
	
	/**
	 * Compute the hash value of a string function. 
	 * 
	 * @param s original string 
	 * @return hash value of <code>s</code>
	 */
	 public abstract HashValue getHashValue(String s);
	
	/**
	 * @return hash value of the null-node-label
	 */
	public abstract HashValue getNullNode();


	/**
	 * @return length of the hash values produced by this function
	 */
	public int getLength() {
		return this.length;
	}
}

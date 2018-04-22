package edu.neu.cs5500.comparisonEngine.approxlib;

/**
 * Simple class that stores a hash value
 * Reference : http://www.cosy.sbg.ac.at/~augsten
 * @author JayanthGangadhar
 *
 */
public class HashValue implements Comparable {

	
	/**
	 * Mask used to retrieve the value of the least significant byte of an integer number.  
	 */
	public final int LSByteMask = 255;
		
	private String hashVal;
	
	/**
	 * Initialize the hash value with a string.
	 * 
	 * @param hashvalue hash value as a string
	 */
	public HashValue(String hashVal) {
		this.hashVal = hashVal;
	}

	/**
	 * Initialize the hash value with an integer number.
	 * 
	 * @param h hash value as an integer 
	 * @param length length of the hash value in bytes
	 */
	public HashValue(long h, int length) {
		StringBuilder s = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			char c = (char)(h & LSByteMask);
			s.append(c);
			h = h >>> 8;
		}
		hashVal = s.toString();
		
	}
	
	/**
	 * @return hash value as a string
	 */
	@Override
	public String toString() {
		if (hashVal.charAt(hashVal.length() -1) == ' ') {
			return hashVal.substring(0, hashVal.length() - 1) + (char)0;
		} else {
			return hashVal;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object arg0) {
		return this.hashVal.compareTo(((HashValue)arg0).toString());
	}
	
	public static HashValue maxValue(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			s += Character.toString(Character.MAX_VALUE); 
		}
		return new HashValue(s);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		if (arg0 != null && arg0 instanceof HashValue) {
			return (this.toString()).equals(((HashValue)arg0).toString());	
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
}

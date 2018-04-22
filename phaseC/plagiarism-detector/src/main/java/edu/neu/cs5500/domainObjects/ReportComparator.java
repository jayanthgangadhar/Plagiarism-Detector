package edu.neu.cs5500.domainObjects;

import java.util.Comparator;

public class ReportComparator implements Comparator<Report>{

	@Override
	public int compare(Report o1, Report o2) {
		
		return -1* o1.getAverageScore().compareTo(o2.getAverageScore());
	}

}

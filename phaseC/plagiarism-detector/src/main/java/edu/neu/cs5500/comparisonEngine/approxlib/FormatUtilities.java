package edu.neu.cs5500.comparisonEngine.approxlib;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import edu.neu.cs5500.utils.Constants;

import java.util.Random;
import java.util.ArrayList;
import java.util.Date;
/**
 * Reference : http://www.cosy.sbg.ac.at/~augsten
 * @author JayanthGangadhar
 *
 */
public class FormatUtilities {


	public static int matchingBracket(String s, int pos) {
		if ((s == null) || (pos > s.length() - 1)) {
			return -1;
		}
		char open = s.charAt(pos);
		char close;
		switch (open) {
		case '{': 
			close = '}';
			break;
		case '(':
			close = ')';
			break;
		case '[':
			close = ']';
			break;
		case '<':
			close = '>';
			break;
		default:
			return -1;
		}	

		pos++;
		int count = 1;
		while ((count != 0) && (pos < s.length())) {
			if (s.charAt(pos) == open) {
				count++;
			} else if (s.charAt(pos) == close) {
				count--;
			}
			pos++;
		}
		if (count != 0) {
			return -1;
		} else {
			return pos - 1;
		}
	}


	public static int getTreeID(String s) {
		if ((s != null) && (s.length() > 0)) {
			int end = s.indexOf(':', 1);
			if (end == -1) {
				return -1;
			} else {
				return Integer.parseInt(s.substring(0, end));
			}
		} else {
			return -1;
		}
	}

	public static String getRoot(String s) {
		if ((s != null) && (s.length() > 0) && s.startsWith("{") && s.endsWith("}")) {
			int end = s.indexOf('{', 1);
			if (end == -1) {
				end = s.indexOf('}', 1);
			}
			return s.substring(1, end);
		} else {
			return null;
		}
	}

	public static List<String> getChildren(String s) {
		List<String> children = new ArrayList<String>();
		if ((s != null) && (s.length() > 0) && s.startsWith("{") && s.endsWith("}")) {

			int end = s.indexOf('{', 1);
			if (end == -1) {
				return children;
			}
			String rest = s.substring(end, s.length() - 1);
			int match = 0;
			while ((rest.length() > 0) && ((match = matchingBracket(rest, 0)) != -1)) {
				children.add(rest.substring(0, match + 1));
				if (match + 1 < rest.length()) {
					rest = rest.substring(match + 1);
				} else {
					rest = "";
				}
			}
		} 

		return children;
	}
}

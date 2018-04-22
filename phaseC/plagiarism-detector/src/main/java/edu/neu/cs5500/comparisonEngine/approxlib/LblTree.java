package edu.neu.cs5500.comparisonEngine.approxlib;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;


/**
 * Reference : http://www.cosy.sbg.ac.at/~augsten
 * A node of a tree. Each tree has an ID.
 * The label can be empty, but can not contain trailing spaces (nor consist only of spaces).
 * 
 * Two nodes are equal, if there labels are equal, and n1 < n2 if label(n1) < label(n2).
 */
public class LblTree extends DefaultMutableTreeNode implements Comparable {

	public static final String TAB_STRING = "    ";
	public static final String ROOT_STRING =   "*---+";
	public static final String BRANCH_STRING = "+---+";

	public static final String OPEN_BRACKET = "{";
	public static final String CLOSE_BRACKET = "}";
	public static final String ID_SEPARATOR = ":";

	public static final int HIDE_NOTHING = 0;
	public static final int HIDE_ROOT_LABEL = 1;
	public static final int RENAME_LABELS_TO_LEVEL = 2;
	public static final int HIDE_ALL_LABELS = 3;
	public static final int RANDOM_ROOT_LABEL = 4;

	int treeID = Node.NO_TREE_ID;
	String label = null;
	Object tmpData = null;
	int nodeID = Node.NO_NODE;

	/**
	 * Use only this constructor!
	 */
	public LblTree(String label, int treeID) {
		super();
		this.treeID = treeID;
		this.label = label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	/**
	 * tmpData: Hook for any data that a method must attach to a tree.
	 * Methods can assume, that this date is null and should return it
	 * to be null!
	 */
	public void setTmpData(Object tmpData) {
		this.tmpData = tmpData;
	}

	public Object getTmpData() {
		return tmpData;
	}

	/**
	 * Clear tmpData in subtree rooted in this node.
	 */
	public void clearTmpData() {
		for (Enumeration e = breadthFirstEnumeration(); e.hasMoreElements();) {
			((LblTree)e.nextElement()).setTmpData(null);
		}
	}


	


	public int getNodeCount() {
		int sum = 1;
		for (Enumeration e = children(); e.hasMoreElements();) {
			sum += ((LblTree)e.nextElement()).getNodeCount();
		}
		return sum;
	}

	/**
	 * Constructs an LblTree from a string representation of tree. The
	 * treeID in the String representation is optional; if no treeID is given,
	 * the treeID of the returned tree will be NO_ID.
	 *
	 * @param s string representation of a tree. Format: "treeID:{root{...}}".
	 * @return tree represented by s
	 */
	public static LblTree fromString(String s) {
		int treeID = FormatUtilities.getTreeID(s);
		s = s.substring(s.indexOf(OPEN_BRACKET), s.lastIndexOf(CLOSE_BRACKET) + 1);
		LblTree node = new LblTree(FormatUtilities.getRoot(s), treeID);
		List<String> c = FormatUtilities.getChildren(s);
		for (String ss : c) {
			node.add(fromString(ss));
		}
		return node;
	}
	public HashValue getNodeHash(FixedLengthHash hf) {
		return hf.getHashValue(this.getLabel());
	}

	@Override
	public int compareTo(Object o) {
		return getLabel().compareTo(((LblTree)o).getLabel());
	}

}

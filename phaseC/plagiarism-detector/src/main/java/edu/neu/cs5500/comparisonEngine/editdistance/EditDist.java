package edu.neu.cs5500.comparisonEngine.editdistance;

import java.util.*;
import edu.neu.cs5500.comparisonEngine.approxlib.*;

/**
 * Zhang & Shasha algorithm
 * Reference: approxlib
 *
 */
public class EditDist extends EditBasedDist {
	
	// call initKeyroots to init the following arrays!
	private int[] kr1;
	private int[] kr2;  // LR_keyroots(t2)
	private int[] l1;   // l(t1) = post-order number of left-most leaf 
             	//   descendant of i-th node in post-order in t1
	private int[] l2;   // l(t2)
	private String[] lbl1; // label of i-th node in postorder of t1
	private String[] lbl2; // label of i-th node in postorder of t2
	
	private double treedist[][]; // intermediate treedist results
	
	public EditDist(boolean normalized) {
		this(1, 1, 1, normalized);
	}
	
	public EditDist(double ins, double del, double update, boolean normalized) {
		super(ins, del, update, normalized);
	}
	

	private static void init(int[] kr, int[] l, String[] lbl, LblTree t) {
		int nc = l.length;
		int lc = kr.length;
		
		int i = 0;
		for (Enumeration e = t.postorderEnumeration(); e.hasMoreElements();) {
		 	LblTree n = (LblTree)e.nextElement();
			// add postorder number to node
			n.setTmpData(i);	    	    
			// label
			lbl[i] = n.getLabel();
			// left-most leaf
			l[i] = ((Integer)((LblTree)n.getFirstLeaf()).getTmpData()).intValue();	    
			i++;
		}
		boolean[] visited = new boolean[nc];
		Arrays.fill(visited, false);
		int k = lc - 1;
		for (i = nc - 1; i >= 0; i--) {
			if (!visited[l[i]]) {
				kr[k] = i;
				visited[l[i]] = true;
				k--;
			}
		}
		t.clearTmpData();
	}
	
	@Override
	public double nonNormalizedTreeDist(LblTree t1, LblTree t2) {
		int nc1 = t1.getNodeCount();
		kr1 = new int[t1.getLeafCount()];
		l1 = new int[nc1];
		lbl1 = new String[nc1];
		
		int nc2 = t2.getNodeCount();
		kr2 = new int[t2.getLeafCount()];
		l2 = new int[nc2];
		lbl2 = new String[nc2];
		
		init(kr1, l1, lbl1, t1);
		init(kr2, l2, lbl2, t2);
		
		treedist = new double[nc1][nc2];
		
		for (int i = 0; i < kr1.length; i++) {
			for (int j = 0; j < kr2.length; j++) {
				treeEditDist(kr1[i], kr2[j]);
			}
		}
		return treedist[nc1 - 1][nc2 - 1];
	}

	
	
	private void treeEditDist(int i, int j) {
		int m = i - l1[i] + 2;
		int n = j - l2[j] + 2;
		double[][] forestdist = new double[m][n];
		
		int ioff = l1[i] - 1;
		int joff = l2[j] - 1;
		
		forestdist[0][0] = 0;
		for (int i1 = 1; i1 <= i - ioff; i1++) {
			forestdist[i1][0] = forestdist[i1 - 1][0] + this.getDel();		}
		for (int j1 = 1; j1 <= j - joff; j1++) {
			forestdist[0][j1] = forestdist[0][j1 - 1] + this.getIns(); 
		}
		for (int i1 = 1; i1 <= i - ioff; i1++) {
			for (int j1 = 1; j1 <= j - joff; j1++) {
				double wDel = this.getDel(); 
				double wIns = this.getIns(); 
				if ((l1[i1 + ioff] == l1[i]) &&
						(l2[j1 + joff] == l2[j])) {
					double u = 0;
					if (!lbl1[i1 + ioff].equals(lbl2[j1 + joff])) {
						u = this.getUpdate();
					}
					forestdist[i1][j1] = 
						Math.min(Math.min(forestdist[i1 - 1][j1] + wDel,
								forestdist[i1][j1 - 1] + wIns),
								forestdist[i1 - 1][j1 - 1] + u);
					treedist[i1 + ioff][j1 + joff] = forestdist[i1][j1];
				} else {
					forestdist[i1][j1] = 
						Math.min(Math.min(forestdist[i1 - 1][j1] + wDel,
								forestdist[i1][j1 - 1] + wIns),
								forestdist[l1[i1 + ioff] - 1 - ioff][l2[j1 + joff] -1 - joff] + 
								treedist[i1 + ioff][j1 + joff]);
				}
			}
		}		
	}
	
}

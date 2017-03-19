/**
 *
 * 118 Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle. 
 * For example, given numRows = 5, 
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 */ 

import java.util.*;

public class Solution {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
		if (numRows < 1) {
			return listOfList;
		}
		
		List<Integer> preList = new ArrayList<Integer>();
		preList.add(1);
		listOfList.add(preList);
		
		for (int i = 1; i < numRows; ++i) {
			List<Integer> curList = new ArrayList<Integer>();
			for (int j = 0; j <= i; ++j) {
				curList.add(getNumAt(preList, j) + getNumAt(preList, j - 1));
			}
			listOfList.add(curList);
			preList = curList;
		}
		return listOfList;
	}
	
	public int getNumAt(List<Integer> list, int index) {
		if (index < 0 || index >= list.size()) {
			return 0;
		}
		return list.get(index);
	}
}
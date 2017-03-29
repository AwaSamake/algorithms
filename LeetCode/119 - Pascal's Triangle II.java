/**
 *
 * 119 Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,Return [1,3,3,1].
 *
 */ 

import java.util.*;

public class Solution {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<Integer>(Collections.nCopies(rowIndex + 1, 0));
		row.set(0, 1);
		for (int i = 1; i <= rowIndex; ++i) {
			for (int j = i; j > 0; --j) {
				row.set(j, row.get(j) + row.get(j - 1));
			}
		}
		return row;
	}
}
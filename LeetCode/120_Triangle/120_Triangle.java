/**
 *
 * 120. Triangle
 *    Given a triangle, find the minimum path sum from top to bottom. Each step you may 
 *    move to adjacent numbers on the row below.
 *    
 *    For example, given the following triangle
 *    [
 *         [2],
 *        [3,4],
 *       [6,5,7],
 *      [4,1,8,3]
 *    ]
 *    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).     
 *    Note:
 *    Bonus point if you are able to do this using only O(n) extra space, where n is the 
 *    total number of rows in the triangle.
 *    
 */
import java.util.*;

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		List<Integer[]> cache = new ArrayList<Integer[]>();
		return minimumTotal(triangle, 0, cache, 0);
	}
	
	public int minimumTotal(List<List<Integer>> triangle, int deepth, List<Integer[]> cache, int index) {
		if (deepth >= triangle.size()) {
			return 0;
		}
		
		List<Integer> level = triangle.get(deepth);
		
		if (index >= level.size()) {
			return Integer.MAX_VALUE;
		}
		
		if (cache.size() <= deepth || cache.get(deepth) == null) {
			cache.add(new Integer[level.size()]);
		}
		Integer[] sums = cache.get(deepth);
		if (sums[index] != null) {
			return sums[index];
		}
		
		int left = minimumTotal(triangle, deepth + 1, cache, index);
		int right = minimumTotal(triangle, deepth + 1, cache, index + 1);
		
		int sum = level.get(index) + Math.min(left, right);
		sums[index] = sum;
		return sum;
	}
}
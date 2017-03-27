/**
 *
 * 447. Number of Boomerangs
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple 
 * of points (i, j, k) such that the distance between i and j equals the distance between 
 * i and k (the order of the tuple matters). Find the number of boomerangs. You may 
 * assume that n will be at most 500 and coordinates of points are all in the range 
 * [-10000, 10000] (inclusive).
 * Example:
 *     Input:
 *         [[0,0],[1,0],[2,0]]
 *     Output: 
 *         2
 * Explanation:
 *     The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 *
 */
import java.util.*;

public class Solution {
	public int numberOfBoomerangs(int[][] points) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result = 0;
		
		for (int i = 0; i < points.length; ++i) {
			for (int j = 0; j < points.length; ++j) {
				if (i == j) {
					continue;
				}
				// points[i] vs points[j]
				int distance = getDistance(points[i], points[j]);
				int count = map.getOrDefault(distance, 0) + 1;
				map.put(distance, count);
			}
			
			for (int count : map.values()) {
				result += count * (count - 1);
			}
			map.clear();
		}
		return result;
	}
	
	public int getDistance(int[] point1, int[] point2) {
		int x = point2[0] - point1[0];
		int y = point2[1] - point1[1];
		return x * x + y * y;
	}
}
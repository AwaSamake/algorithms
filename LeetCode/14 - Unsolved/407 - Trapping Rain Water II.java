/**
 *
 *  407. Trapping Rain Water II
 *    Given an m x n matrix of positive integers representing the height of 
 *    each unit cell in a 2D elevation map, compute the volume of water it is 
 *    able to trap after raining.
 *    
 *    Note:
 *    Both m and n are less than 110. The height of each unit cell is greater 
 *    than 0 and is less than 20,000.
 *    
 *    Example:
 *    
 *    Given the following 3x6 height map:
 *    [
 *      [1,4,3,1,3,2],
 *      [3,2,1,3,2,4],
 *      [2,3,3,2,3,1]
 *    ]
 *    
 *    Return 4.
 *    
 *    The above image represents the elevation map 
 *    [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] before the rain.
 *    
 *    
 *    After the rain, water are trapped between the blocks. The total volume 
 *    of water trapped is 4.
 *
 */
import java.util.*;

public class Solution {
	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length < 1 || heightMap[0].length < 1) {
			return 0;
		}
		int[][] wallMap = new int[heightMap.length][heightMap[0].length];
		int sum = 0;
		
		for (int r = 0; r < heightMap.length; ++r) {
			int max = 0;
			for (int c = 0; c < heightMap[r].length; ++c) {
				if (heightMap[r][c] > max) {
					max = heightMap[r][c];
				}
				wallMap[r][c] = max;
			}
			max = 0;
			for (int c = heightMap[r].length - 1; c > -1; --c) {
				if (heightMap[r][c] > max) {
					max = heightMap[r][c];
				}
				wallMap[r][c] = Math.min(max, wallMap[r][c]);
			}
		}
		for (int c = 0; c < heightMap[0].length; ++c) {
			int max = 0;
			for (int r = 0; r < heightMap.length; ++r) {
				if (heightMap[r][c] > max) {
					max = heightMap[r][c];
				}
				wallMap[r][c] = Math.min(max, wallMap[r][c]);
			}
			max = 0;
			for (int r = heightMap.length - 1; r > -1; --r) {
				if (heightMap[r][c] > max) {
					max = heightMap[r][c];
				}
				wallMap[r][c] = Math.min(max, wallMap[r][c]);
				if (heightMap[r][c] < wallMap[r][c]) {
					sum += wallMap[r][c] - heightMap[r][c];
					System.out.println(r + "," + c + ":" + (wallMap[r][c] - heightMap[r][c]));
				}
			}
		}
		return sum;
	}
}
/**
 *
 *  042. Trapping Rain Water
 *    Given n non-negative integers representing an elevation map where the 
 *    width of each bar is 1, compute how much water it is able to trap after 
 *    raining.
 *    
 *    For example, 
 *    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *    
 *    
 *    The above elevation map is represented by array [
 *    0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue 
 *    section) are being trapped.
 *
 */
import java.util.*;

public class Solution {
	public int trap(int[] height) {
		int[] walls = new int[height.length];
		int sum = 0;
		
		int max = 0;
		for (int i = 0; i < height.length; ++i) {
			if (height[i] > max) {
				max = height[i];
			}
			walls[i] = max;
		}
		max = 0;
		for (int i = height.length - 1; i > -1 ; --i) {
			if (height[i] > max) {
				max = height[i];
			}
			walls[i] = Math.min(walls[i], max);
		}
		
		for (int i = 0; i < height.length; ++i) {
			if (height[i] < walls[i]) {
				sum += walls[i] - height[i];
			}
		}
		return sum;
	}
}
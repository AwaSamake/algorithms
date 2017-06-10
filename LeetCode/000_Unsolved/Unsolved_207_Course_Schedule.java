/**
 *
 *  207. Course Schedule
 *    There are a total of n courses you have to take, labeled from 0 to n - 1.
 *    
 *    Some courses may have prerequisites, for example to take course 0 you have to first 
 *    take course 1, which is expressed as a pair: [0,1]
 *    
 *    Given the total number of courses and a list of prerequisite pairs, is it possible 
 *    for you to finish all courses?
 *    
 *    For example:
 *    
 *    2, [[1,0]]
 *    There are a total of 2 courses to take. To take course 1 you should have finished 
 *    course 0. So it is possible.
 *    
 *    2, [[1,0],[0,1]]
 *    There are a total of 2 courses to take. To take course 1 you should have finished 
 *    course 0, and to take course 0 you should also have finished course 1. So it is 
 *    impossible.
 *    
 *    Note:
 *    The input prerequisites is a graph represented by a list of edges, not adjacency 
 *    matrices. Read more about how a graph is represented.
 *    You may assume that there are no duplicate edges in the input prerequisites.
 *
 */
import java.util.*;

public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites.length == 0) {
			return true;
		}
		
		int[] taken = new int[numCourses];
		
		for (int i = 0; i < taken.length; ++i) {
			take(prerequisites, taken, i);
		}
		
		for (int i = 0; i < taken.length; ++i) {
			if (taken[i] != 2) {
				return false;
			}
		}
		return true;
	}
	
	public void take(int[][] prerequisites, int[] taken, int course) {
		if (taken[course] == 2) {
			return;
		}
//		System.out.println("can i take " + course);
		for (int[] prerequisite : prerequisites) {
			int c = prerequisite[0];
			int require = prerequisite[1];
			if (c == course && taken[c] == 0) {
				taken[c] = 1;
				take(prerequisites, taken, require);
				if (taken[require] == 2) {
					taken[c] = 2;
				} else {
					taken[c] = 0;
				}
			}
		}
		for (int[] prerequisite : prerequisites) {
			int c = prerequisite[0];
			int require = prerequisite[1];
			if (c == course && taken[require] != 2) {
				taken[course] = 0;
//				System.out.println("No + " + course);
				return;
			}
		}
		taken[course] = 2;
//		System.out.println("yes " + course);
	}
}
/**
 *
 * 4.12 Paths with Sum
 *     You are given a binary tree in which each node contains an integer value (which
 *     might be positive or negative). Design an algorithm to count the number of oaths
 *     that sum to a given value. The path does not need to start or end at the root or
 *     leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 */
import java.util.*;

class PathsWithSum {
    public static int countPathsWithSum(Node root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer,Integer>());
    }
    
    public static countPathsWithSum(Node root, int targetSum, int runningSum, 
                                    HashMap<Integer,Integer> pathCount) {
        if (node == null) {
            return 0;
        }
        
        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);
        
        if (runningSum == targetSum) {
            totalPaths++;
        }
        
        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);
        
        return totalPaths;
    }
    
    public static void incrementHashTable(HashMap<Integer,Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
    
	public static void main(String[] args) {
		
	}
}
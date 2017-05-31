/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 17-05-30 22:58
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        kSumII(A, k, target, combinations, new ArrayList<Integer>(), 0, -1);
        return combinations;
    }
    
    public void kSumII(int[] A, int k, int target, 
                        ArrayList<ArrayList<Integer>> combinations, 
                        ArrayList<Integer> combination,
                        int sum, int index) {
        if (k == combination.size() && sum == target) {
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        
        if (sum > target || combination.size() > k || index >= A.length) {
            return;
        }
        
        for (int i = index + 1; i < A.length; ++i) {
            combination.add(A[i]);
            kSumII(A, k, target, combinations, combination, sum + A[i], i);
            combination.remove(combination.size() - 1);
        }
    }
}
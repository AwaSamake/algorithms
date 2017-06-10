/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 17-06-09 22:44
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		combine(combinations, combination, 0, n, k);
		return combinations;
    }
    
    public void combine(List<List<Integer>> combinations, List<Integer> combination, int current, int n, int k) {
		if (combination.size() == k) {
		    combinations.add(new ArrayList<Integer>(combination));
		    return;
		}
		for (int i = current + 1; i <= n; ++i) {
		    combination.add(i);
		    combine(combinations, combination, i, n, k);
		    combination.remove(combination.size() - 1);
		}
    }
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Java
@Datetime: 17-06-05 23:01
*/

public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        int[] counts = new int[10001];
        for (int a : A) {
            counts[a]++;
        }
        int sum = 0;
        for (int i = 0; i < 10001; ++i) {
            int count = counts[i];
            counts[i] = sum;
            sum += count;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int query : queries) {
            result.add(counts[query]);
        }
        return result;
    }
}

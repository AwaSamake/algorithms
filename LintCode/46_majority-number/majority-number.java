/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 17-06-01 01:10
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        int current = 0;
        int count = 0;
        for (int num : nums) {
            if (num == current) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    current = num;
                    count = 1;
                }
            }
        }
        return current;
    }
}
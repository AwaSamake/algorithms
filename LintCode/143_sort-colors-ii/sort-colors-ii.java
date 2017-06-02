/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 17-06-02 04:08
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int[] counts = new int[k];
        for (int color : colors) {
            counts[color - 1]++;
        }
        
        int index = 0;
        for (int i = 0; i < counts.length; ++i) {
            while (counts[i]-- > 0) {
                colors[index++] = i + 1;
            }
        }
    }
}
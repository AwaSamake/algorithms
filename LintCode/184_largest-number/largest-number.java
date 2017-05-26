/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 17-05-25 23:39
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] nums) {
        // write your code here
        String[] values = new String[nums.length];
        int index = 0;
        for (int num: nums) {
            values[index++] = String.valueOf(num);
        }
        Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			    String s2 = str2 + str1;
			    return s2.compareTo(s1);
		    }
	    };
	    
        Arrays.sort(values, comp);
		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append(value);
		}
		int begin = 0;
		while (begin < (sb.length() - 1) && sb.charAt(begin) == '0') {
		    begin++;
		}
		return sb.substring(begin).toString();
    }
}
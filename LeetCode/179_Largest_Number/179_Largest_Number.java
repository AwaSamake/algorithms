/**
 *
 * 179. Largest Number
 *    Given a list of non negative integers, arrange them such that they form the
 *    largest number.
 *
 *    For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 *    Note: The result may be very large, so you need to return a string instead of an
 *    integer.
 *
 */

import java.util.*;

public class Solution {
    public String largestNumber(int[] nums) {
        // write your code here
        String[] values = new String[nums.length];
        int index = 0;
        for (int num : nums) {
            values[index++] = String.valueOf(num);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
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
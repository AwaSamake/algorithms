/**
 *
 * 344. Reverse String
 *     Write a function that takes a string as input and returns the string reversed. 
 *     Example: 
 *         Given s = "hello", return "olleh".
 * 
 */
import java.util.*;

public class Solution {
	public String reverseString(String s) {
		char[] arr = s.toCharArray();
		int left = 0, right = arr.length - 1;
		char temp;
		while (left < right) {
			temp = arr[right];
			arr[right] = arr[left];
			arr[left] = temp;
			left++;
			right--;
		}
		return new String(arr);
	}
}
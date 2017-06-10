/**
 *
 * 038. Count and Say
 *     The count-and-say sequence is the sequence of integers beginning as follows: 
 *     1, 11, 21, 1211, 111221, ... 
 *     1 is read off as "one 1" or 11. 
 *     11 is read off as "two 1s" or 21. 
 *     21 is read off as "one 2, then one 1" or 1211. 
 *     Given an integer n, generate the n-th sequence. 
 *     Note: 
 *         The sequence of integers will be represented as a string.
 * 
 */
import java.util.*;

public class Solution {
	public String countAndSay(int n) {
		StringBuilder sequence = new StringBuilder("1");
		StringBuilder newSequence = new StringBuilder();
		while (--n > 0) {
			int start = 0, end = 0;
			while (start < sequence.length()) {
				end = count(sequence, start);
				newSequence.append(end - start);
				newSequence.append(sequence.charAt(start));
				start = end;
			}
			sequence = newSequence;
			newSequence = new StringBuilder();
		}
		return sequence.toString();
	}
	
	public int count(StringBuilder sequence, int start) {
		int i = start;
		while (i < sequence.length() && sequence.charAt(i) == sequence.charAt(start)) {
			++i;
		}
		return i;
	}
}
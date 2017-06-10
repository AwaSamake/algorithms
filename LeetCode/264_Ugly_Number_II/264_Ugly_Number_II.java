/**
 *
 * 264. Ugly Number II
 *    Write a program to find the n-th ugly number.
 *    
 *    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For 
 *    example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly 
 *    numbers.
 *    
 *    Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 */
import java.util.*;

public class Solution {
	public int nthUglyNumber(int n) {
		Queue<Integer> two = new LinkedList<Integer>();
		Queue<Integer> three = new LinkedList<Integer>();
		Queue<Integer> five = new LinkedList<Integer>();
		int min = 1;
		while (n-- > 1) {
			two.add(min * 2);
			three.add(min * 3);
			five.add(min * 5);
			if (two.peek() < three.peek()) {
				if (two.peek() < five.peek()) {
					min = two.poll();
				} else {
					min = five.poll();
				}
			} else {
				if (three.peek() < five.peek()) {
					min = three.poll();
				} else {
					min = five.poll();
				}
			}
			if (!two.isEmpty() && two.peek() == min) {
				two.poll();
			}
			if (!three.isEmpty() && three.peek() == min) {
				three.poll();
			}
			if (!five.isEmpty() && five.peek() == min) {
				five.poll();
			}
		}
		return min;
	}
}
/**
 *
 * 16.23 Rand7 from Rand5
 *     Implement a method rand7() given rand5(). That is, given a method that generates a 
 *     random number between 0 and 4 (inclusive), write a method that generates a random 
 *     number between 0 and 6 (inclusive).
 *
 */
import java.util.*;

class Rand7 {
	private static Random rand = new Random();
	public static int rand5() {
		return rand.nextInt(5);
	}
	
	public static int rand7a() {
		int sum = 0;
		for (int i = 0; i < 7; ++i) {
			sum += rand5();
		}
		return sum % 7;
	}
	
	public static int rand7b() {
		while (true) {
			// rand5 generate number frmo 0 to 4
			// (0 - 4) * 2 is even number from 0 to 9
			int r1 = 2 * rand5();
			int r2 = rand5();
			
			// number in r2 has same probability
			if (r2 != 4) {
				// so chance of 0, 1 are same as 2, 3
				int evenOrOdd = r2 % 2;
				// num will be from 0 - 9 with equal chance
				int num = r1 + evenOrOdd;
				if (num < 7) {
					return num;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int generateSize = 7000000;
		int[] count = new int[7];
		for (int i = 0; i < generateSize; ++i) {
			count[rand7b()]++;
		}
		int avg = generateSize / 7;
		for (int c : count) {
			System.out.println((c - avg) + " = " + ((c * 1.0 - avg) / avg * 100) + "%" );
		}
	}
}
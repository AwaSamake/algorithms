/**
 *
 * 16.5 Factorial Zeros
 *     Write an algorithm which computes the number of trialling zeros in n factorial.
 *
 */

class FactorialZeros {
	public static int factorsOf5(int i) {
		int count = 0;
		while (i % 5 == 0) {
			++count;
			i /= 5;
		}
		return count;
	}
	
	public static int countFactZeros1(int num) {
		int count = 0;
		for (int i = 2; i <= num; i++) {
			count += factorsOf5(i);
		}
		return count;
	}
	
	public static int countFactZeros2(int num) {
		int count = 0;
		if (num < 0) {
			return -1;
		}
		for (int i = 5; num / i > 0; i *= 5) {
			count += num / i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int num = 100;
		System.out.println(countFactZeros1(num));
		System.out.println(countFactZeros2(num));
	}
}
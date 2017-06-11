/**
 *
 * 16.16 Sub Sort
 *     Given an array of integers, write a method to find indices m and n such that if 
 *     you sorted elements m through n, the entire array would be sorted. Minimize n - m 
 *     (that is, find the smallest such sequence).
 *     EXAMPLE
 *     Input: 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19
 *     Output: (3, 9)
 *
 */

class SubSort {
	public static void findUnsortedSequence(int[] numbers) {
		int endOfLeft = findEndOfLeftSubSequenc(numbers);
		if (endOfLeft == numbers.length - 1) {
			return;
		}
		int beginOfRight = findBeginOfRightSubSequence(numbers);
		
		int min = numbers[endOfLeft + 1], max = numbers[beginOfRight - 1];
		for (int i = endOfLeft + 1; i < beginOfRight; ++i) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		int left = shrinkLeft(numbers, min, endOfLeft);
		int right = shrinkRight(numbers, max, beginOfRight);
		
		System.out.println(left + " - " + right);
	}
	
	public static int findEndOfLeftSubSequenc(int[] numbers) {
		for (int i = 1; i < numbers.length; ++i) {
			if (numbers[i - 1] > numbers[i]) {
				return i - 1;
			}
		}
		return numbers.length - 1;
	}
	
	public static int findBeginOfRightSubSequence(int[] numbers) {
		for (int i = numbers.length - 1; i > 0; --i) {
			if (numbers[i] < numbers[i - 1]) {
				return i;
			}
		}
		return 0;
	}
	
	public static int shrinkLeft(int[] numbers, int min, int endOfLeft) {
		for (int i = endOfLeft; i >= 0; --i) {
			if (numbers[i] < min) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public static int shrinkRight(int[] numbers, int max, int beginOfRight) {
		for (int i = beginOfRight; i < numbers.length; ++i) {
			if (numbers[i] > max) {
				return i - 1;
			}
		}
		return numbers.length - 1;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		findUnsortedSequence(numbers);
	}
}
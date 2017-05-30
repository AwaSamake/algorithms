/**
 *
 * 16.17 Contiguous Sequence
 *     You are given an array of integers (both positive and negative). Find the 
 *     contiguous sequence with he largest sum. Return the sum.
 *     EXAMPLE
 *     Input: 2, -8, 3, -2, 4, -10
 *     Output: (i.e., {3, -2, 4})
 *
 */

class ContiguousSequence {
	public static int findContiguousSequence(int[] numbers) {
		int max = 0;
		int sum = 0;
		int begin = 0, newBegin = 0;
		int end = 0;
		for (int i = 0; i < numbers.length; ++i) {
			sum += numbers[i];
			if (sum > max) {
				max = sum;
				end = i;
			} else if (sum < 0) {
				sum = 0;
				begin = newBegin;
				newBegin = i + 1;
			}
		}
		System.out.println(begin + " - " + end);
		return max;
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[] {2, -8, 3, -2, 4, -10};
		int max =  findContiguousSequence(numbers);
		System.out.println("Max:" + max);
	}
}
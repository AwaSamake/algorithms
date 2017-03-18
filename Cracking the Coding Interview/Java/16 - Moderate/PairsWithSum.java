import java.util.*;

/**
 *
 * 16.24 Pairs with Sum
 *     Design an algorithm to find all pairs of integers within an array which sum to a 
 *     specified value.
 *
 */

class Pair extends Object {
	public int a;
	public int b;
	
	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public String toString() {
		return "(" + a + ", " + b + ") ";
	}
}

class PairsWithSum {
	public static ArrayList<Pair> getPairSum(int[] numbers, int sum) {
		HashMap<Integer, Integer> leftOver = new HashMap<Integer, Integer>();
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for (int i = 0; i < numbers.length; ++i) {
			int target = sum - numbers[i];
			int numOfTarget = leftOver.getOrDefault(target, 0);
			if (numOfTarget > 0) {
				numOfTarget--;
				leftOver.put(target, numOfTarget);
				pairs.add(new Pair(numbers[i], target));
			} else {
				int numOfNumber = leftOver.getOrDefault(numbers[i], 0);
				leftOver.put(numbers[i], numOfNumber + 1);
			}
		}
		return pairs;
	}
	
	
	public static void main(String[] args) {
		int[] numbers = new int[] {5, 6, 6, 7, 4};
		
		ArrayList<Pair> pairs = getPairSum(numbers, 11);
		
		System.out.println(pairs);
	}
}
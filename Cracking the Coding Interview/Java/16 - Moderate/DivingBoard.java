import java.util.*;

/**
 *
 * 16.11 Diving Board
 *     You are building a diving board by placing a bunch of planks of wood end-to-end.
 *     There are two types of planks, one of length shorter and one of length longer. You
 *     must use exactly K planks of wood. Write a method to generate all possible length
 *     for diving board.
 *
 */

class DivingBoard {
	public static void main(String[] args) {
		int numberOfPlanks = 25;
		int shorter = 6;
		int longer = 7;
		
		long start = System.currentTimeMillis();
		HashSet<Integer> lengths = getAllLengths(numberOfPlanks, shorter, longer);
		System.out.println(lengths.toString());
		long gap1 = System.currentTimeMillis();
		
		HashSet<Integer> lengths2 = getAllLengths2(numberOfPlanks, shorter, longer);
		System.out.println(lengths2.toString());
		long gap2 = System.currentTimeMillis();
		
		HashSet<Integer> lengths3 = getAllLengths3(numberOfPlanks, shorter, longer);
		System.out.println(lengths3.toString());
		long end = System.currentTimeMillis();
		
		System.out.println("Method 1:" + (gap1 - start) + " ms");
		System.out.println("Method 2:" + ((gap2 - gap1) / 1000) + "s");
		System.out.println("Method 3:" + (end - gap2) + " ms");
	}
	
	/*===================================
	=            Method - 01            =
	===================================*/
	public static HashSet<Integer> getAllLengths(int numberOfPlanks, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		getAllLengths(numberOfPlanks, shorter, longer, 0, lengths);
		return lengths;
	}
	
	public static void getAllLengths(int plansLeft, int shorter, int longer, int currentLength, HashSet<Integer> lengths) {
		if (plansLeft == 0) {
			lengths.add(currentLength);
			return;
		}
		
		getAllLengths(plansLeft - 1, shorter, longer, currentLength + shorter, lengths);
		getAllLengths(plansLeft - 1, shorter, longer, currentLength + longer, lengths);
	}
	
	/*===================================
	=            Method - 02            =
	===================================*/
	public static HashSet<Integer> getAllLengths2(int numberOfPlanks, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		LinkedList<Integer> currentLengths = new LinkedList<Integer>();
		currentLengths.add(0);
		for (int i = numberOfPlanks; i > 0; --i) {
			LinkedList<Integer> newLengths = new LinkedList<Integer>();
			while (!currentLengths.isEmpty()) {
				int length = currentLengths.removeFirst();
				newLengths.add(length + shorter);
				newLengths.add(length + longer);
			}
			currentLengths = newLengths;
		}
		while (!currentLengths.isEmpty()) {
			lengths.add(currentLengths.removeFirst());
		}
		return lengths;
	}
	
	/*===================================
	=            Method - 03            =
	===================================*/
	public static HashSet<Integer> getAllLengths3(int numberOfPlanks, int shorter, int longer) {
		HashSet<Integer> lengths = new HashSet<Integer>();
		for (int shorterCount = 0; shorterCount <= numberOfPlanks; ++shorterCount) {
			int longerCount = numberOfPlanks - shorterCount;
			int length = shorter * shorterCount + longer * longerCount;
			lengths.add(length);
		}
		return lengths;
	}
}




















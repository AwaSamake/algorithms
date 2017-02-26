/**
 *
 * 8.4 Power Set
 *     Write a method to return all subsets of a set.
 *
 */
import java.util.*;

class PowerSet {
	public static ArrayList<ArrayList<Integer>> powerSet(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		// empty set
		subsets.add(new ArrayList<Integer>());
		powerSet(set, subsets);
		return subsets;
	}
	
	public static void powerSet(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> subsets) {
		if (set.isEmpty()) {
			return;
		}
		ArrayList<ArrayList<Integer>> newSubsets = new ArrayList<ArrayList<Integer>>();
		int removed = set.remove(0);
		for (ArrayList<Integer> subset : subsets) {
			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.addAll(subset);
			newSubset.add(removed);
			newSubsets.add(newSubset);
		}
		subsets.addAll(newSubsets);
		powerSet(set, subsets);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);
		set.add(6);
		set.add(7);
		
		ArrayList<ArrayList<Integer>> subsets = powerSet(set);
		
		System.out.println(subsets);
	}
}
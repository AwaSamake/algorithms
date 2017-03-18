/**
 *
 * 10.5 Space Search
 *     Given a sorted array of strings that is interspersed with empty strings, write a 
 *     method to find the location of a given string.
 *     EXAMPLE
 *         Input: ball, {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 *        Output: 4
 *
 */
import java.util.*;

class SparseSearch {
	public static int binarySearch(String[] input, String key, int lower, int upper) {
		if (lower > upper) {
			return -1;
		}
		int mid = (lower + upper) >> 1;
		System.out.println(lower + " - " + mid + " - " + upper);
		if (input[mid].equals(key)) {
			return mid;
		} else if (input[mid].equals("")) {
			int index = binarySearch(input, key, lower, mid - 1);
			if (index == -1) {
				return binarySearch(input, key, mid + 1, upper);
			}
			return index;
		} else if (input[mid].compareTo(input[upper]) > 0) {
			return binarySearch(input, key, mid + 1, upper);
		} else {
			return binarySearch(input, key, lower, mid - 1);
		}
	}
	
	public static void main(String[] args) {
		String[] input = new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		
		System.out.println(binarySearch(input, "ball", 0, input.length - 1));
	}
}
/**
 *
 * 10.4 Sorted Search, No Size
 *     You are given an array-like data structure listy which lacks a size method. 
 *     It does, however, have an elementAt(i) method that returns the element at index i 
 *     in O(1) time. If i is beyong the bounds of the data structure, it returns -1. 
 *     (For this reason, the data structure only supports positive integers.) Given a 
 *     Listy which contains sorted, positive integers, find the index at which an element 
 *     x occurs. If x occurs multiple times, you may return any index.
 *
 */
import java.util.*;

class SortedSearch {
	public static int search(Listy list, int key) {
		int upper = 1;
		int lower = 0;
		// if upper is not greater that key, and its not over the end
		while (list.elementAt(upper) < key && list.elementAt(upper) != -1) {
			upper <<= 1;
		}
		return binarySearch(list, key, upper / 2, upper);
	}
	
	public static int binarySearch(Listy list, int key, int lower, int upper) {
		int mid = (lower + upper) >> 1;
		if (list.elementAt(mid) == key) {
			return mid;
		} else if (list.elementAt(mid) == -1 || key < list.elementAt(mid)) {
			return binarySearch(list, key, lower, mid - 1);
		} else {
			return binarySearch(list, key, mid + 1, upper);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
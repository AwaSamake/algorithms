/**
 *
 * 10.8 Find Duplicates
 *     You have an array with all the numbers form 1 to N, where N is at most 32000. The
 *      array may have duplicate entries and you do not know what N is. With only 4 kilobytes 
 *      of memory available, how would you print all duplicate elements in the array?
 *
 */
import java.util.*;

class FindDuplicates {
	public static void printDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int num : array) {
			if (bs.get(num - 1)) {
				System.out.println(num);
			} else {
				bs.set(num - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
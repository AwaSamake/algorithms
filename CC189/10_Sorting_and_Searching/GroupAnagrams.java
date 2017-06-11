/**
 *
 * 10.2 Group Anagrams
 * 		Write a method to sort an array of strings so that all the anagrams are next to
 * 		each other.
 *
 */
import java.util.*;

class AnagramsComparator implements Comparator<String> {
	String sortChar(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	public int compare(String s1, String s2) {
		return sortChar(s1).compareTo(sortChar(s2));
	}
}


class GroupAnagrams {	
	public static void main(String[] args) {
		String[] words = "aaa bbb ccc aab aba baa".split(" ");
		
		Arrays.sort(words, new AnagramsComparator());
		System.out.println(String.join("\n", words));
	}
}
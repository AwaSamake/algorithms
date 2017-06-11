/**
 *
 * 16.2 Word Frequencies
 *     Design a method to find the frequency of occurrences of any given word in a book.
 *     What if we were running this algorithm multiple times?
 *
 */
import java.util.*;

class WordFrequencies {
	public static int getFrequencySimple(String[] words, String key) {
		int count = 0;
		for (String word: words) {
			if (word.equals(key)) {
				++count;
			}
		}
		return count;
	}
	
	public static HashMap<String, Integer> getFrequency(String[] words) {
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for (String word: words) {
			int count = table.getOrDefault(word, 0);
			table.put(word, count + 1);
		}
		return table;
	}
	
	public static void main(String[] args) {
		
	}
}
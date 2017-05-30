/**
 *
 * 16.20 T9
 *     On old cell phones, users typed on a numeric keypad and the phone would provide a 
 *     list of words that matched these numbers. Each digit mapped to a set of 0 - 4 
 *     letters. Implement an algorithm to return a list of matching words, given a 
 *     sequence of digits. You are provided a list of valid words to return a list of 
 *     matching owrds, given a sequence of digits. You are provided a list of valid words 
 *     (provided in whatever data structure you'd like).
 *
 */
import java.util.*;
import java.io.*;

class T9 {
	private static char[][] letters = {
		{},
		{},
		{'a', 'b', 'c'},
		{'d', 'e', 'f'},
		{'g', 'h', 'i'},
		{'j', 'k', 'l'},
		{'m', 'n', 'o'},
		{'p', 'q', 'r', 's'},
		{'t', 'u', 'v'},
		{'w', 'x', 'y', 'z' }
	};
	private static HashMap<Character, Character> digitMap;
	
	private static HashMap<String, ArrayList<String>> wordsMap;
	
	public static ArrayList<String> getValidWords(String input) {
		if (wordsMap == null) {
			System.out.println("Preparing Dictionary.");
			wordsMap = new HashMap<String, ArrayList<String>>();
			prepareWords();
		}
		return wordsMap.get(input);
	}
	
	public static void prepareWords() {
		try {
			Scanner sc = new Scanner(new File("words"));
			digitMap = new HashMap<Character, Character>();
			for (int i = 0; i < letters.length; ++i) {
				char[] chars = letters[i];
				for (char c : chars) {
					digitMap.put(c, Character.forDigit(i, 10));
				}
			}
			while (sc.hasNext()) {
				String line = sc.nextLine();
				if (line.length() > 0) {
					String number = convertWordToNumber(line);
					ArrayList<String> list = wordsMap.getOrDefault(number, new ArrayList<String>());
					list.add(line);
					wordsMap.put(number, list);
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("NO FILE FOUND!!");
		}
	}
	
	public static String convertWordToNumber(String word) {
		StringBuilder sb = new StringBuilder();
		for (char c : word.toCharArray()) {
			sb.append(digitMap.get(c));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "INOUT";
		while (!input.equals("")) {
			input = sc.nextLine();
			System.out.println(input + ":\n" + getValidWords(input));
		}
	}
}
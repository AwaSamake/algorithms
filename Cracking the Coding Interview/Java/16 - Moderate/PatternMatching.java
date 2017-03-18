/**
 *
 * 16.18 Pattern Matching
 *     You are given two strings, pattern and value. The pattern string consists of just 
 *     the letters a and b, describing a pattern within a string. For example, the string 
 *     catcatgocatgo matches the pattern aabab (where cat is a and go is b). It also matches 
 *     patterns like a, ab, and b. Write a method to determine if value matches pattern.
 *
 */

class PatternMatching {
	public static boolean isMatch(String pattern, String value) {
		// if pattern is empty, value need to be empty to match
		if (pattern.length() == 0) {
			return value.length() == 0;
		}
		
		char mainChar = pattern.charAt(0);
		char altChar = (mainChar == 'a') ? 'b' : 'a';
		int size = value.length();
		
		int numOfMain = count(pattern, mainChar);
		int numOfAlt = count(pattern, altChar);
		int firstAlt = pattern.indexOf(altChar);
		int maxMainSize = size / numOfMain;
		
		// for each posible mainChar length
		for (int mainSize = 1; mainSize < maxMainSize; ++mainSize) {
			int remainingLength = size - mainSize * numOfMain;
			// first is the chars a maped to
			String first = value.substring(0, mainSize);
			// check size = mainPattern * numOfmain + altPattern * numOfAlt
			if (numOfAlt == 0 || remainingLength % numOfAlt == 0) {
				// first alt index is begin at the end of all mainChar pattern
				int altIndex = firstAlt * mainSize;
				int altSize = (numOfAlt == 0) ? 0 : remainingLength / numOfAlt;
				// second is the chars b maped to
				String second = (numOfAlt == 0) ? "" : value.substring(altIndex, altIndex + altSize);
				
				String candidate = buildFromPattern(pattern, first, second);
				if (candidate.equals(value)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static int count(String string, char ch) {
		int count = 0;
		for (char c : string.toCharArray()) {
			if (c == ch) {
				++count;
			}
		}
		return count;
	}
	
	public static String buildFromPattern(String pattern, String first, String  second) {
		StringBuilder sb = new StringBuilder();
		for (char c : pattern.toCharArray()) {
			sb.append((c == pattern.charAt(0) ? first : second));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aba", "catdogcat"));
	}
}
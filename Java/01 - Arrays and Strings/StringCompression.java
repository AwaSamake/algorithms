/**
 *
 * 1.6 String Compression
 *     Implement a method to perform basic string compression using the counts of
 *     repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 *     if the "compressed" string would not become smaller that the original string,
 *     your method should return the original string. You can assume the string has only
 *     uppercase and lowercase letter (a-z).
 *
 */
class StringCompression {
    String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); ++i) {
            count++;
            if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(str.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }
        return compressed.toString();
    }
    
	public static void main(String[] args) {
		
	}
}
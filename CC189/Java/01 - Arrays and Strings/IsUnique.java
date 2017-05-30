/**
 *
 * 1.1 Is Unique
 *     Implement an algorithm to determine if a string has all unique characters.
 *     What if you cannot use additional data structures?
 *
 */
class IsUnique {
    // When the char set of String contained in ASCII
    boolean isUnique1(String input) {
        if (input.length() > 128) { return false; }

        boolean[] isInInput = new boolean[128];
        for (char c : input.toCharArray()) {
            if (isInInput[c]) {
                return false;
            }
            isInInput[c] = true;
        }
        return true;
    }

    // When the char is only lower case letters
    boolean isUnique2(String input) {
        if (input.length() > 26) { return false; }
        int table = 0;
        for (char c : input.toCharArray()) {
            int value = c - 'a';
            int mask = 1 << value;
            if ((table & mask) > 0) {
                return false;
            }
            table |= mask;
        }
        return true;
    }
    
	public static void main(String[] args) {
		
	}
}
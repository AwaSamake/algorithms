/**
 *
 * 1.4 Palindrome Permutation
 *     Given a string, write a function to check if it is a permutation of a palindrome.
 *     A palindrome is a word or phrase that is the same forwards and backwards.
 *     A permutation is a rearrangement of letters.
 *     The palindrome does not need to be limited to just dictionary words
 *
 */
class PalindromePermutation {
    boolean isPermutationOfPalindrome1(String word) {
        int[] charCount = new int[128];
        for (char c : word.toCharArray()) {
            charCount[c]++;
        }
        boolean oddChar = false;
        for (int count : charCount) {
            if (count % 2 != 0) {
                if (oddChar) {
                    return false;
                }
                oddChar = true;
            }
        }
        return true;
    }

    boolean isPermutationOfPalindrome2(String word) {
        int table = 0;
        for (char c : word.toCharArray()) {
            int mask = 1 << (c - 'a');
            if ((mask & table) != 0) { // if this bit is on
                table &= ~mask; // set bit
            } else {
                table |= mask; // clear bit
            }
        }
        return checkEachBits(table);
    }
    
    // Helper bit manipulation functions
    // not efficient
    private boolean checkEachBits(int table) {
        boolean oddChar = false;
        for (int i = 0; i < 26; ++i) {
            int mask = 1 << i;
            if ((table & mask) > 0) {
                if (oddChar) {
                    return false;
                }
                oddChar = true;
            }
        }
        return true;
    }

    // more efficent
    // 00010000 - 1 = 00001111
    // 00010000 & 00001111 = 0
    private boolean checkBits(int table) {
        int val = table - 1;
        return (table & val) == 0;
    }
    
	public static void main(String[] args) {
		
	}
}
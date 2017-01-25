import java.util.Arrays;

/**
 * Created by lihao on 1/6/17.
 * Cracking the Coding Interview
 * Arrays and List
 */

public class QS01Arrays {
    /**
     *
     * 1.1 Is Unique
     *     Implement an algorithm to determine if a string has all unique characters.
     *     What if you cannot use additional data structures?
     *
     */

    // When the char set of String contained in ASCII
    boolean isUnique(String input) {
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
    boolean isUniqueLowerLetter(String input) {
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

    /**
     *
     * 1.2 Check Permutation
     *     Given two strings, write a method to decide if one is a permutation of the other.
     *
     */
    // Clean and easy to understand, not optimal
    boolean isPermutation(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return String.valueOf(arr1).equals(String.valueOf(arr2));
    }

    // When char set is ASCII, this will be more efficient
    boolean isPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) { return false; }

        int[] counter = new int[128];
        for (char c: s1.toCharArray()) {
            counter[c]++;
        }

        for (char c: s2.toCharArray()) {
            counter[c]--;
            if (counter[c] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 1.3 URLify
     *     Write a method to replace all spaces in a string with '%20'.
     *     You may assume that the string has sufficient space at the end to hold the
     *     additional characters, and that you are given the "true" length of string.
     *     (Note: If implementing in Java, please use a character array so that you can
     *     perform this operation in place.)
     *
     */
    void URLify(char[] input, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; ++i) {
            if (input[i] == ' ') {
                spaceCount++;
            }
        }
        if (spaceCount == 0) { return; }
        int end = trueLength + spaceCount * 2;
        input[end--] = '\0';
        int index = trueLength - 1;
        while (end >= 0) {
            if (input[index] == ' ') {
                input[end--] = '0';
                input[end--] = '2';
                input[end--] = '%';
                index--;
            } else {
                input[index--] = input[end--];
            }
        }
    }


    /**
     *
     * 1.4 Palindrome Permutation
     *     Given a string, write a function to check if it is a permutation of a palindrome.
     *     A palindrome is a word or phrase that is the same forwards and backwards.
     *     A permutation is a rearrangement of letters.
     *     The palindrome does not need to be limited to just dictionary words
     *
     */
    boolean isPermutationOfPalindrome(String word) {
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

    boolean isPermutationOfPalindromeLetterOnly(String word) {
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

    /**
     *
     * 1.5 One Away
     *     There are three types of edits that can be performed on strings:
     *     insert a character remove a character, or replace a character.
     *     Write a function to check if they are less or one edit (or zero edits) away.
     *
     */

    boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() - second.length() == 1) {
            return oneEditRemove(first, second);
        } else if (second.length() - first.length() == 1) {
            return oneEditRemove(second, first);
        }
        return false;
    }

    private boolean oneEditReplace(String first, String second) {
        boolean edited = false;
        for (int i = 0; i < first.length(); ++i) {
            if (first.charAt(i) != second.charAt(i)) {
                if (edited) {
                    return false;
                }
                edited = true;
            }
        }
        return true;
    }

    private boolean oneEditRemove(String longer, String shorter) {
        boolean jumped = false;
        for (int i = 0, j = 0; i < shorter.length(); ++i, ++j) {
            if (shorter.charAt(i) != longer.charAt(i)) {
                if (jumped) {
                    return false;
                }
                jumped = true;
                --j;
            }
        }
        return true;
    }

    /**
     *
     * 1.6 String Compression:
     *     Implement a method to perform basic string compression using the counts of
     *     repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
     *     if the "compressed" string would not become smaller that the original string,
     *     your method should return the original string. You can assume the string has only
     *     uppercase and lowercase letter (a-z).
     *
     */
    String comprese(String input) {
        StringBuilder temp = new StringBuilder();
        char curChar = input.charAt(0);
        int counter = 1;
        for (char c : input.substring(1).toCharArray()) {
            if (curChar == c) {
                counter++;
            } else {
                temp.append(curChar);
                temp.append(counter);
                if (temp.length() >= input.length()) {
                    return input;
                }
                counter = 1;
                curChar = c;
            }
        }
        temp.append(curChar);
        temp.append(counter);
        if (temp.length() >= input.length()) {
            return input;
        }
        return temp.toString();
    }


    /**
     *
     * 1.7 Rotate Matrix
     *     Given an image represented by an NxN matrix, where each pixel in the image is 4
     *     bytes, weite a method to rotate the image by 90 degrees.
     *     Can you do this in place?
     *
     */
    char[][] rotate(char[][] image) {

        return image;
    }

    /**
     *
     * 1.8 Zero Matrix
     *     Write an algorithm such that if an element in an MxN matrix is 0, its entire row
     *     and column are set to 0.
     *
     */
    int[][] zeroMatrix(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            if (rowZero[i]) {
                for (int c = 0; c < matrix[0].length; ++c) {
                    matrix[i][c] = 0;
                }
            }

        }
        for (int j = 0; j < matrix[0].length; ++j) {
            if (colZero[j]) {
                for (int r = 0; r < matrix.length; ++r) {
                    matrix[r][j] = 0;
                }
            }
        }
        return matrix;
    }


    /**
     *
     * 1.9 String Rotation
     *     Assume you have a method isSubstring which checks if one word is a substring of
     *     another.
     *     Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
     *     only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
     *
     */
    boolean isSubstring(String s1, String s2) {
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }

}

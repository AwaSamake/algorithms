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

class URLify {
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
    
	public static void main(String[] args) {
		
	}
}
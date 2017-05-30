/**
 *
 * 1.2 Check Permutation
 *     Given two strings, write a method to decide if one is a permutation of the other.
 *
 */
class CheckPermutation {
    boolean isPermutation1(String s1, String s2) {
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
    
	public static void main(String[] args) {
		
	}
}
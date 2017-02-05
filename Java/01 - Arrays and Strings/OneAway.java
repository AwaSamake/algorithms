/**
 *
 * 1.5 One Away
 *     There are three types of edits that can be performed on strings:
 *     insert a character remove a character, or replace a character.
 *     Write a function to check if they are less or one edit (or zero edits) away.
 *
 */
class OneAway {
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
    
	public static void main(String[] args) {
		
	}
}
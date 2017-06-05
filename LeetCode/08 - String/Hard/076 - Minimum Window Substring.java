/**
 *
 * 076. Minimum Window Substring
 *    Given a string S and a string T, find the minimum window in S which will contain
 *    all the characters in T in complexity O(n).
 *
 *    For example,
 *    S = "ADOBECODEBANC"
 *    T = "ABC"
 *    Minimum window is "BANC".
 *
 *    Note:
 *    If there is no such window in S that covers all characters in T, return the empty
 *    string "".
 *
 *    If there are multiple such windows, you are guaranteed that there will always be
 *    only one unique minimum window in S.
 *
 */

import java.util.*;

public class Solution {
    public String minWindow(String source, String target) {
        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];

        for (char c : target.toCharArray()) {
            targetHash[c]++;
        }

        int wanted = target.length();
        int minBegin = -1;
        int minEnd = source.length();
        int minLength = minEnd;
        int begin = 0;
        int end = minEnd;
        for (int i = 0; i < source.length(); ++i) {
            int hash = (int) source.charAt(i);
            sourceHash[hash]++;
            if (sourceHash[hash] <= targetHash[hash]) {
                wanted--;
            }
            if (wanted == 0) {
                end = i;
                while (sourceHash[source.charAt(begin)] > targetHash[source.charAt(begin)]) {
                    sourceHash[source.charAt(begin)]--;
                    begin++;
                }
                if (end - begin + 1 <= minLength) {
                    minLength = end - begin + 1;
                    minBegin = begin;
                    minEnd = end;
                }
                sourceHash[source.charAt(begin)]--;
                begin++;
                wanted++;
            }
        }
        if (minBegin == -1) {
            return "";
        }
        return source.substring(minBegin, minEnd + 1);
    }
}
/**
 *
 * 072. Edit Distance
 *    Given two words word1 and word2, find the minimum number of steps required to
 *    convert word1 to word2. (each operation is counted as 1 step.)
 *
 *    You have the following 3 operations permitted on a word:
 *
 *    a) Insert a character
 *    b) Delete a character
 *    c) Replace a character
 *
 */
import java.util.*;

// DFS Seach
public class Solution {
    public int minDistance(String word1, String word2) {
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        return minDistance(word1, word2, map);
    }

    public int minDistance(String word1, String word2, HashMap<String, HashMap<String, Integer>> map) {
        if (word1.equals(word2)) {
            return 0;
        }

        // check if we have compared two words already
        if (map.containsKey(word1)) {
            HashMap<String, Integer> counts = map.get(word1);
            if (counts.containsKey(word2)) {
                return counts.get(word2);
            }
        }
        if (map.containsKey(word2)) {
            HashMap<String, Integer> counts = map.get(word2);
            if (counts.containsKey(word1)) {
                return counts.get(word1);
            }
        }

        // skip same characters
        int i = 0;
        while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) {
            i++;
        }
        // if one reaches the end, rest of the length is the difference
        if (i == word1.length() || i == word2.length()) {
            return Math.abs(word1.length() - word2.length());
        }

        int minEdit = Integer.MAX_VALUE;
        // Three ways of counting edit
        // 1. remove one char from word1
        minEdit = Math.min(minEdit, minDistance(word1.substring(i + 1), word2.substring(i), map));
        // 2. remove one char from word2
        minEdit = Math.min(minEdit, minDistance(word1.substring(i), word2.substring(i + 1), map));
        // 3. remove one char from bothe (same as changing one char)
        minEdit = Math.min(minEdit, minDistance(word1.substring(i + 1), word2.substring(i + 1), map));
        // add this edit
        minEdit++;

        // same edits in map
        HashMap<String, Integer> counts = map.containsKey(word1) ? map.get(word1) : new HashMap<String, Integer>();
        counts.put(word2, minEdit);
        map.put(word1, counts);
        return minEdit;
    }
}

// Dynamic Programming
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length() + 1;
        int n = word2.length() + 1;
        int[][] edits = new int[m][n];
        for (int i = 0; i < m; ++i) {
            edits[i][0] = i;
        }
        for (int i = 0; i < n; ++i) {
            edits[0][i] = i;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    int removeCharFromWord1 = edits[i - 1][j];
                    int removeCharFromWord2 = edits[i][j - 1];
                    int removeCharFromBoth = edits[i - 1][j - 1];
                    edits[i][j] = 1 + Math.min(removeCharFromBoth, Math.min(removeCharFromWord1, removeCharFromWord2));
                }
            }
        }
        return edits[m - 1][n - 1];
    }
}
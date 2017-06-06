/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 17-06-06 01:19
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        if (word.length() < 1) {
            return true;
        }
        int m = board.length;
        if (m < 1) {
            return false;
        }
        int n = board[0].length;
        if (n < 1) {
            return false;
        }
        boolean[][] visited = new boolean[m][n];
        char[] chars = word.toCharArray();
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exist(board, chars, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, char[] word, boolean[][] visited, int i, int r, int c) {
        if (i >= word.length) {
            return true;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || board[r][c] != word[i]) {
            return false;
        }
        visited[r][c] = true;
        boolean found = false;
        found = found ? found : exist(board, word, visited, i + 1, r + 1, c    );
        found = found ? found : exist(board, word, visited, i + 1, r - 1, c    );
        found = found ? found : exist(board, word, visited, i + 1, r    , c + 1);
        found = found ? found : exist(board, word, visited, i + 1, r    , c - 1);
        visited[r][c] = false;
        return found;
    }
}
/**
 *
 * 079. Word Search
 *     Given a 2D board and a word, find if the word exists in the grid.
 *
 *     The word can be constructed from letters of sequentially adjacent cell, where
 *     "adjacent" cells are those horizontally or vertically neighboring. The same letter
 *     cell may not be used more than once.
 *
 *     For example,
 *     Given board =
 *
 *     [
 *       ['A','B','C','E'],
 *       ['S','F','C','S'],
 *       ['A','D','E','E']
 *     ]
 *     word = "ABCCED", -> returns true,
 *     word = "SEE", -> returns true,
 *     word = "ABCB", -> returns false.
 *
 */
import java.util.*;

class Solution {
	private static final int[] iBias = new int[] { -1,  1,  0,  0};
	private static final int[] jBias = new int[] { 0,  0,  1, -1};

	public boolean exist(char[][] board, String word) {
		char[] chars = word.toCharArray();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] == chars[0]) {
					visited[i][j] = true;
					if (search(board, visited, i, j, chars, 1)) {
						return true;
					}
					visited[i][j] = false;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] board, boolean[][] visited, int i, int j, char[] chars, int index) {
		if (index >= chars.length) {
			return true;
		}
		
		for (int direction = 0; direction < iBias.length; ++direction) {
			if (check(board, visited, i + iBias[direction], j + jBias[direction], chars[index])) {
				visited[i + iBias[direction]][j + jBias[direction]] = true;
				if (search(board, visited, i + iBias[direction], j + jBias[direction], chars, index + 1)) {
					return true;
				}
				visited[i + iBias[direction]][j + jBias[direction]] = false;
			}
		}
		return false;
	}

	private boolean check(char[][] board, boolean[][] visited, int i, int j, char key) {
		if (i < 0 || i >= board.length
				|| j < 0 || j >= board[i].length
				|| visited[i][j]) {
			return false;
		}
		return board[i][j] == key;
	}
}
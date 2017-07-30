import java.util.*;

class Solution {
	public boolean exist(char[][] board, String word) {
		int row = board.length;
		if (row == 0) {
			return false;
		}
		int col = board[0].length;
		if (col == 0) {
			return false;
		}
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (exist(board, word, visited, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean exist(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (visited[i][j]) {
			return false;
		}
		if (board[i][j] != word.charAt(index)) {
			return false;
		}
		visited[i][j] = true;
		if (exist(board, word, visited, i, j - 1, index + 1)
			|| exist(board, word, visited, i, j + 1, index + 1)
			|| exist(board, word, visited, i - 1, j, index + 1)
			|| exist(board, word, visited, i + 1, j, index + 1)) {
			return true;
		}
		visited[i][j] = false;
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println();
	}
}
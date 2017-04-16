/**
 *
 * 289. Game of Life
 *    According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 *    is a cellular automaton devised by the British mathematician John Horton Conway in 
 *    1970."
 *    
 *    Given a board with m by n cells, each cell has an initial state live (1) or dead (
 *    0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 *    using the following four rules (taken from the above Wikipedia article):
 *    
 *    Any live cell with fewer than two live neighbors dies, as if caused by 
 *    under-population.
 *    Any live cell with two or three live neighbors lives on to the next generation.
 *    Any live cell with more than three live neighbors dies, as if by over-population..
 *    Any dead cell with exactly three live neighbors becomes a live cell, as if by 
 *    reproduction.
 *    Write a function to compute the next state (after one update) of the board given 
 *    its current state.
 *    
 *    Follow up: 
 *    Could you solve it in-place? Remember that the board needs to be updated at the 
 *    same time: You cannot update some cells first and then use their updated values to 
 *    update other cells.
 *    In this question, we represent the board using a 2D array. In principle, the board 
 *    is infinite, which would cause problems when the active area encroaches the border 
 *    of the array. How would you address these problems?
 *
 */
import java.util.*;

public class Solution {
	static final int[] rows = new int[] {-1, -1, -1, 0 , 0, 1 , 1, 1};
	static final int[] cols = new int[] {-1, 0 , 1 , -1, 1, -1, 0, 1};
	
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				board[i][j] = liveOrDead(board, i, j);
			}
		}
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				if (board[i][j] > 1) {
					board[i][j] %= 2;
				}
			}
		}
	}
	
	public int getAliveNeighbors(int[][] board, int r, int c) {
		int count = 0;
		for (int i = 0; i < 8; ++i) {
			int row = r + rows[i];
			int col = c + cols[i];
			if (row > -1 && row < board.length && col > -1 && col < board[0].length 
				&& (board[row][col] == 1 || board[row][col] == 2 || board[row][col] == 3)) {
				count++;
			}
		}
		return count;
	}
	
	// 2 for dead 3 for live and original live
	// 4 for dead 5 for live and original dead
	public int liveOrDead(int[][] board, int r, int c) {
		int neighbors = getAliveNeighbors(board, r, c);
		if (board[r][c] == 0 || board[r][c] == 4 || board[r][c] == 5) {
			if (neighbors == 3) {
				return 5;
			} else {
				return 4;
			}
		} else if (board[r][c] == 1 || board[r][c] == 2 || board[r][c] == 3) {
			if (neighbors < 2 || neighbors > 3) {
				return 2;
			} else {
				return 3;
			}
		}
		return -1;
	}
}
/**
 *
 * 16.4 Tic Tac Win
 *     Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 *
 */

class TicTacWin {
	public static enum PIECE {EMPTY, RED, BLUE};
	
	public static PIECE whoWon(PIECE[][] board) {
		for (int i = 0; i < 3; ++i) {
			// check rows
			if (board[i][0] == board[i][1] == board[i][2]) {
				return board[i][0];
			}
			// check cols
			if (board[0][i] == board[1][i] == board[2][i]) {
				return board[0][i];
			}
			// check cross
			if (board[i][i] == board[i][i] == board[i][i]) {
				return board[0][i];
			}
			if (board[3 - i][i] == board[3 - i][i] == board[3 - i][i]) {
				return board[0][3 - i];
			}
		}
	}
	
	public static PIECE whoWon(PIECE[][] board, int row, int col) {
		
	}
		
	public static void main(String[] args) {
		
	}
}
/**
 *
 * 10.9 Sorted Matrix Search
 *     Given an M x N matrix in which each row and each column is sorted in ascending 
 *     order, write a method to find an element.
 *
 */
import java.util.*;

class MatrixPosition {
	public int row, col;
	
	public MatrixPosition(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

class SortedMatrixSearch {
	public static MatrixPosition search(int[][] matrix, int key) {
		int rowHigher = matrix.length - 1;
		int rowLower = 0;
		int rowMid = (rowLower + rowHigher) >> 1;
		int colHigher = matrix[0].length - 1;
		int colLower = 0;
		int colMid = (colHigher + colLower) >> 1;
		
		while (rowLower < rowHigher) {
			if (matrix[rowMid][colLower] <= key) {
				rowLower = rowMid + 1;
			} else {
				rowHigher = rowMid - 1;
			}
			rowMid = (rowLower + rowHigher) >> 1;
		}
		
		while (colLower < colHigher) {
			if (matrix[rowMid][colMid] == key) {
				return new MatrixPosition(rowMid, colMid);
			} else if (matrix[rowMid][colMid] < key) {
				colLower = colMid + 1;
			} else {
				colHigher = colMid -1;
			}
			colMid = (colHigher + colLower) >> 1;
		}
		return new MatrixPosition(-1, -1);
	}
	
	public static MatrixPosition binarySearch(int[][] matrix, int key) {
		int numOfCol = matrix[0].length;
		int lower = 0;
		int upper = matrix.length * numOfCol - 1;
		int mid;
		while (lower <= upper) {
			mid = (lower + upper) >> 1;
			if (matrix[mid / numOfCol][mid % numOfCol] == key) {
				return new MatrixPosition(mid / numOfCol, mid % numOfCol);
			} else if (matrix[mid / numOfCol][mid % numOfCol] < key) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
		return new MatrixPosition(-1, -1);
	}
	
	public static void main(String[] args) {
		
	}
}
/**
 *
 * 16.19 Pond Sizes
 *     You have an integer matrix representing a plot of land, where the value at that 
 *     location represents the height above sea level. A value of zero indicates water. 
 *     A pond is a region of water connected vertically, horizontally or diagonally. 
 *     The size of the pond is the total number of connected water cells. Write a method 
 *     to compute the sizes of all ponds in the matrix.
 *
 */
import java.util.*;

class PondSizes {
	public static ArrayList<Integer> getPondSizes(int[][] pond) {
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		boolean[][] visited = new boolean[pond.length][pond[0].length];
		for (int r = 0; r < pond.length; ++r) {
			for (int c = 0; c < pond[0].length; ++c) {
				if (pond[r][c] == 0) {
					int size = getPondSizeAt(pond, visited, r, c);
					if (size > 0) {
						sizes.add(size);
					}
				}
			}
		}
		return sizes;
	}
	
	public static int getPondSizeAt(int[][] pond, boolean[][] visited, int row, int col) {
		if (row < 0 || col < 0 || row >= pond.length || col >= pond[0].length || visited[row][col] || pond[row][col] != 0) {
			return 0;
		}
		
		int size = 1;
		visited[row][col] = true;
		for (int i = row - 1; i <= row + 1; ++i) {
			for (int j = col - 1; j <= col + 1; ++j) {
				size += getPondSizeAt(pond, visited, i, j);
			}
		}
		return size;
	}
	
	public static void main(String[] args) {
		int[][] pond = new int[][] {
			{0, 2, 1, 0},
			{0, 1, 0, 1},
			{1, 1, 0, 1},
			{0, 1, 0, 1}
		};
		
		ArrayList<Integer> sizes = getPondSizes(pond);
		
		System.out.println(sizes.toString());
		
	}
}
/**
 *
 * 1.7 Rotate Matrix
 *     Given an image represented by an NxN matrix, where each pixel in the image is 4
 *     bytes, weite a method to rotate the image by 90 degrees.
 *     Can you do this in place?
 *
 */
class RotateMatrix {
    boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length != matrix.length) { return false; }

        int n = matrix.length;
        for (int row = 0; row < n/2; ++row) {
            int last = n - row - 1;
            for (int i = row; i < last; i++) {
                int offset = i - row;
                int top = matrix[row][i];
                matrix[row][i]              = matrix[last - offset][row];
                matrix[last-offset][row]    = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last]             = top;
            }
        }
        return true;
    }
    
	public static void main(String[] args) {
		
	}
}
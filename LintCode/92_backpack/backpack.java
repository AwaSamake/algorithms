/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 17-05-30 06:16
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // create a matrix to store best case for each backpack size and each item
        int[][] matrix = new int[A.length][m + 1];
        // when there is only one item
        for (int size = 0; size <= m; ++size) {
            // if size is not enough, best we can do is 0
            if (size < A[0]) {
                matrix[0][size] = 0;
            } else { // when size is enough, best is the item size. we can only put each item once
                matrix[0][size] = A[0];
            }
        }
        // for item to last item
        for (int itemIndex = 1; itemIndex < A.length; ++itemIndex) {
            // for each bag size
            for (int bagSize = 1; bagSize <= m; ++bagSize) {
                int currentItemSize = A[itemIndex];
                // if bag size if smaller than the current item size
                if (bagSize < currentItemSize) {
                    // we can not put in the item, the best case is without the item
                    matrix[itemIndex][bagSize] = matrix[itemIndex - 1][bagSize];
                } else {
                    // case 1: not adding the current item
                    int withoutCurrentItem = matrix[itemIndex - 1][bagSize];
                    // case 2: adding the current item
                    int sizeLeft = bagSize - currentItemSize;
                    int bestCaseforLeftSize = matrix[itemIndex - 1][sizeLeft];
                    int withCurrentItem = currentItemSize + bestCaseforLeftSize;
                    
                    // chose the case we can get larger fulfill
                    matrix[itemIndex][bagSize] = Math.max(withCurrentItem, withoutCurrentItem);
                }
            }
        }
        // return the total size when all items are aviliable and bag size is m
        return matrix[A.length - 1][m];
    }
}
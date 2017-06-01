import java.util.*;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] sizes, int values[]) {
        int[][] bestCases = new int[sizes.length][m + 1];

        for (int bagSize = 0; bagSize <= m; ++bagSize) {
            int itemSize = sizes[0];
            int itemValue = values[0];
            if (bagSize < itemSize) {
                bestCases[0][bagSize] = 0;
            } else {
                bestCases[0][bagSize] = Math.max(bestCases[0][bagSize - itemSize], itemValue);
            }
        }
        
        for (int itemIndex = 1; itemIndex < sizes.length; ++itemIndex) {
            int itemSize = sizes[itemIndex];
            int itemValue = values[itemIndex];
            for (int bagSize = 1; bagSize <= m; ++bagSize) {
                if (bagSize < itemSize) {
                    bestCases[itemIndex][bagSize] = bestCases[itemIndex - 1][bagSize];
                } else {
                    int valueWithoutThisItem = bestCases[itemIndex - 1][bagSize];
                    int bagSizeWithThisItem = bagSize - itemSize;
                    int bestCaseWithSmallerBagSize = bestCases[itemIndex - 1][bagSizeWithThisItem];
                    int thisItemValue = values[itemIndex];
                    int valueWithThisItem = thisItemValue + bestCaseWithSmallerBagSize;
                    bestCases[itemIndex][bagSize] = Math.max(valueWithThisItem, valueWithoutThisItem);
                }
            }
        }
        return bestCases[sizes.length - 1][m];
    }
}

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] sizes, int values[]) {
        int[] bestCases = new int[m + 1];
        for (int bagSize = sizes[0]; bagSize <= m; ++bagSize) {
            bestCases[bagSize] = bestCases[bagSize - sizes[0]] + values[0];
        }
        for (int itemIndex = 1; itemIndex < sizes.length; ++itemIndex) {
            int itemSize = sizes[itemIndex];
            for (int bagSize = m; bagSize >= itemSize; --bagSize) {
                bestCases[bagSize] = Math.max(bestCases[bagSize - itemSize] + values[itemIndex], bestCases[bagSize]);
            }
        }
        return bestCases[m];
    }
}
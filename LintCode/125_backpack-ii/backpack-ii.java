/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/backpack-ii
@Language: Java
@Datetime: 17-05-30 21:27
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     */
    // public int backPackII(int m, int[] sizes, int values[]) {
    //     int[] bestCases = new int[m + 1];
    //     for (int bagSize = sizes[0]; bagSize <= m; ++bagSize) {
    //         bestCases[bagSize] = bestCases[bagSize - sizes[0]] + values[0];
    //     }
    //     for (int itemIndex = 1; itemIndex < sizes.length; ++itemIndex) {
    //         int itemSize = sizes[itemIndex];
    //         for (int bagSize = m; bagSize >= itemSize; --bagSize) {
    //             bestCases[bagSize] = Math.max(bestCases[bagSize - itemSize] + values[itemIndex], bestCases[bagSize]);
    //         }
    //     }
    //     return bestCases[m];
    // }
    
    // wrong answer
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int[] f = new int[m+1];
        for (int i = 0; i <=m ; ++i) f[i] = 0;
        int n = A.length , i, j;
        for(i = 0; i < n; i++){
            for(j = m; j >= A[i]; j--){
                if (f[j] < f[j - A[i]] + V[i])
                    f[j] = f[j - A[i]] + V[i];
            }
        }
        return f[m];
    }
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 17-05-28 00:24
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasLeft = 0;
        for (int i = 0; i < gas.length; i++) {
            gasLeft = 0;
            int station = 0;
            for (int j = 0; j < gas.length && gasLeft >= 0; ++j) {
                station = (i + j) % gas.length;
                gasLeft += gas[station];
                gasLeft -= cost[station];
            }
            if (gasLeft >= 0) {
                return i;
            }
            if (station < i) {
                return -1;
            }
            i = station;
        }
        return -1;
    }
}
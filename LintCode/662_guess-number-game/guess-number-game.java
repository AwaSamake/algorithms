/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/guess-number-game
@Language: Java
@Datetime: 17-06-11 06:15
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        int lower = 1;
        int higher = n;
        while (lower <= higher) {
            int mid = lower + ((higher - lower) >> 1);
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                higher = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return -1;
    }
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/max-points-on-a-line
@Language: Java
@Datetime: 17-05-26 06:36
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        if (points == null || points.length < 1) {
            return 0;
        }
        if (points.length < 3) {
            return points.length;
        }
        int max = Integer.MIN_VALUE;
        HashMap<Double, HashSet<Integer>> slopes = new HashMap<Double, HashSet<Integer>>();
        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i == j) {
                    continue;
                }
                double slop = 0;
                if (0.0 + points[j].x - points[i].x == 0.0) {
                    slop = Integer.MAX_VALUE;
                } else if (0.0 + points[j].y - points[i].y == 0.0) {
                    slop = 0;
                } else {
                    slop = (0.0 + points[j].y - points[i].y) / (0.0 + points[j].x - points[i].x);
                }
                HashSet<Integer> set = slopes.containsKey(slop) ? slopes.get(slop) : new HashSet<Integer>();
                set.add(i);
                set.add(j);
                slopes.put(slop, set);
            }
            for (HashSet<Integer> set: slopes.values()) {
                max = Math.max(max, set.size());
            }
            slopes.clear();
        }
        return max;
    }
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 17-05-31 22:05
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        if (intervals.size() < 1) {
            return merged;
        }
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        };
        Collections.sort(intervals, comparator);
        int start = intervals.get(0).start, end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                merged.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        merged.add(new Interval(start, end));
        return merged;
    }

}
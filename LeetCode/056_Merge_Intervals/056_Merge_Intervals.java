/**
 *
 * 056. Merge Intervals
 *    Given a collection of intervals, merge all overlapping intervals.
 *
 *    For example,
 *    Given [1,3],[2,6],[8,10],[15,18],
 *    return [1,6],[8,10],[15,18].
 *
 */

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
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
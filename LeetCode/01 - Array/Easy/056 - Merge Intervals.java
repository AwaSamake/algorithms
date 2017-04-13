/**
 *
 * 056. Merge Intervals
 *     Given a collection of intervals, merge all overlapping intervals.
 *     
 *     For example,
 *     Given [1,3],[2,6],[8,10],[15,18],
 *     return [1,6],[8,10],[15,18].
 *     
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
		boolean done = false;
		
		while (!done) {
			done = true;
			for (int i = 1; i < intervals.size(); ++i) {
				if ()
			}
			
		}
	}
	
	public boolean intersect(Interval a, Interval b) {
		if (a.start <= b.start && b.start <= a.end) {
			return true;
		}
		if (a.start <= b.end && b.end <= a.end) {
			return true;
		}
	}
	
	public Interval merge(Interval a, Interval b) {
		Interval interval = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
		return interval;
	}
}
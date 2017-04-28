/**
 *
 *  539. Minimum Time Difference
 *    Given a list of 24-hour clock time points in "Hour:Minutes" format, find the 
 *    minimum minutes difference between any two time points in the list.
 *    
 *    Example 1:
 *    Input: ["23:59","00:00"]
 *    Output: 1
 *    Note:
 *    The number of time points in the given list is at least 2 and won't exceed 20000.
 *    The input time is legal and ranges from 00:00 to 23:59. *
 */
import java.util.*;

class CustomTime implements Comparable<CustomTime> {
	public int hour, minute;
	
	public CustomTime(String timePoint) {
		String[] hourMinute = timePoint.split(":");
		
		this.hour = Integer.valueOf(hourMinute[0]);
		this.minute = Integer.valueOf(hourMinute[1]);
	}
	
	public int compareTo(CustomTime o) {
		if (hour != o.hour) {
			return hour - o.hour;
		} else {
			return minute = o.minute;
		}
	}
	
	public int getTimeBetween(CustomTime o) {
		int hourDifference1 = o.hour - hour;
		int minuteDifference1 = o.minute - minute;
		int totalDifference1 = Math.abs(hourDifference1 * 60 + minuteDifference1);
		
		int hourDifference2 = (o.hour + 24) - hour;
		int minuteDifference2 = o.minute - minute;
		int totalDifference2 = Math.abs(hourDifference2 * 60 + minuteDifference2);
		
		return Math.min(totalDifference1, totalDifference2);
	}
}

public class Solution {
	public int findMinDifference(List<String> timePoints) {
		Collections.sort(timePoints);
		int difference = Integer.MAX_VALUE;
		CustomTime[] times = new CustomTime[timePoints.size()];
		
		for (int i = 0; i < timePoints.size(); ++i) {
			times[i] = new CustomTime(timePoints.get(i));
		}
		
		for (int i = 0; i < times.length; ++i) {
			int next = (i + 1) % timePoints.size();
			difference = Math.min(difference, times[i].getTimeBetween(times[next]));
		}
		return difference;
	}
}
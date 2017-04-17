/**
 *
 * 228. Summary Ranges
 *    Given a sorted integer array without duplicates, return the summary of its ranges.
 *    
 *    For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *    
 */
import java.util.*;

class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums.length == 0) {
			return result;
		}
		ArrayList<Integer> ranges = new ArrayList<Integer>();
		int begin = 0, end = 0;
		while (end < nums.length - 1) {
			if (nums[end] + 1 == nums[end + 1]) {
				++end;
			} else {
				ranges.add(begin);
				ranges.add(end);
				begin = ++end;
			}
		}
		ranges.add(begin);
		ranges.add(end);
		
		convertRangeToString(result, ranges, nums);
		return result;
	}
	
	public void convertRangeToString(List<String> result, List<Integer> ranges, int[] nums) {
		for (int i = 0; i < ranges.size(); i += 2) {
			StringBuilder sb = new StringBuilder();
			if (ranges.get(i) == ranges.get(i + 1)) {
				sb.append(nums[ranges.get(i)]);
			} else {
				sb.append(nums[ranges.get(i)]);
				sb.append("->");
				sb.append(nums[ranges.get(i + 1)]);
			}
			result.add(sb.toString());
		}
	}
}
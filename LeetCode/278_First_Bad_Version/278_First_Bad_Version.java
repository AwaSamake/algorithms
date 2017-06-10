/**
 *
 * 278. First Bad Version
 *     You are a product manager and currently leading a team to develop a new product. 
 *     Unfortunately, the latest version of your product fails the quality check. Since 
 *     each version is developed based on the previous version, all the versions after a 
 *     bad version are also bad.
 *     Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad 
 *     one, which causes all the following ones to be bad.
 *     You are given an API bool isBadVersion(version) which will return whether version 
 *     is bad. Implement a function to find the first bad version. You should minimize 
 *     the number of calls to the API.
 * 
 */
import java.util.*;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
	public int firstBadVersion(int n) {
		if (isBadVersion(1)) {
			return 1;
		}
		if (!isBadVersion(n)) {
			return n;
		}
		int good = 1, bad = n, unknown;
		while (good < bad && bad - good > 1) {
			unknown = good + (bad - good) / 2;
			if (isBadVersion(unknown)) {
				bad = unknown;
			} else {
				good = unknown;
			}
		}
		return bad;
	}
}
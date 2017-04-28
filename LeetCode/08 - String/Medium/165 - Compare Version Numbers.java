/**
 *
 *  165. Compare Version Numbers
 *    Compare two version numbers version1 and version2.
 *    If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *    
 *    You may assume that the version strings are non-empty and contain only digits and the . character.
 *    The . character does not represent a decimal point and is used to separate number sequences.
 *    For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *    
 *    Here is an example of version numbers ordering:
 *    
 *    0.1 < 1.1 < 1.2 < 13.37
 *    
 */
import java.util.*;

public class Solution {
	public int compareVersion(String version1, String version2) {
		if (version1.equals(version2)) {
			return 0;
		} else if (version1.equals("")) {
			return -1;
		} else if (version2.equals("")) {
			return 1;
		}
		
		String[] versionStrings1 = version1.split("\\.");
		String[] versionStrings2 = version2.split("\\.");
		
		int index = 0;
		while (index < versionStrings1.length || index < versionStrings2.length) {
			String v1 = index < versionStrings1.length ? versionStrings1[index] : "0";
			String v2 = index < versionStrings2.length ? versionStrings2[index] : "0";
			int result = compare(v1, v2);
			if (result != 0) {
				return result;
			}
			index++;
		}
		return 0;
	}
	
	public int compare(String v1, String v2) {
		int num1 = Integer.valueOf(v1);
		int num2 = Integer.valueOf(v2);
		if (num1 < num2) {
			return -1;
		} else if (num1 > num2) {
			return 1;
		} else {
			return 0;
		}
	}
}
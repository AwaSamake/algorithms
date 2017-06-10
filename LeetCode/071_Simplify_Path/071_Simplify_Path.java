/**
 *
 * 071. Simplify Path
 *    Given an absolute path for a file (Unix-style), simplify it.
 *    
 *    For example,
 *    path = "/home/", => "/home"
 *    path = "/a/./b/../../c/", => "/c"
 *
 *    Output:
 *    "a"
 *    Note:
 *    All the strings in the input will only contain lower-case letters.
 *    The size of the dictionary won't exceed 1,000.
 *    The length of all the strings in the input won't exceed 1,000.
 *
 */
import java.util.*;

public class Solution {
	public String simplifyPath(String path) {
		String[] folders = path.split("/");
		Stack<String> simplifiedPath = new Stack<String>();
		for (String folder : folders) {
			if (!folder.equals(".")) {
				if (folder.equals("..")) {
					if (!simplifiedPath.isEmpty()) {
						simplifiedPath.pop();
					}
				} else if (!folder.equals("")) {
					simplifiedPath.push(folder);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		buildString(sb, simplifiedPath);
		return sb.length() < 1? "/" : sb.toString();
	}
	
	private void buildString(StringBuilder sb, Stack<String> path) {
		if (path.isEmpty()) {
			return;
		}
		String folder = path.pop();
		buildString(sb, path);
		sb.append("/");
		sb.append(folder);
	}
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/simplify-path
@Language: Java
@Datetime: 17-06-06 22:01
*/

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
		LinkedList<String> folders = new LinkedList<>();
		String[] dirs = path.split("/");
		for (String dir : dirs) {
			if (dir.equals(".") || dir.equals("")) {
				continue;
			}
			if (dir.equals("..")) {
				if (!folders.isEmpty()) {
					folders.removeLast();
				}
			} else {
				folders.add(dir);
			}
		}
		StringBuilder sb = new StringBuilder();
		if (path.charAt(0) == '/') {
			sb.append("/");
		}
		while (!folders.isEmpty()) {
			sb.append(folders.removeFirst());
			sb.append("/");
		}
		return sb.length() == 1 ? "/" : sb.substring(0, sb.length() - 1).toString();
	}
}
/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/left-pad
@Language: Java
@Datetime: 17-06-05 21:59
*/

public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuilder sb = new StringBuilder(size);
        
        for (int i = 0; i < size - originalStr.length(); ++i) {
            sb.append(padChar);
        }
        sb.append(originalStr);
        return sb.toString();
    }
}
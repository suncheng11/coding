package codingInterview.solution05;

import java.util.Objects;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution1 {
    public static String replaceSpace(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}

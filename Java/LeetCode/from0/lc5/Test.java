package lc5;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String s = "ac";

        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String input) {
        if(input.length() == 1){
            return input;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("#");
        for (int i = 0; i < input.length(); i++) {
            builder.append(input.charAt(i));
            builder.append("#");
        }

        String s = builder.toString();

        System.out.println(s);

        int maxMid = 1;
        int maxRight = 2;
        int maxRadisIndex = 1;
        int maxRadis = 1;

        int[] radis = new int[s.length()];

        for(int i = 1; i < s.length(); i ++){
            int tmp = 0;
            if (maxRight > i) {
                int op = maxMid * 2 - i;
//                tmp = spand(s, i, radis[op]);
                tmp = spand(s, i, Math.min(radis[op],maxRight-i));
            } else {
                tmp = spand(s, i,0);
            }
            if (i + tmp > maxRight) {
                maxRight = i + tmp;
                maxMid = i;
                radis[i] = tmp;
            }

            if (tmp > maxRadis) {
                maxRadis = tmp;
                maxRadisIndex = i;
            }
        }

        String tmpS = s.substring(maxRadisIndex-maxRadis,maxRadisIndex+maxRadis+1);
        System.out.println(tmpS);

        builder = new StringBuilder();
        for (int i = 0; i < tmpS.length(); i++) {
            if (tmpS.charAt(i) != '#') {
                builder.append(tmpS.charAt(i));
            }
        }
        return builder.toString();
    }

    /**
     * 中心扩展法求半径
     */
    private static int spand(String s, int midIndex,int border) {
        int ret = border;
        while (true) {
            int right = midIndex+ret+1;
            int left = midIndex-ret-1;
            if (right >= s.length() || left < 0) {
                return ret;
            }
            if (s.charAt(right) != s.charAt(left)) {
                return ret;
            }
            ret++;
        }
    }
}

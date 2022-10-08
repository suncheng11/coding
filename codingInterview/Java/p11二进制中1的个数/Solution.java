package p11二进制中1的个数;

/**
 * @Classname Solution
 * @Description 二进制中1的个数
 * @Date 2019/12/17 20:06
 * @Created by Cheng
 */
public class Solution {
    /**
     * 转字符串
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int ret = 0;
        String binaryString = Integer.toBinaryString(n);
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i)=='1')
                ret++;
        }
        return ret;
    }

    /**
     * 库函数
     * @param n
     * @return
     */
    public int NumberOf1E2(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 位运算
     * @param n
     * @return
     */
    public int NumberOf1E3(int n) {
        int ret = 0;
        while (n != 0) {
            ret++;
            n = n & (n - 1);
        }
        return ret;
    }
}

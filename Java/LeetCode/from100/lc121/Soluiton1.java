package lc121;

import java.util.Arrays;

/**
 * 最大子数组：分治算法
 */
public class Soluiton1 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int ret = 0;
        if (prices.length <= 1) {
            return ret;
        }

        //数组之差值含义
        int[] add = new int[prices.length];
        add[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            add[i] = prices[i] - prices[i - 1];
        }

        System.out.println("add array:"+ Arrays.toString(add));
        return Math.max(ret, dccToGetBiggestSubArray(add, 0, add.length - 1));
    }

    private static int dccToGetBiggestSubArray(int[] add, int start, int end) {
        if (start == end) {
            return add[start];
        }

        int mid = (end + start) / 2;
        int leftMax = dccToGetBiggestSubArray(add, start, mid);
        int rightMax = dccToGetBiggestSubArray(add, mid + 1, end);
        int crossMidMax = getCrossMidMax(add, start, mid, end);

        System.out.println("start:"+start+" mid:"+mid+" end:"+end);
        System.out.println("left:"+leftMax+" right:"+rightMax+" cross:"+crossMidMax);

        return Math.max(crossMidMax, Math.max(leftMax, rightMax));
    }

    private static int getCrossMidMax(int[] add, int start, int mid, int end) {
        int tmp = add[mid];
        int leftMax = add[mid];
        int rightMax = add[mid];
        for (int i = mid; i <= end; i++) {
            tmp += add[i];
            rightMax = Math.max(rightMax, tmp);
        }
        tmp = 0;

        for (int i = mid; i >= start; i--) {
            tmp += add[i];
            leftMax = Math.max(leftMax, tmp);
        }

        return leftMax + rightMax - add[mid];
    }
}

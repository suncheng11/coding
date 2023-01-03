package lc53;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int item : nums){
            sum+=item;
            max = Math.max(sum,max);
            if(sum < 0){
                sum = 0;
            }
        }

        return max;
    }
}
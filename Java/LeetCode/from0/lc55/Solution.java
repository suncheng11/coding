package lc55;

public class Solution {
    public boolean canJump(int[] nums) {
        int next = nums.length-1;
        for(int i = nums.length-2; i>=0;i--){
            if(nums[i]+i>=next){
                next = i;
            }
        }
        return next == 0;
    }
}
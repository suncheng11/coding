package lc55;

public class Solution2 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int maxR = 0;
        for(int i = 0; i<nums.length-1; i++){
            if(i>maxR){
                return false;
            }
            maxR = Math.max(maxR,nums[i]+i);
            // System.out.println(maxR);
            if(maxR>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
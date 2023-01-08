package from2500.lc2527;

public class Solution {
    public int xorBeauty(int[] nums) {
        int ret = 0;
        for(int item : nums){
            ret ^= item;
        }
        return ret;
    }
}
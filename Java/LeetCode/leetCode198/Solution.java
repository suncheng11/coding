class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length < 2){
            return nums[0];
        }

        int[][] records = new int[nums.length][2];

        records[0][0] = 0;
        records[0][1] = nums[0];

        for(int i = 1; i < nums.length; i ++){
            records[i][0] = Math.max(records[i-1][0],records[i-1][1]);
            records[i][1] = records[i-1][0] + nums[i];
        }

        return Math.max(records[nums.length-1][0],records[nums.length-1][1]);
    }
}
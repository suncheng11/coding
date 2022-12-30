package lc697;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        if(nums == null ||  nums.length == 0){
            return 0;
        }

        int[] numCntMap = new int[50000];
        int[] numStartMap = new int[50000];

        int maxDegree = Integer.MIN_VALUE;
        int ret = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            int item = nums[i];
            if(numStartMap[item] == 0){
                numStartMap[item] = i+1;
            }
            int cnt = (numCntMap[item]+=1);

            if(cnt > maxDegree){
                ret = Integer.MAX_VALUE;
            }
            
            maxDegree = Math.max(maxDegree,cnt);
            if(cnt == maxDegree){
                ret = Math.min(ret,i+1-numStartMap[item]+1);
            }
        }

        return ret;
    }
} 

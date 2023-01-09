package from1800.lc1806;

public class Solution {
    public int reinitializePermutation(int n) {
        int[] nums = new int[n];
        for(int i = 0 ;i < nums.length; i++){
            nums[i] = i;
        }

        int cnt = 0;
        while(true){
            int[] tmp = new int[n];
            cnt++;
            for(int i = 0; i < nums.length; i++){
                if(i%2 == 0){
                    tmp[i] = nums[i/2];
                }else{
                    tmp[i] = nums[n/2 + (i-1)/2];
                }
            }
            // System.out.println(Arrays.toString(tmp));
            boolean got = gotIt(tmp);
            // System.out.println(got);
            if(got){
                return cnt;
            }
            nums = tmp;
        }
    }

    private boolean gotIt(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return false;
            }
        }
        return true;
    }
} 
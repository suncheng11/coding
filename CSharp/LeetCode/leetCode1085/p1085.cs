public class Solution {
    public int SumOfDigits(int[] nums) {
        int min = GetMin(nums);
        int sum = 0;
        while(min!=0){
            sum += (min%10);
            min /= 10;
        }
        return sum%2==0?1:0;
    }

    public int GetMin(int[] nums){
        int ret = nums[0];
        foreach(int item in nums){
            if(item < ret){
                ret = item;
            }
        }
        return ret;
    }
}
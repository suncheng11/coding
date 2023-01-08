package codingInterview.solution03;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
    public static int findRepeatNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int j = i;
            while(nums[j]!=j){
                if(nums[nums[j]] == nums[j]){
                    return nums[j];
                }
                swap(nums,j,nums[j]);
            }
        }
        return 0;
    }

    private static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

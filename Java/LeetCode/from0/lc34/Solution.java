package lc34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = bSearch(nums,target);
        if(index == -1){
            return new int[]{-1,-1};
        }
        int left = index, right = index;
        while(left-1 >= 0 && nums[left-1] == target){
            left--;
        }
        while(right+1 < nums.length && nums[right+1] == target){
            right++;
        }
        return new int[]{left,right};
    }
    private int bSearch(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length-1;
        while(l <= r){
            int mid = (l+r)>>>1;
            if(target<nums[mid]){
                r = mid - 1;
            }else if(target > nums[mid]){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
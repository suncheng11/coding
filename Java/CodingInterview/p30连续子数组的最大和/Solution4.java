package p30连续子数组的最大和;

/**
 * @Classname Solution4
 * @Description TODO
 * @Date 2019/12/24 15:14
 * @Author Cheng
 */
public class Solution4 {
    /**
     * 诡异的分治算法，O（nlogn）
     * 有些地方需要根据返回值是否可以为空来做出调整
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private static int maxSubArray(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
//            if(nums[l]>0)
//                return nums[l];
//            else
//                return 0;//子序列可以选空串
        }

        int mid = (l+r)>>>1;
        int maxLeftSum = maxSubArray(nums, l, mid);
        int maxRightSum = maxSubArray(nums, mid + 1, r);

        //这个地方，要根据情况判断是否可以为0。如果字串可以为空，那就可以为0
        int maxLeftBorderSum = nums[mid],maxRightBorderSum=nums[mid+1];
        int temp = 0;
        for (int i = mid; i >=l ; i--) {
            temp+=nums[i];
            maxLeftBorderSum = Math.max(temp, maxLeftBorderSum);
        }
        temp = 0;
        for (int i = mid+1; i <=r ; i++) {
            temp+=nums[i];
            maxRightBorderSum = Math.max(temp, maxRightBorderSum);
        }
        return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);
    }
}

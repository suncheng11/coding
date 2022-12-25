package package0.solution11;

/**
 * 双指针：指针起点的多样性
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int ret = (right - left) * Math.min(height[right], height[left]);

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            int tmp = (right - left) * Math.min(height[right], height[left]);
            ret = Math.max(ret, tmp);
        }
        return ret;
    }
}

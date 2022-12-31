package lc11;

/**
 * 双指针：指针起点的多样性
 */
public class Solution2 {
   // public int maxArea(int[] height) {
    //     int ret = 0;
    //     int l=0,r=height.length-1;
    //     while(l<r){
    //         ret = Math.max((r-l)*Math.min(height[l],height[r]),ret);
    //         if(height[l] < height[r]){
    //             l++;
    //         }else{
    //             r--;
    //         }
    //     }
    //     return ret;
    // }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ? 
                Math.max(res, (j - i) * height[i++]): 
                Math.max(res, (j - i) * height[j--]); 
        }
        return res;
    }
}

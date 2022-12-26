package lc11;

/**
 * 尝试分治算法：fail
 */
public class Solution1Failed {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,25,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        if(height.length == 2){
            return Math.min(height[0],height[1]);
        }
        return dcc(height, 0, height.length-1);
    }

    private static int dcc(int[] height, int start, int end) {
        if (start == end) {
            return 0;
        }

        if(end-start == 1){
            return Math.min(height[start], height[end]);
        }

        int mid = (start+end)/2;
        int leftRet = dcc(height, start, mid);
        int rightRet = dcc(height, mid, end);
        int crossRet = getCrossRet(height, start, mid, end);

        System.out.println("start:"+start+" mid:"+mid+" end:"+end);
        System.out.println("leftRet:"+leftRet+" rightRet:"+rightRet+" crossRet:"+crossRet);
        return Math.max(crossRet, Math.max(leftRet, rightRet));
    }

    private static int getCrossRet(int[] height, int start, int mid, int end) {
        int right = mid;
        int left = mid;

        int tmp = 0;

        for(int i = mid; i <= end; i ++){
            if(height[i]*(i-mid) > tmp){
                tmp = height[i]*(i-mid);
                right = i;
            }
        }

        tmp = 0;
        for(int i = mid; i >= start; i --){
            if(height[i]*(mid-i) > tmp){
                tmp = height[i]*(mid-i);
                left = i;
            }
        }

        return (right - left) * Math.min(height[left], height[right]);
    }
}

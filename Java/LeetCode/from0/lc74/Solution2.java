package lc74;

public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = bSearchGetRow(matrix,target);
        if(row >= matrix.length){
            return false;
        }
        int col = bSearchGetCol(matrix[row],target);
        return col >= 0 && matrix[row][col] ==target;
    }
    private int bSearchGetRow(int[][] matrix,int target){
        int l = 0,h=matrix.length;
        int cols = matrix[0].length;
        while(l < h){
            int mid = (l + h )>>>1;
            if(matrix[mid][cols-1] >= target){
                h = mid;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }

    private int bSearchGetCol(int[] nums, int target){
        int l = -1, r = nums.length-1;
        while(l < r){
            int mid =(l+1+r)>>1;
            if(target >= nums[mid]){
                l = mid;
            }else{
                r = mid-1;
            }
            
        }
        return l;
    }
} 
package lc74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        for(int row = 0; row < rows; row++){
            if(matrix[row][cols-1] == target){
                return true;
            }
            if(matrix[row][cols-1]>target){
                for(int item : matrix[row]){
                    if(item == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
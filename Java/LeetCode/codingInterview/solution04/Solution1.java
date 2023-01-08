package codingInterview.solution04;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19}
        };

        System.out.println(findNumberIn2DArray(nums, 190));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }

            //index合法性判断要放在前面，要不然会数组越界
            while (col >= 0 && row < matrix.length && matrix[row][col] > target) {
                col--;
            }

            while (col >= 0 && row < matrix.length && matrix[row][col] < target) {
                row++;
            }
        }
        return false;
    }
}

package leetCode750;

class Solution {
    public int countCornerRectangles(int[][] grid) {
        if(grid.length <2 || grid[0].length<2){
            return 0;
        }

        int cnt = 0;

        for(int row = 0; row < grid.length; row ++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col]!=1){
                    continue;
                }
                for(int topRignt = col+1; topRignt < grid[row].length; topRignt++){
                    if(grid[row][topRignt]!=1){
                        continue;
                    }

                    for(int bottomLeft = row +1; bottomLeft < grid.length; bottomLeft++){
                        if(grid[bottomLeft][col]!=1){
                            continue;
                        }

                        if(grid[bottomLeft][topRignt] ==1 ){
                            cnt++;
                        }
                    }

                }

            }
        }

        return cnt;
    }
}

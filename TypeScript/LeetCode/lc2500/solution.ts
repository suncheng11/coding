function deleteGreatestValue(grid: number[][]): number {
    var ret = 0;
    var rows = grid.length;
    for(var i = 0; i < rows; i++){
        grid[i].sort((a,b)=>a-b);
    }

    for(var col = 0;  col < grid[0].length; col++){
        var maxValueCol = 0;
        for(var row = 0; row < rows; row++){
            maxValueCol = Math.max(maxValueCol,grid[row][col]);
        }
        ret += maxValueCol;
    }

    return ret;
};
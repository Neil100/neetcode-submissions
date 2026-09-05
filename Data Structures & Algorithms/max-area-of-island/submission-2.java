class Solution {
    int numRows, numColumns;
    int[][] directionCounters = {{1,0}, {0,1}, {-1,0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        numRows = grid.length;
        numColumns = grid[0].length;

        int sol=0;

        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numColumns; j++) {
                if(grid[i][j]==1) {
                    sol = Integer.max(sol, markIsland(grid, i, j));
                }
            }
        }
        return sol;
    }

    int markIsland(int[][] grid, int i, int j) {
        int area = 1;
        grid[i][j] = 2;
        for(int index=0; index<4; index++) {
            int row = i+directionCounters[index][0];
            int column = j+directionCounters[index][1];

            if(row>=0 && column>=0 && row<numRows && column<numColumns && grid[row][column]==1) {
                area = area + markIsland(grid, row, column);
            }
        }

        return area;
    }
}

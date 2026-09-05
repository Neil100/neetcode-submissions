class Solution {
    int numRows, numColumns;
    int[][] directionCounter = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numColumns = grid[0].length;
        int sol=0;
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numColumns; j++) {
                if(grid[i][j]=='1') {
                    markTheIsland(grid, i, j);
                    sol++;
                }
            }
        }

        return sol;
    }

    void markTheIsland(char[][] grid, int i, int j) {
        grid[i][j]='2';
        for(int iIndex = 0; iIndex<4; iIndex++) {
            int row = i + directionCounter[iIndex][0];
            int column = j + directionCounter[iIndex][1];

            if(row>=0 && column>=0 && row<numRows && column<numColumns && grid[row][column]=='1') {
                markTheIsland(grid, row, column);
            }
        }
    }
}

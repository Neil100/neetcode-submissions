class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int m, n;
    boolean[][] atlantic;
    boolean[][] pacific;
    List<List<Integer>> sol;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];

        sol = new ArrayList<>();
        for(int r=0; r<m; r++) {
            checkOceanConnection(r, 0, heights, pacific);

            checkOceanConnection(r, n-1, heights, atlantic);
        }

        for(int c=0; c<n; c++) {
            checkOceanConnection(0, c, heights, pacific);

            checkOceanConnection(m-1, c, heights, atlantic);
        }

        // for(int i=0; i<m; i++) {
        //     for(int j=0; j<n; j++) {
        //         if(pacific[i][j] && atlantic[i][j]) {
        //             List<Integer> list = new ArrayList<>();
        //             list.add(i);
        //             list.add(j);
        //             sol.add(list);
        //         }
        //     }
        // }

        return sol;
    }

    void checkOceanConnection(int r, int c, int[][] heights, boolean[][] grid) {
        if(grid[r][c]==false && (pacific[r][c] || atlantic[r][c])) {
            grid[r][c]=true;
            List<Integer> list = new ArrayList<>();
            list.add(r);
            list.add(c);
            sol.add(list);
        }
        grid[r][c]=true;


        for(int i=0; i<4; i++) {
            int newI = r + dir[i][0];
            int newJ = c + dir[i][1];

            if(newI>=0 && newI<m && newJ>=0 && newJ<n && heights[newI][newJ]>=heights[r][c] && !grid[newI][newJ]) {
                checkOceanConnection(newI, newJ, heights, grid);
            }
        }
    }
}

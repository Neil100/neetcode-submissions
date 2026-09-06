class Solution {
    public int orangesRotting(int[][] grid) {
        int numRows = grid.length, numColumns = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int numFresh = 0;
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numColumns; j++) {
                if(grid[i][j]==1) {
                    numFresh++;
                } else if(grid[i][j]==2) {
                    que.add(new int[]{i, j});
                }
            }
        }
        if(numFresh==0)
            return 0;
        int minutesRequired = 0;
        int width = que.size();
        int counter = 0;
        while(que.size()!=0) {
            int[] current = que.poll();
            
            for(int i=0; i<4; i++) {
                int newI = current[0]+dir[i][0];
                int newJ = current[1]+dir[i][1];

                if(newI>=0 && newJ>=0 && newI<numRows && newJ<numColumns && grid[newI][newJ]==1) {
                    numFresh--;
                    grid[newI][newJ] = 2;
                    que.add(new int[]{newI, newJ});
                }
            }
            counter++;
            if(counter==width) {
                minutesRequired++;
                counter=0;
                width = que.size();
            }
        }

        if(numFresh>0) {
            return -1;
        }

        return minutesRequired-1;
    }
}

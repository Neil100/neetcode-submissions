class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int numRows = grid.length, numColumns = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numColumns; j++) {
                if(grid[i][j] == 0) {
                    int[] indices = {i, j};
                    que.add(indices);
                }
            }
        }

        int width = que.size();
        int distance = 0;
        int counter=0;
        while(que.size()!=0) {
            int[] element = que.poll();
            if(grid[element[0]][element[1]]==0 || grid[element[0]][element[1]] > distance) {
                grid[element[0]][element[1]] = distance;
                for(int i=0; i<4; i++) {
                    int newI = element[0] + dir[i][0];
                    int newJ = element[1] + dir[i][1];

                    if(newI>=0 && newJ>=0 && newI<numRows && newJ<numColumns && grid[newI][newJ]!=-1 && grid[newI][newJ]!=0) {
                        que.add(new int[]{newI, newJ});
                    }
                }
            }
            counter++;

            if(counter==width) {
                distance++;
                counter=0;
                width = que.size();
            }
        }
    }
}

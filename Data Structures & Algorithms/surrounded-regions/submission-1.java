class Solution {
    boolean[][] isNotSurrounded;
    int numRows, numColumns;
    int[][] dir = {{1,0}, {0,1}, {0,-1}, {-1,0}};
    public void solve(char[][] board) {
        numRows = board.length;
        numColumns = board[0].length;
        isNotSurrounded = new boolean[numRows][numColumns];

        for(int c=0; c<numColumns; c++) {

            if(board[0][c]=='O')
                markNotSurroundedRegions(board, 0, c);
            
            if(board[numRows-1][c]=='O')
                markNotSurroundedRegions(board, numRows-1, c);
        }

        for(int r=0; r<numRows; r++) {
            if(board[r][0]=='O')
                markNotSurroundedRegions(board, r, 0);

            if(board[r][numColumns-1]=='O')
                markNotSurroundedRegions(board, r, numColumns-1);
        }

        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numColumns; j++) {
                if(!isNotSurrounded[i][j] && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }

    void markNotSurroundedRegions(char[][] board, int r, int c) {
        isNotSurrounded[r][c] = true;

        for(int i=0; i<4; i++) {
            int newI = r + dir[i][0];
            int newJ = c + dir[i][1];

            if(newI>=0 && newI<numRows && newJ>=0 && newJ<numColumns && !isNotSurrounded[newI][newJ] && board[newI][newJ]=='O') {
                markNotSurroundedRegions(board, newI, newJ);
            }
        }
    }
}

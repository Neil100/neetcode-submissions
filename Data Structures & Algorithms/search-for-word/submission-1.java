class Solution {
    int n, m;
    boolean[][] tracePath;
    int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        
        tracePath = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(findWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean findWord(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) {
            return true;
        }

        if (i<0 || j<0 || i>=n || j>=m || tracePath[i][j]) {
            return false;
        }
        if(board[i][j] == word.charAt(index)) {
            tracePath[i][j] = true;
            for(int ii=0; ii<4; ii++) {
                int newI = i+dir[ii][0];
                int newJ = j+dir[ii][1];

                // if() {
                    if(findWord(board, newI, newJ, word, index+1)) {
                        return true;
                    }
                // }
            }

            tracePath[i][j] = false;
        }
        
        return false;
    }
}

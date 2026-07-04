class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9];
        int[] column = new int[9];
        int[] box = new int[9];

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j]!='.') {
                    int num = (int) (board[i][j]-'0');
                    if((row[i] & (1 << num))!=0)
                        return false;
                    row[i] = row[i] | 1<<num;

                    if((column[j] & (1 << num))!=0)
                        return false;
                    column[j] = column[j] | 1<<num;

                    int index = ((3*(i%3)) + (j%3) + (9*(j/3)) + (27*(i/3))) / 9;

                    if((box[index] & (1 << num))!=0)
                        return false;
                    box[index] = box[index] | 1<<num;
                }
            }
        }

        return true;
    }
}

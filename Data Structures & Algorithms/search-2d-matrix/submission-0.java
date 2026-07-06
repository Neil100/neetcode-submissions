class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row=-1;
        int top = 0, bottom = matrix.length-1;

        while(top<=bottom) {
            int mid = (bottom-top) / 2 + top;

            if(matrix[mid][0]>target) {
                bottom = mid-1;
            } else if(matrix[mid][matrix[0].length-1]<target) {
                top = mid+1;
            } else {
                row = mid;
                break;
            }
        }

        if(row==-1)
            return false;

        int left = 0, right = matrix[0].length-1;
        // int column = -1;
        while(left<=right) {
            int mid = (right - left) / 2 + left;

            if(matrix[row][mid]==target) {
                return true;
            } else if(matrix[row][mid]>target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }
}

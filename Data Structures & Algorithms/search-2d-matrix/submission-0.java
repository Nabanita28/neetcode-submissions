class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int  l = 0;
        int r = matrix.length * matrix[0].length - 1;
        int row = 0;
        int col = 0;
        int cols = matrix[0].length;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            row = mid/cols;
            col = mid % cols;
            if(matrix[row][col] == target){
                return true;
            } else if(matrix[row][col] < target){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}

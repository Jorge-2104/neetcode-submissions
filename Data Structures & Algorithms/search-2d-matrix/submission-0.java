class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        int numCols = matrix[0].length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / numCols;
            int col = mid % numCols;
            int current = matrix[row][col];

            if (current < target) left = mid + 1;
            else if (current > target) right = mid - 1;
            else return true;
        }

        return false;
    }
}

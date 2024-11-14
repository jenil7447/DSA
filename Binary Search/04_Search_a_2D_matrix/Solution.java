class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix == null || matrix.length == 0) return false;
            if (matrix[0].length == 0) return false;

            int rows = matrix.length;
            int columns = matrix[0].length;
            int start = 0;
            int end = rows * columns - 1;
            
            while(start <= end){
                int mid = start + (end-start)/2;

                int row = mid / columns;
                int col = mid % columns;

                if(matrix[row][col] == target) return true;
                else if (matrix[row][col] > target ) end = mid - 1;
                else start = mid + 1;

            }
            return false;

    }
}

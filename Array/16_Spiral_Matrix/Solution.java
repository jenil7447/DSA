class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        if(matrix.length == 0){
            return li;
        }

        int rowStart = 0, rowEnd = matrix.length-1;
        int colStart = 0, colEnd = matrix[0].length-1;
        
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int j=colStart ; j<=colEnd ; j++){
                li.add(matrix[rowStart][j]);
            }
            rowStart++;

            for(int i=rowStart ; i<=rowEnd ; i++){
                li.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowStart <= rowEnd){
                for(int i=colEnd ; i>=colStart ; i--){
                    li.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colStart <= colEnd){
                for (int j=rowEnd ; j>=rowStart ; j--) {
                    li.add(matrix[j][colStart]);
                }
            }
            colStart++;
        }
        return li;
    }
}
----------------------------------------------------------------------------------------------------------------------------

  Time complexity : O( m * n ),//where m is the number of rows and n is the number of columns. Each element is visited exactly once.
  Space Complexity : O( m * n )// for the output list, which holds all elements of the matrix.
-----------------------------------------------------------------------------------------------------------------------------------
//   Approach
// -------------Initialization-
// A list li is created to store the elements in spiral order.
// Four boundaries are initialized:
                                 // rowStart and rowEnd to define the top and bottom boundaries of rows.
                                 // colStart and colEnd to define the left and right boundaries of columns.
  
// Spiral Traversal Using Boundaries:
// The main idea is to use a while loop to iterate as long as rowStart <= rowEnd and colStart <= colEnd, which ensures that we stay within the matrix bounds.
// Inside the loop, four for loops are used to traverse the matrix in four directions (right, down, left, up), adjusting boundaries after each traversal.
  
// Step-by-Step Traversal:
// Traverse from Left to Right across the top boundary (from colStart to colEnd):
// Add each element in matrix[rowStart][j] to the list.
  
// After traversing, increment rowStart to move the top boundary down, as this row is fully traversed.
// Traverse from Top to Bottom along the right boundary (from rowStart to rowEnd):
// Add each element in matrix[i][colEnd] to the list.
  
// After traversing, decrement colEnd to move the right boundary left, as this column is fully traversed.
// Traverse from Right to Left along the bottom boundary (from colEnd to colStart):
// This traversal is conditional on rowStart <= rowEnd to ensure there are rows left to traverse.
// Add each element in matrix[rowEnd][i] to the list.
  
// After traversing, decrement rowEnd to move the bottom boundary up.
// Traverse from Bottom to Top along the left boundary (from rowEnd to rowStart):
// This traversal is conditional on colStart <= colEnd to ensure there are columns left to traverse.
// Add each element in matrix[j][colStart] to the list.
  
// After traversing, increment colStart to move the left boundary right.
  
// End Condition:
// The while loop continues until either rowStart > rowEnd or colStart > colEnd, meaning the entire matrix has been traversed in spiral order.
// Return the Result:

// The list li, containing all matrix elements in spiral order, is returned as the final result.


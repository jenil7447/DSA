import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                
                if (current == '.') {
                    continue;
                }
                
                
                if (!set.add(current + " in row " + i) || 
                    !set.add(current + " in column " + j) || 
                    !set.add(current + " in block " + i / 3 + "-" + j / 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}

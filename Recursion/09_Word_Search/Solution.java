class Solution {
    public boolean exist(char[][] board, String word) {
    int row = board.length;
    int col = board[0].length;
    for(int i = 0 ; i < row ; i++){
        for(int j = 0 ; j < col ; j++){
            if(wordExist(board, word, i, j, 0)){
                return true;
            }
        }
    }
    return false;
    }
    boolean wordExist(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';

         boolean found = wordExist(board, word, i - 1, j, index + 1) || 
                        wordExist(board, word, i + 1, j, index + 1) || 
                        wordExist(board, word, i, j - 1, index + 1) || 
                        wordExist(board, word, i, j + 1, index + 1);

       
        board[i][j] = temp;

        return found;
    }
}

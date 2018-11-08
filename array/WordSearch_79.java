class WordSearch_79{
	private static int right = 1;
    private static int left = -1;
    private static int up = -1;
    private static int down = 1;
    public boolean exist(char[][] board, String word) {
        if(word.length() <= 0) return true;
        boolean res = false;
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                
                if(!res && word.charAt(0) == board[i][j]){
                    res = findTargetChar(board, word, 0, i, j);
                }
                if (res) break;
            }
        }
        return res;
    }
    
    private boolean findTargetChar(char[][] board, String word, int targetIndex, int rowIndex, int columnIndex) {
        char target = word.charAt(targetIndex);
        char ch = board[rowIndex][columnIndex];
        if(ch == target) {
            if (targetIndex == word.length() - 1) return true;
            boolean res = false;
            if(rowIndex > 0)
                res = findTargetChar(board, word, targetIndex + 1, rowIndex + up, columnIndex);
            if(!res && rowIndex < board.length - 1) 
                res = findTargetChar(board, word, targetIndex + 1, rowIndex + down, columnIndex);
            if(!res && columnIndex > 0)
                res = findTargetChar(board, word, targetIndex + 1, rowIndex, columnIndex + left);
            if(!res && columnIndex < board[0].length - 1)
                res = findTargetChar(board, word, targetIndex + 1, rowIndex, columnIndex + right);
            return res;
        }
        return false;
    }
}
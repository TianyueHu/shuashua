class MaximalSquare_221{
	public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
           return 0;
        int[][] record = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for(int i = 1; i < record.length; ++i){
            for(int j = 1; j < record[0].length; ++j){
                if(matrix[i - 1][j - 1] == '1'){
                    if (i == 1 || j == 1 || matrix[i - 2][j - 1] == '0' || matrix[i - 1][j - 2] == '0' || matrix[i - 2][j - 2] == '0')
                        record[i][j] = 1;
                    else
                        record[i][j] = Math.min(record[i - 1][j - 1], Math.min(record[i][j - 1], record[i - 1][j])) + 1;
                    
                    max = Math.max(record[i][j], max);
                }
                else {
                    record[i][j] = 0;
                }
            }
        }
        return max * max;
    }
}
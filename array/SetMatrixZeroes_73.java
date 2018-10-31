class SetMatrixZeroes_73{
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if(m <= 0) return;
        int n = matrix[0].length;
        if(n <= 0) return;
        
        int[] rowFlags = new int[m];
        int[] columnFlags = new int[n];
        
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == 0){
                    rowFlags[i] = 1;
                    columnFlags[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; ++i){
            if(rowFlags[i] == 1)
                setRowZeroes(matrix, i);
        }
        for(int j = 0; j < n; ++j){
            if(columnFlags[j] == 1)
                setColumnZeroes(matrix, j);
        }
        
    }
    
    private void setRowZeroes(int[][] matrix, int row){
        for(int i = 0; i < matrix[row].length; ++i){
            matrix[row][i] = 0;
        }
    }
    
    private void setColumnZeroes(int[][] matrix, int column){
        for(int i = 0; i < matrix.length; ++i){
            matrix[i][column] = 0;
        }
    }
}
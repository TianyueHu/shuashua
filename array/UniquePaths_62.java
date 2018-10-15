class UniquePaths_62{
	public int uniquePaths(int m, int n) {
        if(m <= 1 || n <= 1) return 1;
        int[][] matrix = new int[m][n];
        
        for(int i = 1; i < m; ++i){
            matrix[i][0] = 1;
        }
        for(int i = 1; i < n; ++i){
            matrix[0][i] = 1;
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }
        
        return matrix[m-1][n-1];
    }
}
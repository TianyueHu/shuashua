class UniquePath2_63{
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = 0;
        if(m > 0) n = obstacleGrid[0].length;
        else return 1;
        if(n <= 0) return 1;
        int[][] matrix = new int[m][n];
        boolean flag = false;
        for(int i = 0; i < m; ++i){
            if(obstacleGrid[i][0] == 1) flag = true;
            if(flag) matrix[i][0] = 0;
            else matrix[i][0] = 1;
        }
        flag = false;
        for(int i = 0; i < n; ++i){
            if(obstacleGrid[0][i] == 1) flag = true;
            if(flag) matrix[0][i] = 0;
            else matrix[0][i] = 1;
        }
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                if(obstacleGrid[i][j] == 1) matrix[i][j] = 0;
                else{
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j - 1];
                }
            }
        }
        return matrix[m-1][n-1];
    }
}
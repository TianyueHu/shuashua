class MinimumPathSum_64{

	public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        if(m <= 0) return 0;
        int n = grid[0].length;
        if(n <= 0) return 0;
        int[][] count = new int[m][n];
        count[0][0] = grid[0][0];
        for(int i = 1; i < m; ++i){
            count[i][0] = grid[i][0] + count[i-1][0];
        }
        for(int i = 1; i < n; ++i){
            count[0][i] = grid[0][i] + count[0][i-1];
        }
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                count[i][j] = grid[i][j] + (count[i-1][j] <= count[i][j-1] ? count[i-1][j] : count[i][j-1]);
            }
        }
        return count[m-1][n-1];
    }
}
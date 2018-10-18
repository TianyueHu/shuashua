class SearchA2DMatrix_74{
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m <= 0) return false;
        int n = matrix[0].length;
        if(n <= 0) return false;
        
        for(int i = 0; i < m; ++i){
            if(target <= matrix[i][n - 1] && target >= matrix[i][0]){
                int left = 0, right = n - 1;
                while (left <= right){
                    int mid = (left + right + 1) / 2;
                    if(matrix[i][mid] == target) 
                        return true;
                    else if(matrix[i][mid] < target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
                break;
            }
        }
        return false;
    }
}
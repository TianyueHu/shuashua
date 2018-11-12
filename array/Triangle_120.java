class Triangle_120{
	
	public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minPathSum = new int[n + 1];
        for(int row = n - 1; row >= 0; --row){
            List<Integer> lst = triangle.get(row);
            for(int i = 0; i <= row; ++i){
                minPathSum[i] = lst.get(i) + min(minPathSum[i] , minPathSum[i+1]);
            }
        }
        return minPathSum[0];
    }
    
    public int min(int i1, int i2){
        return i1 < i2 ? i1 : i2;
    }
}
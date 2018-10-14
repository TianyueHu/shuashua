class SpiralMatrix2_59{
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int num = 1, rowBegin = 0, rowEnd = n - 1;
        while(rowBegin < rowEnd){
            int len = rowEnd - rowBegin;
            for(int i = rowBegin; i < rowEnd; ++i, ++num){
                result[rowBegin][i] = num;
                result[i][rowEnd] = num + len;
                result[rowEnd][rowEnd - i + rowBegin] = num + 2 * len;
                result[rowEnd - i + rowBegin][rowBegin] = num + 3 * len;
            }
            num = num + 3 * len;
            
            ++rowBegin; --rowEnd;
        }
        if(rowBegin == rowEnd) 
            result[rowBegin][rowBegin] = num;
        return result;
    }
}
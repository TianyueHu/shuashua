class SpiralMatrix_54{
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<>();
        if(null == matrix) return lst;
        int rowlen = matrix.length;
        if(0 == rowlen) return lst;
        int columnLen = matrix[0].length;
        if(0 == columnLen) return lst;
        
        int rowStart = 0, rowEnd = rowlen - 1, columnStart = 0, columnEnd = columnLen - 1;
       
        for(; rowStart < rowEnd && columnStart < columnEnd; 
            ++rowStart, --rowEnd, ++columnStart, --columnEnd){
            for(int i = columnStart; i <= columnEnd; ++i){
                lst.add(matrix[rowStart][i]);
            }
            for(int i = rowStart + 1; i <= rowEnd; ++i){
                lst.add(matrix[i][columnEnd]);
            }
            for(int i = columnEnd - 1; i >= columnStart; --i){
                lst.add(matrix[rowEnd][i]);
            }
            for(int i = rowEnd - 1; i > rowStart; --i){
                lst.add(matrix[i][columnStart]);
            }
        }
        if(rowStart == rowEnd){
            for(int i = columnStart; i <= columnEnd; ++i){
                lst.add(matrix[rowStart][i]);
            }
        }
        else if(columnStart == columnEnd){
            for(int i = rowStart; i <= rowEnd; ++i){
                lst.add(matrix[i][columnEnd]);
            }
        }
        return lst;
    }
}
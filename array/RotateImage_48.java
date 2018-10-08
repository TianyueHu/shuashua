class RotateImage_48{
	public void rotate(int[][] matrix) {
        rotate_recursion(matrix, 0, matrix.length - 1);
    }
    
    private void rotate_recursion(int[][] matrix, int rowStart, int rowEnd){
        int columnStart = rowStart, columnEnd = rowEnd;
        
        if(rowStart < rowEnd){
            for(int i = 0; i < rowEnd - rowStart; ++i){
                int temp = matrix[rowStart][columnStart+i];
                matrix[rowStart][columnStart+i] = matrix[rowEnd-i][columnStart];
                matrix[rowEnd-i][columnStart] = matrix[rowEnd][columnEnd-i];
                matrix[rowEnd][columnEnd-i] = matrix[rowStart+i][columnEnd];
                matrix[rowStart+i][columnEnd] = temp;
            }
            rotate_recursion(matrix, rowStart+1, rowEnd-1);
        }
    }

    private void rotate_loop(int[] [] matrix){
    	int rowStart = 0, rowEnd = matrix.length - 1;

    	while(rowStart < rowEnd){
    		for(int i = 0; i < rowEnd - rowStart; ++i){
	    		int temp = matrix[rowStart][rowStart+i];
	            matrix[rowStart][rowStart+i] = matrix[rowEnd-i][rowStart];
	            matrix[rowEnd-i][rowStart] = matrix[rowEnd][rowEnd-i];
	            matrix[rowEnd][rowEnd-i] = matrix[rowStart+i][rowEnd];
	            matrix[rowStart+i][rowEnd] = temp;
            }
            ++rowStart;
            --rowEnd;
    	}
    }
}
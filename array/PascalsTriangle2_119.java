
class PascalsTriangle2_119{
	
	public List<Integer> getRow(int rowIndex) {
		//Time Limit Exceeded
        List<Integer> result = new ArrayList<Integer>();
        
        result.add(1);
        for(int i = 1; i <= rowIndex; ++i){
            result.add(getNum(rowIndex, i));
        }
        return result;
        
    }
    
    public int getNum(int row, int column){
        if(row == 0 || column == 0 || column == row) return 1;
        return getNum(row - 1, column - 1) + getNum(row - 1, column);
    }

    public List<Integer> getRow_2(int rowIndex){
    	List<Integer> result = new ArrayList<Integer>();
    	result.add(1);
    	for(int i = 1; i <= rowIndex; ++i){
    		result.add(1);
    		for(int j = result.size() - 2; j > 0; --j){
    			result.set(j, result.get(j) + result.get(j-1));
    		}
    	}
    	return result;
    }
}
class PascalsTriangle_118{
	public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) return triangle;
        triangle.add(new ArrayList<Integer>(Arrays.asList(1)));
        for(int i = 1; i < numRows; ++i){
            List<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            List<Integer> lastRow = triangle.get(i - 1);
            for(int j = 1; j < i; ++j){
                newRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle;
    }
}
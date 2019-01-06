class DifferentWaystoAddParentheses_241{
	public List<Integer> diffWaysToCompute(String input) {
		if (input == null || input.length() <= 0) 
			return new ArrayList<Integer>();
        List<Integer> res = getDiffResult(input, 0, input.length() - 1);
        Collections.sort(res, new Comparator<Integer>() {
                                    @Override
                                    public int compare(Integer o1, Integer o2) {
                                        return o1 - o2;
                                    }
                                });
        return res;
    }

    public List<Integer> getDiffResult(String lst, int start, int end){
    	//System.out.println(lst + " " + start + " " + end);
    	List<Integer> result = new ArrayList<Integer>();
        boolean flag = false;
    	for(int i = start + 1; i <= end; ++i){

    		if (isOperator(lst.charAt(i))){
                flag = true;
    			List<Integer> left = getDiffResult(lst, start, i - 1);
    			List<Integer> right = getDiffResult(lst, i + 1, end);
    			for(int j = 0; j < left.size(); ++j){
    				for(int k = 0; k < right.size(); ++k){
    					result.add(getRes(lst.charAt(i), left.get(j), right.get(k)));
    				}
    			}
    		}
    	}
        if(!flag){
            result.add(Integer.valueOf(lst.substring(start, end + 1)));
        }
    	return result;
    }

    private boolean isOperator(char op){
    	if(op == '+' || op == '-' || op == '*')
    		return true;
    	return false;
    }
    private int getRes(char op, int left, int right){
        //System.out.println(left + op + right);
    	switch(op){
    		case '+':
    			return left + right;
    		case '-':
    			return left - right;
    		case '*':
    			return left * right;
    	}
        return 0;
    }
}
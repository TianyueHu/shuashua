class CombinationSum3_216{
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        search(result, new ArrayList<Integer>(), 1, k, n);
        return result;
    }
    
    public void search(List<List<Integer>> result, List<Integer> lst, int start, int maxLen, int target){
        int tempSum = 0;
        for(int i = 0; i < lst.size(); ++i){
            tempSum += lst.get(i);
        }
        
        for(int i = start; i <= 9; ++i){
            if(i + tempSum > target){
                break;
            }
            List<Integer> newLst = new ArrayList<Integer>(lst);
            newLst.add(i);  
            if(i + tempSum < target && newLst.size() < maxLen){
                search(result, newLst, i + 1, maxLen, target);
            }
            else if (i + tempSum == target && newLst.size() == maxLen){
                result.add(newLst);
            }
        }
    }
}
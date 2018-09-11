

class CombinationSum2_40{

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int start){
    	if(target < 0) return;
    	else if(target == 0){
            Collections.sort(list);
            if(!lists.contains(list))
                lists.add(list);
        } 
    	else{
    		for(int i = start; i < nums.length; ++i){
    			List<Integer> tempList = new ArrayList<>(list);
    			tempList.add(nums[i]);
    			backtrack(lists, tempList, nums, target - nums[i], i + 1);
    		}
    	}
    }

    /*
    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int start){
    	if(target < 0) return;
    	else if(target == 0) lists.add(list);
    	else{
    		for(int i = start; i < nums.length; ++i){
    			if(nums[i] > target) break;
    			if(i > start && nums[i] == nums[i-1]) continue;
    			List<Integer> tempList = new ArrayList<>(list);
    			tempList.add(nums[i]);
    			backtrack(lists, tempList, nums, target - nums[i], i + 1);
    		}
    	}
    }
    */
}
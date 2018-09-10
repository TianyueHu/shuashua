

class CombinationSum_19{

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return depthFirstSearch(candidates, target, 0);
    }

    public List<List<Integer>> depthFirstSearch(int[] candidates, int target, int begin){
    	List<List<Integer>> results = new ArrayList<>();
    	for(int i = begin; i < candidates.length; ++i){
    		int num = candidates[i];
    		if(num == target){
    			results.add(new ArrayList<Integer>(){{
    				add(num);
    			}});
                break;
    		}
    		else if(num < target){
    			List<List<Integer>> sonResults = depthFirstSearch(candidates, target - num, i);
    			for(List<Integer> sonResult : sonResults){
    				List<Integer> result = new ArrayList<>();
                    result.add(num);
    				result.addAll(sonResult);
    				results.add(result);
    			}
    		}
    		else{
    			break;
    		}
    	}
    	return results;
    }

    public List<List<Integer>> combinationSum_1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> lists, List<Integer> list, int[] nums, int target, int start){
        if(target < 0) return;
        else if(target == 0) lists.add(new ArrayList<>(list));
        else {
            for(int i = start; i < nums.length; ++i){
                if(nums[i] > target) break;

                List<Integer> tempList = new ArrayList<>(list);
                tempList.add(nums[i]);
                backtrack(lists, tempList, nums, target - nums[i], i);

            }
        }
    }
}
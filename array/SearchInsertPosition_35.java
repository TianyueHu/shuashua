
public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        if(nums.length < 1 || nums[0] > target){
        	return 0;
        }
        else if(nums[nums.length - 1] < target){
        	return nums.length;
        }
        return search(0, nums.length - 1, nums, target);
    }

    public int search(int left, int right, int[] nums, int target){
    	if(left <= right && nums[left] <= target && nums[right] >= target){
    		int middle = (left + right) / 2;
    		if(nums[middle] == target){
    			return middle;
    		}
    		else if(nums[middle] < target 
    			&& (middle == nums.length - 1 || nums[middle + 1] > target)){
    			return middle + 1;
    		}
    		else if(nums[middle] > target
    			&& (middle == 0 || nums[middle - 1] < target)){

    			return middle;
    		}

    		int leftResult = search(left, middle - 1, nums, target)
    		return leftResult == -1 ? search(middle + 1, right, nums, target) : leftResult;
    	}
    	return -1;
    }
}
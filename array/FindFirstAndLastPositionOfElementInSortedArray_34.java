

public class FindFirstAndLastPositionOfElementInSortedArray_34{

	public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = 0;
        int[] result = new int[]{-1, -1};
        findTarget(left, right, nums, target, result);
        return result;
    }

    public void findTarget(int left, int right, 
    	int[] nums, int target, int[] result){
    	if(left <= right && nums[left] <= target && nums[right] >= target){
    		int middle = (left + right) / 2;
    		if(nums[middle] == target){
    			if(middle == nums.length - 1 || nums[middle + 1] > target){
    				result[1] = middle;
    			}
    			else if(middle == 0 || nums[middle - 1] < target){
    				result[0] = middle;
    			}
    		}
    		findTarget(left, middle-1, nums, target, result);
    		findTarget(middle+1, right, nums, target, result);

    	}	
    }


}
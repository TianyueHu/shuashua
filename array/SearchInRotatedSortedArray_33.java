import java.util.*;

class SearchInRotatedSortedArray_33{
	public int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            int mid = (left + right + 1) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[left]){
                if(nums[mid] > target && nums[left] < target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(nums[mid] < target && nums[right] > target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
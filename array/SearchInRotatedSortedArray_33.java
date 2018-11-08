import java.util.*;

class SearchInRotatedSortedArray_33{
	public static int search(int[] nums, int target) {
        //错的！！！！！！！！！！！！！！！！！！！！！
        int size = nums.length;
        int low = 0, high = size - 1;
        while(low < high){
        	int mid = (low + high) / 2;
        	if(nums[mid] == target) return mid;

        	if(nums[mid] > target){
        		if(nums[low] <= target){
        			high = mid
        		}
        		else{
        			low = mid + 1;
        		}

        	}
        	else if(nums[mid] < target){
        		if(nums[high] > target){
        			low = mid + 1
        		}
        		else{
        			high = mid;
        		}
        	}
        }
        return -1;
    }

    public static void main(String args[]){
    	int[] nums = new int[]{0,1,2,3,7,8,9,4,5,6};
    	int result = SearchInRotatedSortedArray_33.search(nums,1);
    	System.out.println(result);
    }
}
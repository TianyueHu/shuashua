class FindMinimumInRotatedSortedArray2_154{
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right){
        	int mid = (left + right) / 2;
        	min = min(min, min(nums[left], min(nums[mid], nums [right])));
        	if(nums[mid] > nums[left]){
        	    left = mid + 1;
        	}
        	else if(nums[mid] < nums[right]){
        	    right = mid - 1;
        	}
        	else if(nums[mid] == nums[right] || nums[mid] == nums[left]){
        	    while (true){
        	        if(right >= 0 && nums[mid] == nums[right]) right--;
        	        else break;
        	    }
        	    while (true){
        	        if(left < nums.length && nums[mid] == nums[left]) ++left;
        	        else break;
        	    }
        	}

        }
        return min;
    }

    private int min(int i1, int i2){
        return i1 < i2 ? i1 : i2;
    }
}
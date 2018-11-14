class MajorityElement_169{
    public int majorityElement(int[] nums) {
        return findKth(nums, (int)((nums.length) / 2), 0 ,nums.length - 1);
    }

    public int findKth(int[] nums, int k, int start, int end){
        if(start == end) return nums[start];
        int key = nums[start], left = start, right = end;
        while(left < right){
        	while(nums[right] >= key && left < right)
        	    --right;
        	nums[left] = nums[right];
        	while(nums[left] < key && left < right)
        	    ++left;
        	nums[right] = nums[left];
        }
        nums[left] = key;
        if(left == k) return key;
        else if(left < k){
        	return findKth(nums, k, left + 1, end);
        }
        else{
        	return findKth(nums, k, start, left - 1);
        }
    }
}
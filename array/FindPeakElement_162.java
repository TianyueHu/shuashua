class FindPeakElement_162{
	public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        
        return searchPeakIndex(nums, 0, nums.length - 1);
    }
    
    public int searchPeakIndex(int[] nums, int start, int end){
        
        if(start < end - 1){
            int mid = (start + end) / 2;
            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            
            else if(nums[mid] > nums[mid + 1]){
                return searchPeakIndex(nums, start, mid);
            }
            return searchPeakIndex(nums, mid, end);
        }
        return nums[start] > nums[end] ? start : end;
        
    }
}
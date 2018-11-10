class SearchInRotatedSortedArray2_81{
    public boolean search(int[] nums, int target) {
        if(nums.length <= 0) return false;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right + 1) / 2;
            if(nums[mid] == target) return true;
            if(nums[left] == target) return true;
            if(nums[right] == target) return true;
            if(nums[mid] == nums[left]){
                while (true){
                    if(left < nums.length && nums[mid] == nums[left]) ++left;
                    else break;
                }
                while (true){
                    if(right >= 0 && nums[mid] == nums[right]) --right;
                    else break;
                }
            }
            else if(nums[mid] > nums[left]){
                if(target < nums[mid] && target > nums[left]) right = mid - 1;
                else left = mid + 1;
            }
            else{
                if(target > nums[mid] && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
class FindTheDuplicateNumber_287{
	public int findDuplicate(int[] nums) {
        if(nums.length > 0){
            int fast = 0, slow = 0;
            int entry = 0;
            while (true){
                if(fast < nums.length)
                    fast = nums[fast];
                else return -1;
                if(fast < nums.length)
                    fast = nums[fast];
                else return -1;
                slow = nums[slow];
                if(slow == fast){
                    while(entry != slow){
                        entry = nums[entry];
                        slow = nums[slow];
                    }
                    return entry;
                }
            }
        }
        return -1;
    }
}
class HouseRobber2_213{
	public int rob(int[] nums) {
        if(nums == null) return 0;
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];
        int[] notContainsFirstRecord = new int[nums.length];
        int[] containsFirstRecord = new int[nums.length];
        for(int i = 1; i < nums.length; ++i){
            notContainsFirstRecord[i] = -1;
            containsFirstRecord[i] = -1;
        }
        notContainsFirstRecord[0] = 0;
        containsFirstRecord[0] = nums[0];
        return Math.max(getMax(nums, nums.length - 1, notContainsFirstRecord),
                       getMax(nums, nums.length - 2, containsFirstRecord));
    }
    
    public int getMax(int[] nums, int end, int[] record){
        if(end < 0 || end >= nums.length) return 0;
        if(record[end] != -1) return record[end];
        int max = Math.max((nums[end] + getMax(nums, end - 2, record)), getMax(nums, end - 1, record));
        return record[end] = max;
    }
}
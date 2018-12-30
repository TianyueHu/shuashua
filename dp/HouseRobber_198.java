class HouseRobber_198{
	public int rob(int[] nums) {
        if (nums.length <= 0) return 0;
        int[] record = new int[nums.length];
        record[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            record[i] = -1;
        }
        return getMax(nums, nums.length - 1, record);
    }
    
    public int getMax(int[] nums, int end, int[] record){
        if(end < 0 || end >= nums.length) return 0;
        if(record[end] != -1 || end == 0) return record[end];
        int max = Math.max((nums[end] + getMax(nums, end - 2, record)), getMax(nums, end - 1, record));
        return record[end] = max;
    }
}
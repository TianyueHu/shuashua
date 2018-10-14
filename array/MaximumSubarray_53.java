
class MaximumSubarray_53{

	public int maxSubArray(int[] nums) {
		int curMax = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
        	curMax = Math.max(curMax + nums[i], nums[i]);
        	max = (max, curMax);
        }
        return max;
    }
}
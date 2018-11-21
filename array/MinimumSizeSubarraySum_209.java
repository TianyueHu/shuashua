class MinimumSizeSubarraySum_209{
	public int minSubArrayLen(int s, int[] nums) {
        int start = 0, sum = 0;
        int min = nums.length + 1;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            while (sum >= s && start <= i){
                min = min <= (i - start + 1) ? min : (i - start + 1);
                sum -= nums[start];
                ++start;
            }
        }
        return min == (nums.length + 1) ? 0 : min;
    }
}
class MaximumProductSubarray_152{
	public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len < 1) return 0;
        else if(len <= 1) return nums[0];
        int min = nums[0], 
        max = nums[0], 
        maxProduct = nums[0];
        
        for(int i = 1; i < len; ++i){
            int tempMax = max;
            max = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));
            maxProduct = Math.max(max, maxProduct);
        }
        return maxProduct;
    }
}
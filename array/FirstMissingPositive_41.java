class FirstMissingPositive_41{

	public int firstMissingPositive(int[] nums) {
        int max = 0;
        int[] bucket = new int[Integer.MAX_VALUE];

        for(int num : nums){
        	bucket[num] = 1;
        	if(num > max) max = num;
        }
        for(int i = 1; i < max + 1; ++i){
        	if(nums[i] == 0) return i;
        }
        return max + 1;
    }
}
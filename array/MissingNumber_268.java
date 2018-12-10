class MissingNumber_268{
	public int missingNumber(int[] nums) {
        int n = nums.length;
        if (n > 0){
            int sum = 0;

            for(int i = 0; i < nums.length; ++i){
                sum += nums[i];
            }

            return n * (n+1) / 2 - sum;
        }
        return 0;
    }
}
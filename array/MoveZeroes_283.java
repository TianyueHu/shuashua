class MoveZeroes_283{
	public void moveZeroes(int[] nums) {
        if(nums.length <= 1) 
            return;
        int zeroPtr = 0, nonZeroPtr = 0;
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            if(nums[i] == 0){
                nonZeroPtr = i;
                break;
            }
        }
        while(nonZeroPtr < len && zeroPtr < len){
            while(nonZeroPtr < len && nums[nonZeroPtr] == 0){
                nonZeroPtr++;
            }
            while(zeroPtr < len && nums[zeroPtr] != 0){
                zeroPtr++;
            }
            swap(nums, nonZeroPtr, zeroPtr);
        }
    }
    private void swap(int[] nums, int i, int j){
        if(i < nums.length && j < nums.length){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
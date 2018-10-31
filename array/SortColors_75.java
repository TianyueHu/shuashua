class SortColors_75{
	public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        int zeroPtr = 0, twoPtr = nums.length - 1;
        for(int ptr = 0; ptr <= twoPtr; ++ptr){
        	while(nums[ptr] != 1 && ptr >= zeroPtr && ptr <= twoPtr){
        		if(nums[ptr] == 0){
        			nums[ptr] = nums[zeroPtr];
        			nums[zeroPtr++] = 0;
        		}
        		else if (nums[ptr] == 2){
        			nums[ptr] = nums[twoPtr];
        			nums[twoPtr--] = 2
        		}
        	}
        }
    }
}
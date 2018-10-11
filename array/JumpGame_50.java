class JumpGame_50{
	public boolean canJump(int[] nums) {
		Stack<Integer> ptrStack = new Stack<>();
		int len = nums.length;
		ptrStack.push(0);
		while(!ptrStack.isEmpty()){
			int ptr = ptrStack.peek();
			if(nums[ptr] >= (len - 1 - ptr)) return true;

			boolean flag = true;
			for(int i = 1; i <= nums[ptr]; ++i){
				if(nums[ptr + i] != 0) {
					flag = false;
					ptrStack.push(ptr + i);
					break;
				}
			}

			if(flag){
				nums[ptr] = 0;
				ptrStack.pop();
			}
		}
	}
}

 private boolean jump(int[] nums, int ptr){
	if(ptr == nums.length - 1 || nums[ptr] >= (nums.length - 1 - ptr)) return true;
	if(nums[ptr] == 0) return false;
	for(int i = 0; i <= nums[ptr]; ++i){
		if(jump(nums, ptr + i) == true) return true;
	}
	nums[ptr] == 0;
	return false;
 }

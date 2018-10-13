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

	private boolean jump(int[] nums, int ptr){
		if(ptr == nums.length - 1 || nums[ptr] >= (nums.length - 1 - ptr)) return true;
		if(nums[ptr] == 0) return false;
		for(int i = 0; i <= nums[ptr]; ++i){
			if(jump(nums, ptr + i) == true) return true;
		}
		nums[ptr] == 0;
		return false;
	}

	private enum STATUS{
		UNKNOWN, GOOD, BAD
	}

	public bool backJump(int[] nums){
		if(nums.length <= 1) return true;
		STATUS[] status = new STATUS[nums.length];

		for(int i = 0; i < nums.length - 2; ++i){
			status[i] = STATUS.UNKNOWN;
		}
		status[nums.length - 1] = STATUS.GOOD;

		for(int i = nums.length - 2; i >= 0; --i){
			if (nums[i] >= nums.length - 1 - i) 
				status[i] = STATUS.GOOD;
			else{
				for(int j = i; j <= i + nums[i]  ; ++j){
					if(status[j] == STATUS.GOOD){
						status[i] = STATUS.GOOD;
						break;
					}
				}
			}
		}
		if(status[0] == STATUS.GOOD)
			return true;
		return false;
	}

	public bool findZero(int[] nums){
		if(nums.length <= 1) return true;

		for(int i = 0; i < nums.length - 1; ++i){
			if(nums[i] == 0){
				int ptr = i - 1;
				for(int count = 1; ptr >= 0; --ptr, ++count){
					if(nums[ptr] > count) break;
				}
				if(ptr < 0) return false;
			}
		}
		return true;
	}
}


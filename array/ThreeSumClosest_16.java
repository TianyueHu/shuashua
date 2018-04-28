import java.util.*;

class ThreeSumClosest_16{
	public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; ++i){
        	if(i != 0 && nums[i] == nums[i-1]){
        		continue;
        	}
        	int start = i + 1, end = nums.length - 1;
        	int t = target - nums[i];
        	while(start < end){
        		int tempResult = nums[i] + nums[start] + nums[end];
                if(tempResult == target) return target;
        		if(Math.abs(tempResult - target) < Math.abs(result - target)){
        			result = tempResult;
        		}
        		if(nums[start] + nums[end] < t) ++start;
        		if(nums[start] + nums[end] > t) --end;
        		
        	}
        }
        return result;
    }

    
}
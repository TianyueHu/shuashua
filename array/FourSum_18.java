import java.util.*;

class FourSum_18{

	public static List<List<Integer>> fourSum(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int size = nums.length;
		for (int i = 0; i < size - 3; ++i){

			if(i != 0 && nums[i] == nums[i-1]) continue;

			for(int j = i + 1; j < size - 2; ++j){

				if(j != i + 1 && nums[j] == nums[j-1]) continue;
				int start = j + 1, end = size - 1;
				while (start < end){
					int temp = nums[i] + nums[j] + nums[start] + nums[end];
					if(temp == target){
						List<Integer> res = new ArrayList<>(
							Arrays.asList(nums[i],nums[j], nums[start], nums[end]));
						result.add(res);
						while(start < end && nums[start] == nums[start+1]) ++start;
						while(start < end && nums[end] == nums[end-1]) --end;
						++start;
					}
					else if(temp < target) ++start;
					else if(temp > target) --end;
				}
			}
		}
		return result;
	}

}
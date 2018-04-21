import java.util.Map;
import java.util.HashMap;

class TwoSum_1{
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; ++i){
			if(map.containsKey(nums[i])){
				int[] ret = new int[]{map.get(nums[i]), i};
				return ret;
			}
			map.put(target - nums[i], i);
		}
		return null;
    }
}

/*
初始化一个数组的3个方式
1、静态初始化
int[] a = {1,2,3};
2、new,指明大小,之后载赋值
int[] a = new int[3];
3、new,同时完成初始化
int[] a = new int[]{1,2,3};
*/
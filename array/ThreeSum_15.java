import java.util.*;

class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> results = new ArrayList<>();
    	Map<Integer, Map<Integer, Integer>> outMap = new HashMap<>();
        long start=System.currentTimeMillis();
    	for(int i = 0; i < nums.length; ++i){
    		for(Integer outKey : outMap.keySet()){
    			Map<Integer, Integer> innerMap = outMap.get(outKey);
    			if(innerMap.containsKey(nums[i]) && innerMap.get(nums[i]) == 0){
    				List<Integer> res = new ArrayList<>(Arrays.asList(
                                            (0 - outKey), (outKey - nums[i]), nums[i]));
    				
    				results.add(res);
    				innerMap.put(nums[i], 1);
    			}

    			if(!innerMap.containsKey(outKey - nums[i])){
    				innerMap.put(outKey - nums[i], 0);
    			}
    			
    		}
    		if(!outMap.containsKey(0 - nums[i])){
    			outMap.put((0 - nums[i]), new HashMap<Integer, Integer>());
    		}
    	}
        long end=System.currentTimeMillis();
        start=System.currentTimeMillis();
        results.sort(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2){
                return o1.get(0) == o2.get(0) ? (
                    o1.get(1) == o2.get(1) ? o1.get(2) - o2.get(2) 
                    : o1.get(1) - o2.get(1)
                    ) : (o1.get(0) - o2.get(0));
            }
        });
        end=System.currentTimeMillis();
    	return multiRemove(results);
    }


    private static List<List<Integer>> multiRemove(List<List<Integer>> lst){
        List<Integer> pointer = null;
        List<List<Integer>> results = new ArrayList<>();
        if(null != lst){
            for(List<Integer> l : lst){
                if(null == pointer || !pointer.containsAll(l) || !l.containsAll(pointer)){
                    results.add(l);
                }
                pointer = l;
            }
        }
        return results;
    }

    public static List<List<Integer>> threeSum_(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            int target = 0 - nums[i], begin = i+1, end = nums.length-1;
            while(begin < end){
                
                if(nums[begin] + nums[end] == target){
                    results.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[begin], nums[end])));
                    while(begin < end && nums[begin] == nums[begin + 1]) ++begin;
                    while(begin < end && nums[end] == nums[end-1]) --end;
                    ++begin;
                    --end;
                }
                else if(nums[begin] + nums[end] < target){
                    ++begin;
                }
                else{
                    --end;
                }
            }
            while(i < nums.length - 3 && nums[i] == nums[i + 1]) ++i;
        }
        return results;

    }

    public static void main(String[] args){
        int length = 1000;
        if (args.length > 0) {
            length = Integer.parseInt(args[0]);
        }
         
    	int[] nums = new int[length];
        for(int i=0;i<length;++i){
            nums[i] = (int) Math.round(Math.random()*(20000-(-20000))+ (-20000));
        }
        long start=System.currentTimeMillis();
      
    	ThreeSum_15.threeSum_(nums);
        
        long end=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(end-start)+"ms");

        start=System.currentTimeMillis();

        ThreeSum_15.threeSum(nums);

        end=System.currentTimeMillis();
        System.out.println("hashmap程序运行时间： "+(end-start)+"ms");
    }
}

/*
输出结果
输入为500
程序运行时间： 5ms
hashmap程序运行时间： 75ms
输入为1000
程序运行时间： 10ms
hashmap程序运行时间： 214ms
输入为2000
程序运行时间： 29ms
hashmap程序运行时间： 886ms

使用hashmap的时间简直呈指数级增长。
在每个部分使用时间计数的方式发现在第一层map内的时间约为1ms，这样的时间是无法接受的。
我能理解后面的方法更快，但是无法理解为什么使用hashmap的这种这么慢

*/




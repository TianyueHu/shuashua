import java.util.*;

class ThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> outMap = new HashMap<>();
        
        for(int i = 0; i < size; ++i){
            for(int outkey : outMap.keySet()){
                Map<Integer, Integer> innerMap = outMap.get(outkey);
                if(innerMap.containsKey(nums[i]) && innerMap.get(nums[i]) == 0){
                    results.add(new ArrayList<Integer>(Arrays.asList(0 - outkey, outkey - nums[i], nums[i])));
                    innerMap.put(nums[i], 1);
                }
                if(!innerMap.containsKey(outkey - nums[i])){
                    innerMap.put(outkey - nums[i], 0);
                }
            }
            if(!outMap.containsKey(0 - nums[i]))
                outMap.put(0 - nums[i], new HashMap<Integer,Integer>());
        }
        long start=System.currentTimeMillis();
        results.sort(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2){
                return o1.get(0) == o2.get(0) ? (
                    o1.get(1) == o2.get(1) ? o1.get(2) - o2.get(2) 
                    : o1.get(1) - o2.get(1)
                    ) : (o1.get(0) - o2.get(0));
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("排序时间： "+(end-start)+"ms");
        return results;
    }


    

    public static List<List<Integer>> threeSum_(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < size - 2; ++i){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int start = i + 1, end = size - 1;
            while(start < end){
                int temp = nums[i] + nums[start] + nums[end];

                if(temp == 0){
                    results.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    while(start < end && nums[end] == nums[end-1]) --end;
                    ++start;
                }
                else if(temp < 0) ++start;
                else if(temp > 0) --end;
            }
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
java ThreeSum_15 500
程序运行时间： 6ms
排序时间： 2ms
hashmap程序运行时间： 77ms

ThreeSum_15 1000
程序运行时间： 11ms
排序时间： 5ms
hashmap程序运行时间： 219ms

java ThreeSum_15 5000
程序运行时间： 128ms
排序时间： 124ms
hashmap程序运行时间： 8085ms

java ThreeSum_15 10000
程序运行时间： 2000ms
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
    at java.util.HashMap.newNode(HashMap.java:1747)
    at java.util.HashMap.putVal(HashMap.java:631)
    at java.util.HashMap.put(HashMap.java:612)
    at ThreeSum_15.threeSum(ThreeSum_15.java:18)
    at ThreeSum_15.main(ThreeSum_15.java:85)

使用hashmap的时间简直呈指数级增长。
在每个部分使用时间计数的方式发现在第一层map内的时间约为1ms，这样的时间是无法接受的。
我能理解后面的方法更快，但是无法理解为什么使用hashmap的这种这么慢
*/




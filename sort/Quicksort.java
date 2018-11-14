import java.util.Arrays;
class Quicksort{
    public static void sort(int[] nums){
        if(nums.length <= 1) return;
        quicksort(nums, 0, nums.length - 1);
    }

    private static void quicksort(int[] nums, int start, int end){
        if(start <= end && start >= 0 && end < nums.length){
            int left = start, right = end, key = nums[start];
            while(left < right){
            	    while(nums[right] >= key && left < right)
            	        --right;
            	    if(nums[right] < key){
            	    	nums[left] = nums[right];
            	    	nums[right] = key;
            	    }
            	    while(nums[left] < key && left < right)
            	    	++left;
            	    
            	    if(nums[left] >= key){
            	    	nums[right] = nums[left];
            	    	nums[left] = key;
            	    }
            }
            quicksort(nums, start, left - 1);
            quicksort(nums, left + 1, end);
        }
    }

    public static void test(int n, int rangeL, int rangeR){
        int[] nums= SortTestHelper.generateRandomArray(n, rangeL, rangeR);
        Quicksort.sort(nums);
        assert SortTestHelper.isSorted(nums);
    }

    public static void main(String[] args){
        for(int i = 0; i < args.length; ++i){
        	Quicksort.test(Integer.parseInt(args[i]), -1000, 1000);
        }
    }
}
class UniqueBinarySearchTrees_96{
	//flag == false --> right;
    //flag == true --> left 
    //由于返回结果是int，没有考虑溢出的情况
    
    public int numTrees(int n) {
        int[] nums = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = i + 1;
        }
        return getNumTrees(nums, left, right, true);
    }
    
    private int getNumTrees(int[] nums, int[] left, int[] right, boolean flag){
        int size = nums.length;
        
        if (size <= 1) return 1;
        if (flag && left[size - 1] != 0) return left[size - 1];
        if (!flag && right[right.length - size] != 0) return right[right.length - size];
            
        int count = 0;
        for(int i = 0; i < size; ++i){
            int leftNum = getNumTrees(Arrays.copyOfRange(nums, 0, i), left, right, true);
            int rightNum = getNumTrees(Arrays.copyOfRange(nums, i+1, size), left, right, false);
            count += (leftNum * rightNum);
        }
        if(flag) left[nums.length - 1] = count;
        else right[right.length - size] = count;
        return count;
    }
}
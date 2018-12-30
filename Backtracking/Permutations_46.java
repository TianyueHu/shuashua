class Permutations_46{
	//顺序不一样
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        permutations(nums, lst, new ArrayList<Integer>());
        return lst;
    }
    
    public void permutations(int[] nums, List<List<Integer>> lst, List<Integer> parent){
        if(nums.length == 0) {
            lst.add(parent);
            return;
        }
            
        for(int i = 0; i < nums.length; ++i){
            List<Integer> tempLst = new ArrayList<Integer>(parent);
            tempLst.add(nums[i]);
            int[] newNums = new int[nums.length - 1];
            System.arraycopy(nums, 0, newNums, 0, i);
            if(i + 1 < nums.length)
                System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);
            
            permutations(newNums, lst, tempLst);
        }
    }
}
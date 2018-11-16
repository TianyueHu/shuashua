class MajorityElement2_229{
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<Integer>();
        int firIndex = nums.length / 3, secIndex = 2 * nums.length / 3;
        
    }
    public void search(List<Ingeter> lst, int start, int end, int firIndex, int secIndex){
        if(start <= end){
            int left = start, right = end;
            int key = nums[left];
            while(left < right){
        	    while(nums[right] >= key && right > left) --right;
        	    nums[left] = nums[right];
        	    while(nums[left] < key && left < right) ++left;
        	    nums[right] = nums[left];
            }
            nums[left] = key;
            if(left == firIndex || left == secIndex) lst.add(key);
            if(start == firIndex || start == secIndex) lst.add(key);
            if(end == firIndex || end == secIndex) lst.add(key);
            if(left < firIndex)
        	    search(lst, left + 1, end - 1, firIndex, secIndex);
            else if(left > secIndex)
        	    search(lst, start + 1, left - 1, firIndex, secIndex);
            else{
        	    search(lst, start + 1, left - 1, firIndex, secIndex);
        	    search(lst, left + 1, end - 1, firIndex, secIndex);
            }
        }
    }
}
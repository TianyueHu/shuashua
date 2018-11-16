class SummaryRanges_228{
    public List<String> summaryRanges(int[] nums) {
        List<String> lst = new ArrayList<String>();
        for(int i = 0; i < nums.length; ++i){
        	int start = nums[i];
        	while(i < nums.length - 1&& nums[i] == (nums[i + 1] - 1)) ++i;
        	if(nums[i] == start)
        	    lst.add("" + start);
        	else
        	    lst.add("" + start + "->" + nums[i]);
        }
        return lst;
    }
}
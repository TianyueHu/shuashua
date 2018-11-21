class MajorityElement2_229{
    public List<Integer> majorityElement(int[] nums) {
        int[] candidates = {0, 0}, count = {0,0};
        for(int i = 0; i < nums.length; ++i){
            checkAndUpdate(candidates, count, nums[i]);
        }
        List<Integer> lst = new ArrayList<Integer>();
        if(count[0] > 0) lst.add(candidates[0]);
        if(count[1] > 0) lst.add(candidates[1]);
    }
    
    public void checkAndUpdate(int[] candidates, int[] count, int num){
        if(count[0] == 0){
            candidates[0] = num;
            count[0] = 1;
        }
        else if (count[1] == 0){
            candidates[1] = num;
            count[1] = 1;
        }
        else if (candidates[0] == num)
            count[0] ++;
        else if (candidates[1] == num)
            count[1] ++;
        else {
            count[0] --;
            count[1] --;
        }
    }
}
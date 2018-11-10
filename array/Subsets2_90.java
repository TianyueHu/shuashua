class Subsets2_90{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(nums.length == 0) return result;
    Arrays.sort(nums);
    List<Integer> lst = new ArrayList<Integer>();
    
    search(nums, result, lst, 0);
    Collections.sort(result, new Comparator<List<Integer>>(){
        public int compare(List<Integer> l1, List<Integer> l2){
            int flag = 1;
            if(l1.size() > l2.size()){
                List<Integer> temp = l1;
                l1 = l2;
                l2 = temp;
                flag = -1;
            }
            
            for(int i = 0; i < l1.size(); ++i){
                if(l1.get(i) == l2.get(i)) continue;
                return flag * (l2.get(i) - l1.get(i));
            }
            if(l2.size() == l1.size()) return 0;
            return -flag;
        }
    });
    return result;
}
    
public void search(int[] nums, List<List<Integer>> result, List<Integer> lst, int start){
    result.add(lst);
    for(int i = start; i < nums.length; ++i){
        if(i > start && nums[i] == nums[i - 1]) continue;
        
        List<Integer> newLst = new ArrayList<Integer>(lst);
        newLst.add(nums[i]);
        search(nums, result, newLst, i + 1);
    }
}
}
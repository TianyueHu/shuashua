class Subsets_78{
	
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nums.length <= 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        Arrays.sort(nums);
        List<Integer> numLst = new ArrayList<Integer>();
        for(int num : nums){
            numLst.add(num);
        }
        List<Integer> emptyLst = new ArrayList<Integer>();
        ret.add(emptyLst);
        ret.add(numLst);
        getList(nums.length - 1, emptyLst, numLst, ret);
        
        Collections.sort(ret, new Comparator<List<Integer>>(){
            public int compare(List<Integer> o1, List<Integer> o2){
                boolean flag = false;
                if(o1.size() > o2.size()){
                    flag = true;
                    List<Integer> temp = o2;
                    o2 = o1; o1 = temp;
                }
                for(int i = 0; i < o1.size(); ++i){
                    if(o1.get(i) == o2.get(i))
                        continue;
                    else return flag ? o1.get(i) - o2.get(i) : o2.get(i) - o1.get(i);
                }
                return flag ? 1 : -1;
            }
        });
        return ret;
    }
    
    private void getList(int size, List<Integer> oldLst, List<Integer> choiceLst, List<List<Integer>> ret){
        if(oldLst.size() >= size)
            return;
        for(Integer i : choiceLst){
            if(oldLst.size() >= 1 && i < oldLst.get(oldLst.size()-1))
                continue;
            List<Integer> newLst = new ArrayList<Integer>(oldLst);
            newLst.add(i);
            List<Integer> newChoiceLst = new ArrayList<Integer>(choiceLst);
            newChoiceLst.remove(i);
            ret.add(newLst);
            getList(size, newLst, newChoiceLst, ret);
        }
    }

    public List<List<Integer>> subsets_1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        search(nums, ret, new ArrayList<Integer>(), 0);
        return ret;
    }

    private void search(int[] nums, List<List<Integer>> ret, List<Integer> lst, int start){
        ret.add(lst);
        for(int i = start; i < nums.length; ++i){
            List<Integer> newLst = new ArrayList<Integer>(lst);
            newLst.add(nums[i]);
            search(nums, ret, newLst, i + 1);
        }
    }
}
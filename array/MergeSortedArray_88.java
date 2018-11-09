class MergeSortedArray_88{
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums1.length > 0 && nums2.length > 0){
            int endPtr = nums1.length - 1;
            int p1 = m - 1, p2 = n - 1;
            
            while(p1 >= 0 && p2 >= 0){
                if(nums1[p1] > nums2[p2]){
                    nums1[endPtr--] = nums1[p1--];
                } 
                else{
                    nums1[endPtr--] = nums2[p2--];
                }
            }
            while(p1 >= 0){
                nums1[endPtr--] = nums1[p1--];
            }
            while(p2 >= 0){
                nums1[endPtr--] = nums2[p2--];
            }
        }
    }
}
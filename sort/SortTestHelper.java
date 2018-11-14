import java.util.Arrays;
class SortTestHelper{
    private SortTestHelper(){}

    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = ((int)(Math.random() * (rangeR - rangeL + 1)) + rangeL);
        return arr;
    }

    public static boolean isSorted(int[] nums){
        if(nums.length <= 1) return true;
        int[] newNums = nums.clone();
        Arrays.sort(newNums) ;
        return Arrays.equals(nums, newNums);
    }
}
package array;

public class MedianOfTwoSortedArrays_4 {

    /*
    初始思路：两个数组分别用一个指针，类似归并排序的方法找到中位数的位置，然后将两个数组之和分为奇数和偶数进行处理
    */
    public double findMedianSortedArrays_1(int[] nums1, int[] nums2) {
        double result = 0;
        int size = (nums1.length + nums2.length - 1) / 2;
        boolean even = ((nums1.length + nums2.length) % 2 == 0) ? true : false;
        int p1 = 0, p2 = 0, i = 0;

        for (; i < size && p1 < nums1.length && p2 < nums2.length; ++i){
            if(nums1[p1] < nums2[p2]) ++p1;
            else ++p2;
        }
        if(p1 >= nums1.length){
            p2 += size - i;
            result = even ? (nums2[p2] + nums2[p2+1]) / 2.0 : nums2[p2];
        }
        else if(p2 >= nums2.length){
            p1 += size - i;
            result = even ? (nums1[p1] + nums1[p1+1]) / 2.0 : nums1[p1];
        }
        else if(i >= size){
            if(even){
                int num1 = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
                int num2 = p1 < nums1.length ? (p2 < nums2.length ? (nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2]) : nums1[p1]) : nums2[p2];
                result = (num1 + num2) / 2.0;
            }
            else{
                result = nums1[p1] < nums2[p2] ? nums1[p1]: nums2[p2];
            }
        }
        return result;
    }

    /*
    在开始进行判断，就不需要考虑哪一条更长的情况
     */
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianSortedArrays_2(nums2, nums1);
        }
        double result = 0;
        int size = (nums1.length + nums2.length - 1) / 2;
        boolean even = ((nums1.length + nums2.length) % 2 == 0) ? true : false;
        int p1 = 0, p2 = 0, i = 0;

        for (; i < size && p1 < nums1.length; ++i){
            if(nums1[p1] < nums2[p2]) ++p1;
            else ++p2;
        }
        if(p1 >= nums1.length){
            p2 += size - i;
            result = even ? (nums2[p2] + nums2[p2+1]) / 2.0 : nums2[p2];
        }

        else if(i >= size){
            if(even){
                int num1 = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
                int num2 = p1 < nums1.length ? (p2 < nums2.length ? (nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2]) : nums1[p1]) : nums2[p2];
                result = (num1 + num2) / 2.0;
            }
            else{
                result = nums1[p1] < nums2[p2] ? nums1[p1]: nums2[p2];
            }
        }
        return result;
    }

    /*
    参考思路：
    中位数在统计学意义上是将集合划分为两个长度相等的子集
    假设nums1.length < nums2.length
    存在i < nums1.length， j < nums2.length
    称nums1[0...i]和nums2[0...j]为集合left， nums1[i...nums1.length-1]和nums2[j...nums1.length-1]为集合right
    使得left.size() == right.size()
    且有max(left) <= min(right)，中位数就是(max(left) + min(right)) / 2
    如何找到i？由于有(i+j)=(nums1.length+nums2.length)，可以推出j=(nums1.length+nums2.length)-i
    遍历nums1，找到符合条件的即可。

    问题的关键在于，将集合划分为两个长度相等的子集
     */
    public double findMedianSortedArrays_3(int[] nums1, int[] nums2){

        if(nums1.length > nums2.length){
            return findMedianSortedArrays_3(nums2, nums1);
        }

        double result = 0;
        int setSize = nums1.length + nums2.length;
        boolean even = setSize % 2 == 0 ? true : false;
        int subsetSize = even ? setSize / 2 : (setSize - 1) / 2;
        int i = 0, j = 0;
        if(nums1.length <= 0)
            if (nums2.length <= 1) return nums2[0];
            else i = -1;
        else if(nums1[0] > nums2[j]) i = -1;
        for (; i<nums1.length; ++i){
            j = subsetSize - i - 2;
            //这种估计只有在写的时候才知道什么意思吧
            int leftMax = i >= 0 ? (j >= 0 ? Math.max(nums1[i], nums2[j])
                    : (i >= 1 ? Math.max(nums1[i], nums1[i-1]) : nums1[i]))
                    : (j >= 1 ? Math.max(nums2[j], nums2[j-1]) : nums2[j]);
            if(!even){
                int tryMedian = i >= nums1.length-1 ? nums2[j+1] : Math.min(nums1[i+1], nums2[j+1]);
                int rightMin = i >= nums1.length - 1 ? nums2[j+2] :
                        (nums1[i+1] < nums2[j+1] ? (i < nums1.length - 2 ? (Math.min(nums1[i+2], nums2[j+1]))
                                : (nums2[j+1])) : (j < nums2.length - 2 ? (Math.min(nums1[i+1], nums2[j+2])) : nums1[i+1]));

                if(tryMedian <= rightMin && tryMedian >= leftMax)
                    return tryMedian;
            }
            else{
                int rightMin = i < nums1.length - 1 ? (j < nums2.length - 1 ? (Math.min(nums1[i+1], nums2[j+1])) : nums1[i+1]) : nums2[j+1];
                if(leftMax <= rightMin)
                    return (leftMax + rightMin) / 2.0;
            }
        }

        return result;
    }
    /*
    以上3种每次都需要区分奇偶
    上面一种还需要考虑各种边界条件
     */
    public double findMedianSortedArrays_4(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            return findMedianSortedArrays_4(nums2, nums1);
        }
        double result = 0;
        int len = nums1.length + nums2.length;

        for(int position1 = 0; position1 < (2*nums1.length+1); ++position1){
            // 0<= position1/2 <= nums1.length
            // 0 <= len-nums1.length * 2 <= position2 <=len <= nums2.length * 2

            int position2 = len - position1;
            int l1 = nums1.length > 0 ? (position1 > 0 ? nums1[(position1 - 1) / 2] : 0) : 0;
            int r1 = position1 / 2 < nums1.length ? nums1[position1 / 2] : Integer.MAX_VALUE;
            int l2 = position2 > 0 ? nums2[(position2 - 1) / 2] : 0;
            int r2 = position2 / 2 < nums2.length ? nums2[position2 / 2] : Integer.MAX_VALUE;

            int lmax = Math.max(l1, l2);
            int lmin = Math.min(r1, r2);
            if(lmax <= lmin){
             return (lmax + lmin) / 2.0;
            }
        }
        return result;
    }

}


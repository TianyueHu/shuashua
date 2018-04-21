public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int max = 0;
        for(int left = 0, right = height.length - 1; left < right; ){
            int area = 0;
            if(height[right] > height[left]){
                area = height[left] * (right - left);
                left++;
            }
            else{
                area = height[right] * (right - left);
                right--;
            }
            if(max < area){
                max = area;
            }
        }
        return max;
    }
}
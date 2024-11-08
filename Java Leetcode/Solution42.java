// 42. Trapping Rain Water

public class Solution42 {
    public int trap(int[] height){
        int left = 0;
        int right = height.length - 1;
        int left_max = height[left];
        int right_max = height[right];
        int water = 0;

        while(left < right){
            if(left_max < right_max){
                left++;
                left_max = Math.max(left_max, height[left]);
                water += left_max - height[left];
            }else{
                right--;
                right = Math.min(right_max, height[right]);
                water += right_max - height[right];
            }
        }
        return water;
    }
}

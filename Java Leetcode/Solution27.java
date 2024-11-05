// Remove Element

public class Solution27 {
    public int removeElement(int[] nums, int val){
        int len = nums.length;
        int i = 0;

        while(i < len){
            if (nums[i] == val){
                nums[i] = nums[len -1];
                len--;
            }else{
                i++;
            }
        }
        return len;
    }
}

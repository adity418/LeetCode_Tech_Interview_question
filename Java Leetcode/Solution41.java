// 41. First Missing Positive

import java.util.Arrays;

public class Solution41 {

    public int firstMissingPositive(int[] nums) {
        int[] filteredNums = Arrays.stream(nums).filter(n -> n > 0).toArray();

        Arrays.sort(filteredNums);

        int target = 1;
        for (int n : filteredNums) {
            if (n == target) {
                target++;
            } else if (n > target) {
                return target;
            }
        }
        return target;
    }
}

// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         int n = nums.length;
//         for(int i =0;i<n;i++){
//             int num = nums[i];
//             while(nums[i]<=n && nums[i]>0 && nums[num-1]!=num){
//                 int temp = nums[i];
//                 nums[i]=nums[num-1];
//                 nums[num-1]=temp;
//                 num = nums[i];
//             }
//         }
//         for(int i=0;i<n;i++){
//             if(nums[i]!=i+1){
//                 return i+1;
//             }
//         }
//         return n+1;
//     }
// }

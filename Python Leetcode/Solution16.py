# 16. 3Sum Closest

class Solution16:
    def threeSumClosest(self, nums, target):
        nums.sort()
        closet_sum  = float('inf')

        for i in range(len(nums) - 2):
            left,right = i + 1, len(nums) -1
            while left < right:
                curr_sum = nums[i] + nums[left] +nums[right]
                if abs(curr_sum -target) < abs(closet_sum - target):
                    closet_sum = curr_sum
                if curr_sum < target:
                    left += 1
                elif curr_sum > target:
                    right -= 1
                else:
                    return curr_sum

        return closet_sum
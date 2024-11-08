# 26. Remove Duplicates from Sorted Array

class Solution:
    def removeDuplicates(self, nums):
        i = 0
        for j in range(len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i+1] = nums[j]
                
        return i + 1
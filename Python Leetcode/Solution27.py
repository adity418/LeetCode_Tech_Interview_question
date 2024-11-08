# 27. Remove Element

"""
Given an integer array nums and an integer val, remove all 
occurrences of val in nums in-place. The order of the elements 
may be changed. Then return the number of elements in nums which 
are not equal to val.
"""
class Solution27:
    def removeElement(self, nums, val):
        n = len(nums)
        i = 0

        while i < n:
            if nums[i] == val:
                nums.pop(i)
            else:
                i += 1

        return n
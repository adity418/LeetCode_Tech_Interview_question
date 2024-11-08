# 41. First Missing Positive

class Solution41:
    def firstMissingPositive(self, nums):
        nums = [n for n in nums if n > 0]
        nums.sort()

        target = 1
        for n in nums:
            if n == target:
                target += 1
            elif n > target:
                return target
            
        return 
    

"""
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n=len(nums)
        seen=[False]*(n+1)
        for num in nums:
            if 0<num<=n:
                seen[num]=True
        for i in range(1,n+1):
            if seen[i]==False:
                return i
        return n+1
"""


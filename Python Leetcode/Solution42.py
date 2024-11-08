# 42. Trapping Rain water

class Solution42:
    def trap(self, height):
        left = 0
        right = len(height) - 1
        left_max = height[left]
        right_max = height[right]
        water = 0

        while left < right:
            if left_max < right_max:
                left += 1
                left_max = max(left_max, height[left])
                water += left_max - height[left]
            else:
                right -= 1
                right = max(right_max, height[right])
                water += right_max - height[right]

        return water


"""
class Solution:
    def trap(self, height: List[int]) -> int:
        left_max,right_max = 0,0
        l,r = 0,len(height)-1
        ans=0

        while l<r:
            if height[l] < height[r]:
                if height[l] >= left_max:
                    left_max=height[l]
                else:
                    ans+=left_max-height[l]
                l+=1
            else:
                if height[r] >= right_max:
                    right_max=height[r]
                else:
                    ans+=right_max-height[r]
                r-=1
        return ans
"""
# 4. Median of Two Sorted Arrays

class Solution4:
    def findMedianSortedArrays(self, nums1, nums2):
        merged = sorted(nums1 + nums2)
        merged.sort()

        total = len(merged)

        if total % 2 == 1:
            return float(merged[total // 2])
        else:
            mid1 = merged[total // 2 - 1]
            mid2 = merged[total // 2]
            return (float(mid1) + float(mid2)) / 2.0
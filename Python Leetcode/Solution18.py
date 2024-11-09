# 18. 4Sum

class Solution18:
    def fourSum(self, nums, target):
        nums.sort()
        res = []

        # initialize the first element
        for i in range(len(nums)-3):
            # remove duplicates
            if i > 0 and nums[i] == nums[i-1]:
                continue
            
            # initialize the second element
            for j in range(i+1, len(nums)-2):
                # remove duplicates
                if j > i+1 and nums[j] == nums[j-1]:
                    continue
                
                # left and right pointers for the rest of array
                l, r = j+1, len(nums)-1
                
                while l < r:
                    # calculate sum
                    total = nums[i] + nums[j] + nums[l] + nums[r]
                    
                    # check sum
                    if total < target:
                        l += 1
                    
                    elif total > target:
                        r -= 1

                    else:
                        # if match, then add it to result
                        res.append([nums[i], nums[j], nums[l], nums[r]])

                        # if there are still elements left and have duplicate
                        while l < r and nums[l] == nums[l+1]:
                            l += 1
                        while l < r and nums[r] == nums[r-1]:
                            r -= 1
                        
                        # move pointers to next unique elements
                        l += 1
                        r -= 1

        return res
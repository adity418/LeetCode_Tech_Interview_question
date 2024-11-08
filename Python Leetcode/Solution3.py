# 3. Longest Substring Without Repeating Characters

class Solution3:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        maxlength = 0
        charSet = set()
        left = 0

        for right in range(n):
            if s[right] not in charSet:
                charSet.add(s[right])
                maxlength = max(maxlength, right - left + 1)
            else:
                while s[right] in charSet:
                    charSet.remove(s[left])
                    left += 1
                charSet.add(s[right])
        return maxlength
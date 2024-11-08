# 28. Find the Index of the First Occurrence in a String

class Solution28:
    def strStr(self, haystack, needle):
        if len(haystack) < len(needle):
            return -1
        
        for i in range(len(haystack)):
            if haystack[i:i + len(needle)] == needle:
                return i
            
        return -1
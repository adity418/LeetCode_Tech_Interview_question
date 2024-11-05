# 20. Valid Parantheses

"""
class Solution:
    def isValid(self, s):
        stack = []
        mapping = {")" : "(", "}" : "{", "]" : "["}

        for char in s:
            if char in mapping.values():
                stack.append(char)
            elif char in mapping.keys():
                if not stack or mapping[char] != stack.pop():
                    return False
        
        return not stack
"""
    

class Solution:
    def isValid(self, s):
        d = {'(':')', '{':'}','[':']'}
        stack = []

        for i in s:
            if i in d:
                stack.append(i)
            elif len(stack) == 0 or d[stack.pop()] != i:
                return False
        return len(stack) == 0
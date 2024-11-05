# 22. Generate Parentheses
# Given n pairs of parentheses, write a function to 
# generate all combinations of well-formed parentheses.

class Solution:
    def generatParantheses(n):
        res = []

        def dfs(openP, closeP, s):
            if openP == closeP and openP + closeP == n * 2:
                res.append(s)
                return
            
            if openP < n:
                dfs(openP + 1, closeP, s + "(")
            
            if closeP > openP:
                dfs(openP, closeP + 1, ")")

        dfs(0, 0, "")

        return res
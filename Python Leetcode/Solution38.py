# 38. Count and Say

class Solution38:
    def countAndSay(self, n):
        s = "1"

        for i in range(2, n+1):
            s = self.final(s)
        
        return s
    
    def final(self, s):
        result = []
        c = s[0]
        cnt = 1

        for i in range(1, len(s)):
            if s[i] == c:
                cnt += 1
            else:
                result.append(cnt)
                result.append(c)
                c = s[i]
                cnt = 1

        result.append(cnt)
        result.append(c)

        return ''.join(result)

    
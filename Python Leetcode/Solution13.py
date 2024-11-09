# 13. Roman to Integer

class Solution13(object):
    def romanToInt(self, s):
        char_to_num = {'I': 1,'V': 5,'X': 10,'L': 50,"C" : 100,"D" : 500,"M" : 1000}
        total = 0
        for i in range( len(s)):
            if i < len(s)-1 and char_to_num[s[i]] < char_to_num[s[i+1]]:
                total-= char_to_num[s[i]]
            else:
                total+= char_to_num[s[i]]
        return total
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        l = 0
        if s== "":
            return True
        for r in range(len(t)):
            if l >= len(s):
                break
            if t[r] == s[l]:
                l += 1
        if l == len(s):
            return True
        else:
            return False
            
            
        
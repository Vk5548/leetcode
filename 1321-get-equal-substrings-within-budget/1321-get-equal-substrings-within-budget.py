class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        left = currCost = 0
        length = 0
        maxlen = -sys.maxsize - 1
        for right in range(len(s)):
            currCost += abs(ord(s[right]) - ord(t[right]))
            length += 1
            while currCost > maxCost:
                length -= 1
                currCost -= abs(ord(s[left]) - ord(t[left]))
                left += 1
            maxlen = max(maxlen, length)
        return maxlen

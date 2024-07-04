class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        dct = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}
        maxVowels = sum(1 for i in range(k) if s[i] in dct)
        currVowels = maxVowels

        for right in range(k, len(s)):
            if s[right] in dct:
                currVowels += 1
            if s[right - k] in dct:
                currVowels -= 1
            maxVowels = max(maxVowels, currVowels)
        return maxVowels

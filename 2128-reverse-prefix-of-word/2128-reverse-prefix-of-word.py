class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        try:
            idx = word.index(ch)
            subs = word[:idx + 1]
            result = word[idx + 1:]
            for ch in subs:
                result = ch + result
            return result
            print(idx)    
        except ValueError:
            return word

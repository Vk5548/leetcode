class Solution:
    def reverseWords(self, s: str) -> str:
        lst = s.split(' ')
        
        def reverse(word:str):
            return word[::-1]
        lst = [reverse(word) for word in lst]
        return ' '.join(lst)
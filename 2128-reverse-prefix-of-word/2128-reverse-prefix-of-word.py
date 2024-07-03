class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        lst = list(word)
        flag = False
        for right in range(len(lst)):
            if lst[right] == ch:
                flag = True
                break
        print(right)
        if not flag:
            return ''.join(lst)
        if flag:
            left = 0
            while left <= right:
                lst[left], lst[right] = lst[right], lst[left]
                left+= 1
                right -= 1
        return ''.join(lst)
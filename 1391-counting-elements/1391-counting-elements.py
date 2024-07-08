class Solution:
    def countElements(self, arr: List[int]) -> int:
        st = set(arr)
        res = 0
        for n in arr:
            if n + 1 in st:
                res += 1
        return res

        
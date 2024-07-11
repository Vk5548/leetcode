from collections import defaultdict;

class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        dct = defaultdict(int)
        for n in nums:
            dct[n] += 1
        max_val = -1
        for key, val in dct.items():
            if val == 1:
                max_val = max(max_val, key)
        return max_val
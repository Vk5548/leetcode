from collections import defaultdict
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dct = defaultdict(int)
        dct[0] = 1
        ans = curr = 0
        for n in nums:
            curr += n
            ans += dct[curr - k]
            dct[curr] += 1
        return ans
        
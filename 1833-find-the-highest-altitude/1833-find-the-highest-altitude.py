class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        res = []
        res.append(0)
        for index, num in enumerate(gain):
            res.append(res[index] + num)
        print(res)
        return max(res)

class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        if k == 0:
            return nums
        if len(nums) < 2*k + 1:
            return [-1]*len(nums)
        prefix = [nums[0]]
        for i in range(1, len(nums)):
            prefix.append(nums[i] + prefix[len(prefix) - 1])
        
        avgs = [-1] * k # since its 0th-indexed
        for i in range(k, len(nums) - k):
            if i-k != 0:
                val = (prefix[i+k] - prefix[i-k-1]) // (2 * k +1)
            else:
                val = prefix[i+k] // (2 * k +1)
            avgs.append(val)
        
        for j in range(i+1, len(nums)):
            avgs.append(-1)
        return avgs
        
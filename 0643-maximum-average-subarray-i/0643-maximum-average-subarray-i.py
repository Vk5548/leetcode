class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        curr = 0
        left = 0
        summ = 0
        for i in range(k):
            summ += nums[i]
        curr = summ
        ans = curr
        for i in range(k, len(nums)):
            summ += nums[i] - nums[i-k]
            
            curr = summ
            ans = max(ans, curr)
        return ans / k
            
            
        
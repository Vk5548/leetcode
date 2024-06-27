class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        prefix_sum = [nums[0]]
        mini = nums[0]
        for i in range(1, len(nums)):
            prefix_sum.append(nums[i] + prefix_sum[len(prefix_sum)-1])
            mini = min(mini, prefix_sum[i])
        print(mini)
        if mini < 0:
            return abs(mini -1)
        return 1
            
        
            
        
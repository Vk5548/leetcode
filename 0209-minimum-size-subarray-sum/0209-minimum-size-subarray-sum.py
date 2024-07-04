class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = currsum = 0
        mini = sys.maxsize
        for right in range(len(nums)):
            currsum += nums[right]
            if currsum < target:
                continue
            while currsum >= target:
                mini = min(mini, right - left + 1)
                currsum -= nums[left]
                left += 1
        if mini == sys.maxsize:
            return 0
        return mini     
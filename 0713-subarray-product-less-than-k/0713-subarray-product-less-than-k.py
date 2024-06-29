class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1:
            return 0
        curr = 1
        left = 0
        ans = 0
        for right in range(len(nums)):
            curr *= nums[right]
            while curr >= k and left <= right:
                curr //= nums[left]
                left += 1
            ans += right - left + 1
        return ans
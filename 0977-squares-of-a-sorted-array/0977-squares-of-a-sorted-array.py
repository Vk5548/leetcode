class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        left, right, idx  = 0, len(nums) - 1, len(nums) - 1
        res = [-1 for _ in range(0, len(nums))] # using list comprehension
        print(res)
        
        while left <= right:
            if abs(nums[left]) <= abs(nums[right]):
                res[idx] = nums[right] ** 2
                right -= 1
            else:
                res[idx] = nums[left] ** 2
                left += 1
            idx -= 1
        return res
                
        
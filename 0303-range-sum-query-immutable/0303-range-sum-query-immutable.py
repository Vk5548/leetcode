class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.prefix = []
        self.prefix.append(self.nums[0]) 
        for i in range(1, len(nums)):
            self.prefix.append(self.prefix[-1] + nums[i])
        print(self.prefix)

    def sumRange(self, left: int, right: int) -> int:
        if left == 0:
            return self.prefix[right]
        return self.prefix[right] - self.prefix[left - 1]

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)
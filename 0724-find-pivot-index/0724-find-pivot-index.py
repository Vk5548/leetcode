class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        front = []
        rear = []
        front.append(nums[0])
        rear.append(nums[len(nums) - 1])
        for i in range(1, len(nums)):
            front.append(front[-1] + nums[i])
        print(front)
        for i in range(len(nums) - 2, -1, -1):
            rear = [rear[0] + nums[i]] + rear
        print(rear)
        for i in range(len(nums)):
            if rear[i] == front[i]:
                return i
        return -1

        
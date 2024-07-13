class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        diff_index_dct = {}
        diff_index_dct[0]= -1
        max_len = runningSum = 0
        for right in range(len(nums)):
            if nums[right] == 0:
                runningSum -= 1
            else:
                runningSum += 1
            if runningSum in diff_index_dct:
                max_len = max(max_len, right - diff_index_dct[runningSum])
            else:
                diff_index_dct[runningSum] = right
        return max_len

        
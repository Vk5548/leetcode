class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        length = len(nums)
        bit_map = [0 for _ in range(101)]
        rem = 0
        for n in nums:
            bit_map[n] = not bit_map[n]
        for bit in bit_map:
            if bit:
                rem +=1
            
        return [(length - rem)//2, rem]

        
        
class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        dct = dict()
        min_val = len(cards) + 1
        
        for (index, val) in enumerate(cards):
            if val in dct:
                min_val = min(min_val, index - dct[val] + 1)
            dct[val] = index
        print(min_val)
        if min_val >= len(cards) + 1:
            return -1
        return min_val

        
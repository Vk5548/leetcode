class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        dct = dict()
        min_val = float(inf)
        
        for (index, val) in enumerate(cards):
            if val in dct:
                min_val = min(min_val, index - dct[val] + 1)
            dct[val] = index
        print(min_val)
        return -1 if min_val == float(inf) else min_val
        
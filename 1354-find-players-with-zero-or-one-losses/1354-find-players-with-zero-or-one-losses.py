from collections import defaultdict;

class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        loss = defaultdict(int)
        for n in matches:
            loss[n[1]] += 1
            if n[0] not in loss:
                loss[n[0]] = 0
        
        zero_losses = []
        one_loss = []

        for key, val in loss.items():
            if val == 0:
                zero_losses.append(key)
            if val == 1:
                one_loss.append(key)
        return [sorted(zero_losses), sorted(one_loss)]  #  need to capture the result as sorted(); does not sort in-place
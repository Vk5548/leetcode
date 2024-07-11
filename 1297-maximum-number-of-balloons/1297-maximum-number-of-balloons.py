class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        dct = {'b':0, 'a': 0, 'l': 0, 'o' : 0, 'n': 0}
        mini = sys.maxsize
        for t in text:
            if t in dct:
                dct[t] += 1
        
        for (key, val) in dct.items():
            if key == 'l' or key == 'o':
                val //= 2
            else:
                val
            mini = min(mini, val)
        return mini


        
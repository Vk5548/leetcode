/*
int num; swap 2 digits at most once to get the maximum valued ans

I/p: 2736: 7236
I/p: 9973: No swap needed

A1: /  and % to the number, get the digits and their location,
goal is to get the max didgit, at start as possible?, right

I: 2736
itr 1 6, rem, 
maxDigit 6:, tuple , minDigit (Digit and its index)
maxDigit 6

 */
class Solution {
    static class DigitIdx {
        int num;
        int idx;
        DigitIdx() {}
        DigitIdx(int _num, int _idx) {
            num = _num;
            idx = _idx;
        }
    }

    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int n = arr.length;

        DigitIdx max = new DigitIdx(arr[n - 1] - '0', n - 1);
        DigitIdx left = null, right = null;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            int digit = arr[i] - '0';

            if (digit > max.num) {
                max = new DigitIdx(digit, i); // update max
            } else if (digit < max.num) {
                left = new DigitIdx(digit, i);
                right = new DigitIdx(max.num, max.idx);
            }
        }

        // Only swap if a valid pair was found
        if (left != null && right != null) {
            char temp = arr[left.idx];
            arr[left.idx] = arr[right.idx];
            arr[right.idx] = temp;
        }

        return Integer.parseInt(String.valueOf(arr));
    }
}

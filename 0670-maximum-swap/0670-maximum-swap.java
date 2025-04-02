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
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();

        int[] lastIdx = new int [10];
        Arrays.fill(lastIdx, -1);

        int n = digits.length;
        for(int i = 0; i < n; i++){
            char c = digits[i];
            lastIdx[c - '0'] = i;
        }// got the lastindex of theat digits

        for(int i = 0; i < n; i++){
            int curr = digits[i] - '0'; //for each digit
            for(int j = 9; j > curr; j--){ // I will check if the greater digit is possible for idx > i
                if( lastIdx[j] > i){
                    char temp = digits[i];
                    digits[i] = digits[lastIdx[j]];
                    digits[lastIdx[j]] = temp;
                    return Integer.parseInt(String.valueOf(digits));
                }
            }
        }

        return num;
    }
}

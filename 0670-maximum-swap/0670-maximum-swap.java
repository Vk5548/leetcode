/* 
Given a num:, swap at most once: 2 digits 
to get the max valued answer

I : 2736 -> 7236

A1: To keep track of the digits and their last seen index
and since there are only 10 digits
arr[10];

I am iter throu num, will convert it into arr
and then for the current digit, I will find the largest digit and its index and then swap and return
*/

class Solution {
    public int maximumSwap(int num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int[] lastSeenIdx = new int[10]; // 0 to 9
        for(int i =0; i < numArr.length; i++){
            char c = numArr[i];
            lastSeenIdx[c - '0'] = i;
        } // got the arra filled with last indexes

        for(int i = 0; i < numArr.length; i++){
            char c = numArr[i];
            int curr = c - '0';

            // iterate through the digits in reverse manner
            for(int j = 9; j > curr; j--){
                if(lastSeenIdx[j] > i){ //idx of the digit > current idx; then swap
                    char temp = numArr[i];
                    numArr[i] = (char) (j + '0');
                    numArr[lastSeenIdx[j]] = temp;
                    return Integer.parseInt(new String(numArr));
                }
            }
        }
        return num;

    }
}
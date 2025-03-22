

import static java.lang.Math.random;

/** 
w w[i] > 0, w[i] = wt of ith Index

pickIndex: pucks random index in the array's range and returns It
w[i] / sum (w)
*/

class Solution {
    private int total;
    private int[] prefixSum; 
    private Random rand;
    public Solution(int[] w) {
        prefixSum = new int[w.length];
        total = 0;
        rand = new Random();
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
        total = prefixSum[w.length - 1];
    }
    
    public int pickIndex() {
        int target = rand.nextInt(total) + 1;
        int l = 0, r = prefixSum.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if(target > prefixSum[mid]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
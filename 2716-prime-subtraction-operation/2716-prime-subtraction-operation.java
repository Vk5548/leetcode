class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > prev) {
                int maxP = nums[i] - prev - 1;
                if (maxP >= 2) {
                    int p = findLargestPrime(maxP);
                    if (p > 0) {
                        nums[i] -= p;
                    }
                }
            }
            if (nums[i] <= prev) {
                return false;
            }
            prev = nums[i];
        }
        return true;
    }

    private int findLargestPrime(int maxP) {
        // Start from maxP and go down to 2
        for (int p = maxP; p >= 2; p--) {
            if (isPrime(p)) {
                return p;
            }
        }
        return -1;
    }

    private boolean isPrime(int num){
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for(int i = 5; i * i <= num; i += 6){
            if(num % i == 0 || num % (i + 2) == 0){
                return false;
            }
        }
        return true;
    }
}

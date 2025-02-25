class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int right = Arrays.stream(nums).max().getAsInt();
        int left = 1;
        int ctr = 0;
        while (left < right){
            int mid = left + (right - left)/2;
            System.out.print("counter :  "+ ctr++);
            System.out.println(mid);
            if(check(mid, threshold, nums)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean check(int mid, int threshold, int[] nums){
        int ans = 0;
        for(int num : nums){
            ans += (num + mid - 1)/ mid;
        }
        return ans<= threshold;
    }
}
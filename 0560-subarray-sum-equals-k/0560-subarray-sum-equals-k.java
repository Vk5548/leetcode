class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int curr =0, ans = 0;
        freq.put(0, 1);
        for(int i : nums){
            curr += i;
            if(freq.containsKey(curr - k)){
                ans += freq.get(curr - k);
            }
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}
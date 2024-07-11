class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }
        int maximum = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            if (entry.getValue() == 1){
                maximum = Math.max(maximum, entry.getKey());
            }
        }
        return Math.max(maximum, -1);
    }
}
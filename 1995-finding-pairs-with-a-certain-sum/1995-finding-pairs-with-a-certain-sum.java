class FindSumPairs {

    int[] nums1, nums2;
    Map<Integer, Integer> nums2Freq = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int num: nums2){
            nums2Freq.put(num, nums2Freq.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldVal = nums2[index];
        nums2Freq.put(oldVal, nums2Freq.get(oldVal) - 1);
        if(nums2Freq.get(oldVal) == 0)
            nums2Freq.remove(oldVal);
        nums2[index] += val;
        nums2Freq.put(nums2[index], nums2Freq.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int res = 0;
        
        for(int num : nums1){
            int temp = tot;
            if(nums2Freq.containsKey(temp- num)){
                res += nums2Freq.get(temp - num);
            }
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
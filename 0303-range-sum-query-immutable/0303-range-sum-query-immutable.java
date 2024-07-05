class NumArray {
    int[] prefix;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.prefix = new int[nums.length];
        int curr = 0;
        for(int i = 0 ; i < nums.length; i++){
            curr += nums[i];
            this.prefix[i] = curr;
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0)
            return this.prefix[right];
        return this.prefix[right] - this.prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        this.prefix = new int[nums.length];
        this.prefix[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            this.prefix[i] = this.prefix[i-1] + nums[i];
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
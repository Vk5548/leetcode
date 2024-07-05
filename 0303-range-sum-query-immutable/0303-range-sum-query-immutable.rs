struct NumArray {
    prefix :Vec<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl NumArray {

    fn new(nums: Vec<i32>) -> Self { // This is how we define constructor in Rust*** Important
        let mut prefix = vec![0; nums.len()];  //vec![0, nums.len()] ;> this initializes vector with 2 values
        // and the correctone is non-commented; it says size is nums.len() and fill it with '0's
        prefix[0] = nums[0];
        for i in 1..nums.len(){
            prefix[i] = prefix[i-1] + nums[i];
        }

        NumArray {prefix}
    }
    
    fn sum_range(&self, left: i32, right: i32) -> i32 {
        let left = left as usize;
        let right = right as usize;
        if left == 0{
            self.prefix[right]
        }else{
            self.prefix[right] - self.prefix[left-1]
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * let obj = NumArray::new(nums);
 * let ret_1: i32 = obj.sum_range(left, right);
 */
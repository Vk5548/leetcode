use std::collections::HashMap;
struct FindSumPairs {
    nums1 :Vec<i32>,
    nums2 : Vec<i32>,
    nums2_freq : HashMap<i32, i32>
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl FindSumPairs {

    fn new(nums1: Vec<i32>, nums2: Vec<i32>) -> Self {
        let mut nums2_freq = HashMap::new();
        for &num in &nums2{
            *nums2_freq.entry(num).or_insert(0)+=1;
        }
        FindSumPairs {nums1, nums2, nums2_freq}
    }
    
    fn add(&mut self, index: i32, val: i32) {
        let old_val = self.nums2[index as usize];
        let new_val = old_val + val;

        if let Some(freq) = self.nums2_freq.get_mut(&old_val){
            *freq -= 1;
            if *freq == 0{
                self.nums2_freq.remove(&old_val);
            }
        }

        *self.nums2_freq.entry(new_val).or_insert(0) += 1;
        self.nums2[index as usize] = new_val;
    }
    
    fn count(&self, tot: i32) -> i32 {
        let mut res = 0;
        for &num in &self.nums1{
            let comp = tot - num;
            if let Some(&freq) = self.nums2_freq.get(&comp){
                res += freq;
            }
        }
        res
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * let obj = FindSumPairs::new(nums1, nums2);
 * obj.add(index, val);
 * let ret_2: i32 = obj.count(tot);
 */
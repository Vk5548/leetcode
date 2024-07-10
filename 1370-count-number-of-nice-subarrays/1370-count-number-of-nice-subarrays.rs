use std::collections::HashMap;
impl Solution {
    pub fn number_of_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        let mut mp : HashMap<i32, i32> = HashMap::new();
        mp.insert(0, 1);
        let mut ans = 0;
        let mut curr = 0;
        let mut count = 0;
        for &n in &nums{
            println!("n is {}", n);
            if n % 2 != 0{
                curr += 1;
                println!("curr is {}", curr);
            }
            if let Some(&val) = mp.get(&(curr - k)){
                ans += val;
                println!("ans : {}", ans);
            }
            *mp.entry(curr).or_insert(0) += 1;
            
        }
        ans
    }
}
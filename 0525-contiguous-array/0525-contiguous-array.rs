use std::collections::HashMap;
impl Solution {
    pub fn find_max_length(nums: Vec<i32>) -> i32 {
        let mut diffIndexMap : HashMap<i32, i32> = HashMap::new(); // difference, index of its first occurence
        let mut runningSum = 0;
        let mut maxLength = 0;
        diffIndexMap.insert(0, -1);
        for (right, &num) in nums.iter().enumerate(){
            if num == 0{
                runningSum -= 1;
            }else{
                runningSum += 1;
            }
            if let Some(&diff) = diffIndexMap.get(&runningSum){
                maxLength = maxLength.max(right as i32 - diff);
            }else{
                diffIndexMap.insert(runningSum, right as i32);
            }
        }
        maxLength
    }
}
use std::collections::HashMap;
impl Solution {
    pub fn next_greater_element(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        let mut monoDecStack : Vec<i32> = Vec::new();
        let mut nextGE : HashMap<i32, i32> = HashMap::new();
        let mut res: Vec<i32> = Vec::new();

        for &num in nums2.iter().rev(){
            while let Some(&top) = monoDecStack.last(){
                if top < num{
                    monoDecStack.pop();
                }
                else{
                    nextGE.insert(num, top);
                    break;
                }
            }
            //first entry
             nextGE.entry(num).or_insert(-1);
             monoDecStack.push(num);
        }

        for &num in nums1.iter(){
            res.push(*nextGE.get(&num).unwrap_or(&-1));
        }
        res
    }
}
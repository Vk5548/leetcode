use std::collections::HashMap;
impl Solution {
    pub fn find_winners(matches: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        let mut lossMap : HashMap<i32, i32> = HashMap::new();

        for i in matches{
            *lossMap.entry(i[1]).or_insert(0) += 1;
            if !lossMap.contains_key(&i[0]){
                lossMap.entry(i[0]).or_insert(0);
            }
        }

        let mut zero_losses = Vec::new();
        let mut one_loss = Vec::new();

        for (&key, &val) in lossMap.iter(){
            if val == 0{
                zero_losses.push(key);
            }
            if val == 1{
                one_loss.push(key);
            }
        }
        zero_losses.sort();
        one_loss.sort();

        vec![zero_losses, one_loss]
        
    }
}
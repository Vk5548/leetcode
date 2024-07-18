use std::collections::HashMap;
impl Solution {
    pub fn minimum_card_pickup(cards: Vec<i32>) -> i32 {
        let mut val_index_map : HashMap<i32, usize> = HashMap::new();
        let mut consective_min_len = cards.len() + 1;
        for (index, &val) in cards.iter().enumerate(){
           if let Some(&prev_index) = val_index_map.get(&val){
             consective_min_len = consective_min_len.min(index - prev_index + 1) 
           }
           val_index_map.insert(val, index);
        }
        if consective_min_len < cards.len() + 1{
            consective_min_len as i32
        }else{
            -1
        }
    }
}

//
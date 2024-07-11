
use std::collections::HashMap;
impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        let mut instances : HashMap<char, i32> = HashMap::new();
        instances.insert('b', 0);
        instances.insert('a', 0);
        instances.insert('l', 0);
        instances.insert('o', 0);
        instances.insert('n', 0);
        for t in text.chars(){
            if instances.contains_key(&t){
                *instances.entry(t).or_insert(0) += 1;
            }
        }

        let mut word = 0;
        let mut mini = i32::MAX;
        let size = instances.len();
        for (&key, &val) in &instances{
            let true_val = if key == 'l' || key == 'o' {
                val / 2
            } else {
                val
            };
            mini = mini.min(true_val);
        }
        if mini == i32::MAX{
            -1
        }else{
            mini
        }
    }
}
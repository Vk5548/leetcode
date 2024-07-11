
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

// Character to Index Conversion:
// ch as u8: Converts the character ch to its ASCII byte value.
// b'a': Represents the ASCII value of the character 'a'.
// ch as u8 - b'a': Calculates the zero-based index for the character, where 'a' maps to 0, 'b' maps to 1, and so on.
// as usize: Converts the resulting index to usize because array indexing in Rust requires usize type.

// pub fn max_number_of_balloons(text: String) -> i32 {
    //     let mut freq = [0; 26];
    //     for ch in text.chars() {
    //         freq[(ch as u8 - b'a') as usize] += 1;
    //     }

    //     let mut ans = 0;
    //     'out: loop {
    //         for ch in "balloon".chars() {
    //             let i = (ch as u8 - b'a') as usize;
    //             if freq[i] == 0 {
    //                 break 'out;
    //             }

    //             freq[i] -= 1;
    //         }
    //         ans += 1;
    //     }

    //     ans
    // }
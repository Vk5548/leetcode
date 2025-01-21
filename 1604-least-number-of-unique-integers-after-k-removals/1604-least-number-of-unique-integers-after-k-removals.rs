use std::collections::HashMap;

impl Solution {
    pub fn find_least_num_of_unique_ints(arr: Vec<i32>, k: i32) -> i32 {
        // Step 1: Count the frequency of each element in the array
        let mut freq_map = HashMap::new();
        for &num in arr.iter() {
            *freq_map.entry(num).or_insert(0) += 1;
        }
        
        // Step 2: Collect the frequencies and sort them in ascending order
        let mut freq_list: Vec<i32> = freq_map.values().cloned().collect();
        freq_list.sort();
        
        // Step 3: Remove elements based on their frequency
        let mut removed = 0;
        let mut remaining_unique = freq_list.len();
        
        for freq in freq_list {
            if removed + freq <= k {
                removed += freq;
                remaining_unique -= 1;  // We've removed one unique element
            } else {
                break;  // No more elements to remove
            }
        }
        
        // Step 4: Return the remaining number of unique integers
        remaining_unique as i32
    }
}

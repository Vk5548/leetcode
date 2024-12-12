use std::collections::BinaryHeap;

impl Solution {
    pub fn repeat_limited_string(s: String, repeat_limit: i32) -> String {
        // getting the frequency of the characters in the s
        // will store them in an array 
        let mut freq = vec![0; 26]; // vec filled with 0's and size 26

        //iterating over string s
        for ch in s.chars(){
            freq[(ch as u8 - b'a') as usize] += 1;
        }//got the frequencies of the characters

        //putting them in the heap
        let mut heap = BinaryHeap::new();
        //will put the character and the freqin the heap
        for i in 0..26{
            if freq[i] > 0{// if the char is present
                heap.push((b'a' + i as u8, freq[i]));
            }
        } // got all the tuple(char, freq) in BinaryHeap

        let mut result = Vec::new();
        while let Some((ch, mut count)) = heap.pop(){ //getting the lexicographically the largest character
            let append_count = count.min(repeat_limit); //gets the count to be added
            result.extend(std::iter::repeat(ch as char).take(append_count as usize));
            count -= append_count; //to see if there are still remaining characters

            if count > 0{ // menaing we will still need to use this character to get the required result
                if let Some((next_ch, mut next_count)) = heap.pop(){ // gettting the next lexicographically larger character
                    result.push(next_ch as char);
                    next_count -= 1;

                    if next_count > 0{
                        heap.push((next_ch, next_count));
                    }
                }else{
                    break;
                }
                heap.push((ch, count));
            }

        }
        result.into_iter().collect()
    }
}
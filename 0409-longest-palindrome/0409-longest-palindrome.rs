

impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        if s.len() == 1{
            return 1;
        }

        let mut freq = vec![0; 128];

        for byte in s.into_bytes(){
            freq[byte as usize] += 1;
        }

        let mut length = 0;
        let mut ifOdd = 0;
        for count in freq.iter(){
            if *count % 2 == 0{
                length += count;
            }else{
                length += count - 1;
                ifOdd = 1;
            }
        }
         if ifOdd == 1{
            length += 1;
         }

         length
        

    }
}
impl Solution {
    pub fn get_smallest_string(n: i32, k: i32) -> String {
        //result_string
        let mut result = vec!['a' ; n as usize]; // of size n

        //calculate the extra
        let mut extra = k - n;

        let mut i = n as usize -1;

        while extra > 0 {
            let add = extra.min(25); //sice at-most 25 can be added to make it to z

            result[i] = (result[i] as u8 + add as u8) as char;

            extra -= add;

            if extra <= 0{
                break;
            }
            i -= 1;
        } 
        result.into_iter().collect()

    }
}
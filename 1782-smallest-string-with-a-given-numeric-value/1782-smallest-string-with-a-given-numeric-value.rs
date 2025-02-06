impl Solution {
    pub fn get_smallest_string(mut n: i32, mut k: i32) -> String {
        let mut res = Vec::with_capacity(n as usize);

        while n < k { //counting for the extra variables
            let curr = (k - n).min(25);
            //add the curr character to the end
            res.push(b'a'  + curr as u8) ;
            k -= curr + 1;
            n -= 1;
        }
        res.extend(std::iter::repeat(b'a').take(n as usize));
        res.reverse();
        String::from_utf8(res).unwrap()
    }
}
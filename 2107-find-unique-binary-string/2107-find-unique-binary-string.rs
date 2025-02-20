impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        let mut res: Vec<char> = Vec::new();
        for (i ,string) in nums.iter().enumerate(){
            //converting the ith character of this string
            //get the ith character of thsi string
            let c = string.chars().nth(i).unwrap();
            if c == '0'{
                res.push('1');
            }else{
                res.push('0');
            }
        }
        res.into_iter().collect::<String>()
    }
}
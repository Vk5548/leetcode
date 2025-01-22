impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        let mut nums: Vec<char> = num.to_string().chars().collect();
        for c in nums.iter_mut(){
            if *c == '6'{
                *c = '9';
                break;
            }
        }
        nums.iter().collect::<String>().parse().unwrap()
    }
}
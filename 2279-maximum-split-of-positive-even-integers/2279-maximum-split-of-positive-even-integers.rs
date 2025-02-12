impl Solution {
    pub fn maximum_even_split(final_sum: i64) -> Vec<i64> {
        if final_sum % 2 == 1{
            return vec![];
        }

        let mut res = Vec::new();

        let mut curr_num = 2;
        let mut remainder = final_sum;

        while remainder >= curr_num{
            res.push(curr_num);
            remainder -= curr_num;
            curr_num += 2;
        }

        // if there is aremainder remaining
        if let Some(last_num) = res.last_mut(){
            *last_num += remainder; //making it unique
        }
        res
    }
}
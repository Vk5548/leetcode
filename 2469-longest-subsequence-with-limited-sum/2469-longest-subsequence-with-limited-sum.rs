impl Solution {
    pub fn answer_queries(mut nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        nums.sort_unstable();
        //calculate the running sum : in-place

        // for i in 1..nums.len(){
        //     nums[i] += nums[i-1];
        // }// will give me the running sum

        nums = nums.into_iter().scan(0, |acc, num|{
            *acc += num;
            Some(*acc)
        }).collect();

        let length = nums.len();

       

        queries.into_iter().map(|q| Self::binary_search_helper(q, length, &nums)).collect()
    }

    fn binary_search_helper(target: i32, length : usize, nums: &[i32]) -> i32{
        let mut left = 0;
        let mut right = length;
        let mut res = 0; //to be sent back

        while left < right{
            let mid = left + (right - left) / 2;
            if nums[mid] == target {
                return mid as i32 + 1;
            }
            if nums[mid] >= target{
                right = mid;
            }else{
                left = mid + 1;
            }

        }//or we can just use partition as well
        left as i32  
    }
}
impl Solution {
    pub fn num_rescue_boats(mut people: Vec<i32>, limit: i32) -> i32 {
        if people.is_empty(){
            return 0;
        }
        people.sort_unstable();
        let mut boats = 0;
        let mut left = 0;
        let mut right = people.len() - 1;
        while left < right {
            if left != right && people[left] + people[right] <= limit { // can be paired
                left += 1;
            }

            right -= 1;
            boats += 1;
        }
        if left == right{
            boats += 1;
        }
        boats
    }
}
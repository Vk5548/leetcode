impl Solution {
    pub fn num_rescue_boats(mut people: Vec<i32>, limit: i32) -> i32 {
        if people.is_empty(){
            return 0;
        }
        people.sort_unstable();
        let mut num_boats = 0;
        let mut right = people.len() - 1;
        let mut left = 0;

        while left < right {
            num_boats += 1; //regardless, because heavier are gonna go anyways
            if people[left] + people[right] <= limit{ //paired
                left += 1;
            }

            right -= 1;
        }
        
        if left == right{
            num_boats += 1;
        }
        num_boats
    }
}

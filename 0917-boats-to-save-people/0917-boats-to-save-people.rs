impl Solution {
    pub fn num_rescue_boats(mut people: Vec<i32>, limit: i32) -> i32 {
        if people.is_empty(){
            return 0;
        }
        people.sort_unstable(); // Sort people by weight
        let mut left = 0; // Start pointer (lightest person)
        let mut right = people.len() - 1; // End pointer (heaviest person)
        let mut num_boats = 0; // Boat counter

        
        while left <= right {
            println!("left: {}, right: {}", left, right); 
            if people[left] + people[right] <= limit {
                // If the lightest and heaviest person can fit in one boat, pair them
                left += 1;
            }
            // Either way, the heaviest person goes on the boat
            
            
            num_boats += 1; // Increment the boat counter
            if right == 0{
                break;
            }
            right -= 1;
        }
        
        num_boats // Return the total number of boats
    }
}

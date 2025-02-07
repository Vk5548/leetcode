impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        let mut left = 0;
        let mut right = height.len() - 1;
        let mut curr = 0;
        let mut max_area = 0;

        while left < right{
            let breadth = right - left;
            let curr_height = height[left].min(height[right]);
            curr = breadth as i32 * curr_height;
            println!("area {}", curr);
            max_area = max_area.max(curr);
            while height[left] <= curr_height && left < right{
                left += 1;
            }
            while height[right] <= curr_height && left < right{
                right -= 1;
            }
        }
        max_area
    }
}
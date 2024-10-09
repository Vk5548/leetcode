impl Solution {
    pub fn trap(height: Vec<i32>) -> i32 {
        let mut res = 0;
        let mut left = 0;
        let mut right = height.len() - 1;
        let mut leftMax = height[left];
        let mut rightMax = height[right];
        while left < right{
            if leftMax < rightMax{
                left += 1;
                leftMax = leftMax.max(height[left]);
                res += leftMax - height[left];
            }else{
                right -= 1;
                rightMax = rightMax.max(height[right]);
                res += rightMax - height[right];
            }
        }
        res
    }
}
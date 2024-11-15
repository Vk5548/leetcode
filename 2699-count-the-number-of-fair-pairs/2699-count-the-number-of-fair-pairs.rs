impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        let mut nums = nums;
        let n = nums.len();
        let mut lowerPairs = 0;
        let mut upperPairs = 0;
        nums.sort();
        let mut count : i64 = 0;

        for i in 0..n{
            lowerPairs = Self::lower_bound(&nums, i+1, n, lower - nums[i]);
            upperPairs= Self::upper_bound(&nums, i+1, n, upper - nums[i]);
            count += upperPairs - lowerPairs;
        }
        count
    }

    fn lower_bound(nums: &Vec<i32>, mut left : usize, mut right : usize, target: i32) -> i64{
        while left < right{
            let mid = left + (right - left)/2;
            if nums[mid] >= target{
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        left as i64
    }
    fn upper_bound(nums: &Vec<i32>, mut left : usize, mut right : usize, target: i32) -> i64{
        while left < right{
            let mid = left + (right - left)/2;
            if nums[mid] > target{
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        left as i64
    }

}
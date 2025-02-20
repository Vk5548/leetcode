impl Solution {
    pub fn min_eating_speed(piles: Vec<i32>, h: i32) -> i32 {
        let max_possible = piles.iter().max().unwrap();
        let mut left = 1;
        let mut right = *max_possible;

        if piles.len() == h as usize{
            return *max_possible;
        }
        while left < right{
            let mid = left + (right - left) / 2;
            if Self::check(&piles, mid, h){
                println!("{}", mid);
                right = mid;
            } else{
                left = mid + 1;
            }
            
        }
        left
    }
    fn check(piles: &[i32], k : i32, h:i32) -> bool{
        let mut curr = 0;
        for pile in piles.iter(){
            curr += (pile + k - 1)/k;
        }
        if curr <= h{
            return true;
        }
        false
    }
}
impl Solution {
    pub fn successful_pairs(spells: Vec<i32>, mut potions: Vec<i32>, success: i64) -> Vec<i32> {
        //sort the potions
        potions.sort_unstable();
        let mut res = vec![0; spells.len()];
        // to pair with each spells
        for (i, spell) in spells.iter().enumerate(){
            let mut left = 0;
            let mut right = potions.len();
            while left < right{
                let mid = left + (right - left)/2;
                //find the first number such that we get 
                if success <= (potions[mid] as i64 * *spell as i64)  {
                    right = mid;
                }else{
                    left = mid + 1;
                }
            }
            res[i] = (potions.len() - left) as i32;
        }
        res
    }
}
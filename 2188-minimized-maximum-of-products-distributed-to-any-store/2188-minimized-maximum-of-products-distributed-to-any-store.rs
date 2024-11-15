impl Solution {
   
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        // let mut quanitities  = quantitites;
        let mut left = 1;
        //get the max from the sorted 
        let mut right = *quantities.iter().max().unwrap();
        let mut res = right;
        while(left < right){
            let mid = left + (right - left)/2;
            
            if Self::can_distribute(&quantities, mid, n){
                right = mid;
                res = mid;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
    fn can_distribute(quantities : &Vec<i32>, k : i32, n : i32) -> bool {
        let mut required_quantitites = 0;

        for &quantity in quantities{
            required_quantitites += (quantity + k - 1) / k;
        }

        required_quantitites <= n
    }
}
impl Solution {
    pub fn largest_altitude(gain: Vec<i32>) -> i32 {
        let mut maxi = 0;
        let mut curr_altitude = 0;
        for g in gain{
            curr_altitude += g;
            maxi = maxi.max(curr_altitude);
        }
        maxi
    }
}
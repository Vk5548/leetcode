impl Solution {
    pub fn make_integer_beautiful(n: i64, target: i32) -> i64 {
        let mut digits: Vec<u8> = n.to_string().chars().map(|d| d.to_digit(10).unwrap() as u8).collect();
        // got the digit array

        //getting the sum of digits using a closure
        let sum_digits = |arr : i64| -> i64{
            // digits.iter().map(|&d| d as i64).sum()
            arr.to_string().chars().map(|d| d.to_digit(10).unwrap() as i64).sum()
        };



        if sum_digits(n) <= target as i64{
            return 0;
        }

        let mut total_addition = 0;

        let mut place = 1; // to signify the digits

        while sum_digits(n + total_addition) > target as i64{ // to check from right most digit and turning it to zero
            let current = n + total_addition;

            //let remainder
            let remainder = current % (place * 10);

            let add_here = place * 10 - remainder;

            total_addition += add_here;

            place *= 10;
        }

        total_addition
    }
}
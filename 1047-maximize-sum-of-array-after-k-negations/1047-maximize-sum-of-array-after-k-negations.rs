impl Solution {
    pub fn largest_sum_after_k_negations(mut A: Vec<i32>, mut k: i32) -> i32 {
        // Sort the array in ascending order.
        A.sort_unstable();

        // Flip as many negative numbers as possible.
        for i in 0..A.len() {
            if k > 0 && A[i] < 0 {
                A[i] = -A[i];
                k -= 1;
            }
        }

        // Calculate the sum and find the smallest absolute value.
        let sum: i32 = A.iter().sum();
        let min_abs = A.iter().map(|&x| x.abs()).min().unwrap();

        // If k is odd, subtract twice the smallest absolute value.
        if k % 2 == 1 {
            sum - 2 * min_abs
        } else {
            sum
        }
    }
}

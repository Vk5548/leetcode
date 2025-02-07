impl Solution {
    pub fn largest_palindromic(num: String) -> String {
        let mut counts = vec![0; 10];
        for c in num.chars() {
            counts[c.to_digit(10).unwrap() as usize] += 1;
        }
        
        // Build half of palindrome
        let mut result = Vec::new();
        let mut center = None;
        
        // Find digits for half (right to left)
        for i in (0..=9).rev() {
            // Use pairs of digits
            while counts[i] >= 2 {
                if !(result.is_empty() && i == 0) {  // Avoid leading zeros
                    result.push(i);
                    counts[i] -= 2;
                } else {
                    break;
                }
            }
            // Remember largest remaining single digit for center
            if counts[i] > 0 && center.is_none() {
                center = Some(i);
            }
        }
        
        // Handle empty result with remaining digits
        if result.is_empty() && center.is_none() {
            return "0".to_string();
        }
        
        // Convert to string
        let mut palindrome = String::new();
        
        // Add first half
        for &digit in result.iter() {
            palindrome.push_str(&digit.to_string());
        }
        
        // Add center if exists
        if let Some(mid) = center {
            palindrome.push_str(&mid.to_string());
        }
        
        // Add second half (reverse of first half)
        for &digit in result.iter().rev() {
            palindrome.push_str(&digit.to_string());
        }
        
        palindrome
    }
}
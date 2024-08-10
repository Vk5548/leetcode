impl Solution {
    pub fn is_palindrome(s: String) -> bool {
        let s :Vec<char> = s.chars()
                                    .filter(|c| c.is_alphanumeric())
                                    .map(|c| c.to_ascii_lowercase())
                                    .collect();
        if s.is_empty(){
            return true;
        }
        let mut r = s.len() - 1; // causing it to fail because of empty string
        let mut l = 0;
        while l < r{
            if s[l] != s[r]{
                return false;
            }
            l+= 1;
            r -= 1;
        }
        true
    }
}
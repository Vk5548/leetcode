class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;  // Handle the empty string case
        }

        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();

        while (l < r) {
            // Skip non-alphanumeric characters
            while (l < r && !Character.isLetterOrDigit(chars[l])) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(chars[r])) {
                r--;
            }

            // Compare characters
            if (Character.toLowerCase(chars[l]) != Character.toLowerCase(chars[r])) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}

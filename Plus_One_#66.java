class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len + 1];
        int carry = 0, remainder = 0;
        int sum = 0;
        for(int i = len - 1; i >= 0; i--){
            if(i == len - 1){
                sum = digits[i] + 1;
                remainder = sum % 10;
                carry = sum / 10;
                result[i+1] = remainder;
            }else{
                sum = digits[i] + carry;
                remainder = sum % 10;
                carry = sum / 10;
                result[i+1] = remainder;
            }
            
        }
        if(carry != 0 ){result[0] = carry;}else{
            for(int i = 1; i < len + 1; i++){
                digits[i-1] = result[i]; 
            }
            return digits;
        }
        return result;
    }
    
}
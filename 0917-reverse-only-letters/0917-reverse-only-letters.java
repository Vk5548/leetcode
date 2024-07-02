class Solution {
    public String reverseOnlyLetters(String s) {
        // char[] chars = s.toCharArray();
        // int left = 0, right = chars.length - 1;
        // while(left < right){
        //     if(!Character.isLetter(chars[left]))
        //         left++;
        //     else if(!Character.isLetter(chars[right]))
        //         right++;
        //     else{
        //         char temp = chars[left];
        //         chars[left] = chars[right];
        //         chars[right]= temp;
        //     }
        // }
        // return new String(chars);
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(c);
            }
        } // we have StringBuilder ready with just letters
        sb.reverse();
        int letterIndex = 0;
        StringBuilder newSb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                newSb.append(sb.charAt(letterIndex++));
            }
            else{
                newSb.append(c);
            }
        }
        return newSb.toString();
    }
}
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wordArr = word.toCharArray();
        char[] abbrArr = abbr.toCharArray();
        int wordLen = word.length();
        int abbrLen = abbr.length();
        int wordIdx = 0, abbrIdx = 0;

        while (abbrIdx < abbrLen && wordIdx < wordLen){
            if (Character.isDigit(abbrArr[abbrIdx])){
                if(abbrArr[abbrIdx] == '0'){
                    return false;
                }
                int num = 0;
                while (abbrIdx < abbrLen && Character.isDigit(abbrArr[abbrIdx])){
                    num = num * 10 + abbrArr[abbrIdx++] - '0';
                }
                //got the number here
                //Move the word pointer forward by the number we got
                wordIdx += num;
            }else{
                //see if we exhausted the word
                if(wordIdx >= wordLen || wordArr[wordIdx] != abbrArr[abbrIdx]){
                    return false;
                }
                wordIdx++;
                abbrIdx++;
            }
            
        }
        
        return wordIdx == wordLen && abbrIdx == abbrLen;
        
    }
}
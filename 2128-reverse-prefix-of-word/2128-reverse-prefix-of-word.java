class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        if(idx == -1)
            return word;
        StringBuilder res = new StringBuilder(word.substring(0, idx + 1));
        res.reverse();
        res.append(word.substring(idx + 1));
        return res.toString();
    }
}
class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> st = new HashSet<>();

        for(char c: sentence.toCharArray()){
            st.add(c);
        }

        return st.size() == 26;
    }
}
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // add jewels to se:
        Set<Character> st = new HashSet<>();
        for(int i = 0; i < jewels.length(); i++){
            st.add(jewels.charAt(i));
        }
        int res = 0;
        for(int i = 0; i < stones.length(); i++){
            if(st.contains(stones.charAt(i))){
                res++;
            }
        }
        return res;
    }
}
class Solution {
    public int countElements(int[] arr) {
        Set<Integer> st = new HashSet<>();
        int res = 0;
        for(int n: arr){
            st.add(n);
        }
        for(int n: arr){
            if(st.contains(n + 1))
                res++;
        }
        return res;
    }
}
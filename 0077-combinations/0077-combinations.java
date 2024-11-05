class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), n, k, 1);
        return result;
    }
    private void backtrack(List<Integer> curr, int n, int k, int i){
        if(curr.size() == k){
            result.add(new ArrayList<>(curr));
        }

        //start from i
        for(int j = i ; j <= n; j++){
            curr.add(j);
            backtrack(curr, n, k, j + 1);
            curr.remove(curr.size() - 1);
        }


    }
}
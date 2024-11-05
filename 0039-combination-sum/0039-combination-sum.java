



class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> curr){
        
        if(target == 0){
            result.add(new ArrayList<>(curr));
        }
        if(target < 0){
            return;
        }
        
        for(int i = index; i < candidates.length; i++){
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
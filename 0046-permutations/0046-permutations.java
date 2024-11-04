class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        //all combinations
        backtrack(new ArrayList<>(), nums);
        return result;
        
        
    }
    private  void backtrack(List<Integer> curr, int[] nums){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        //if not base case:
        //explore the other possibilities from i/p
        for(int num: nums){
            if(!curr.contains(num)){ // if no num, then only call to avoid duplicates
                curr.add(num);
                backtrack(curr, nums); //send the updated list
                //after it returns, we need to explore other possibility, so get rid of the last added
                curr.remove(curr.size() - 1);
            }
        }
    }
}
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        // we start from 1st index
        backtrack(0, new ArrayList<>(), nums); // start from 0th index
        return result;
    }
    private void backtrack(int i, List<Integer> curr, int[] nums){
        result.add(new ArrayList<>(curr));
        if(i >= nums.length){
            return;
        }

        
        //start the iteration from 
        for(int j = i ; j < nums.length; j++){
            curr.add(nums[j]);
            backtrack(j + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
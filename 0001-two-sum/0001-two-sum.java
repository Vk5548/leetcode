class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> check = new HashMap<>();
        // int[] complementArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            
            int complementArr = target - nums[i];  
            if(check.containsKey(complementArr)){
                if(i != check.get(complementArr))
                return new int[]{i, check.get(complementArr)};
            }
            check.put(nums[i], i);
        }
        return null;
    }
}
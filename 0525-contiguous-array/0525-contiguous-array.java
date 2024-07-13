class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        int left = 0, ans = 0, zeroC = 0, oneC = 0;
        diffMap.put(0, -1);
        for(int right = 0; right < nums.length; right++){
            if (nums[right] == 0){
                zeroC++;
            } else{
                oneC++;
            }
            if (diffMap.containsKey(zeroC - oneC)){ // it has equal number of zeroes and ones
            //between current index and the one which has same number of i'2 abd zeroes;
            //we want maximum ;ength pf the substring; hence we zre not updating the value of the already seen difference 
                ans = Math.max(ans, right - diffMap.get(zeroC-oneC));
            }else{
                diffMap.put(zeroC-oneC, right);
            }
        }
    return ans;
    }
}
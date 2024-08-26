import java.util.HashSet;
class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashSet<Integer> track = new HashSet<>();
        int[] ans = new int[]{0,0};
        for(int num : nums){
            if(track.contains(num)){
                ans[0]++;
                track.remove(num);
            }else{
                track.add(num);
            }
        }
        ans[1] = track.size();
        return ans;
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if( nums.length == 0) return new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        List<String> res = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            if(end + 1 == nums[i]){
                //update end
                end++;
            }else{
                //we got the summaryRanges
                if(start == end){
                    res.add("" + start);
                }else{
                    res.add(start + "->" + end);
                    //update for the next range
                   
                }
                 start = nums[i];
                end = nums[i];
            }
        }
        if(start == end){
            res.add("" + start);
        }else{
            res.add(start + "->" + end);
            //update for the next range
        }
        return res;
    }
}
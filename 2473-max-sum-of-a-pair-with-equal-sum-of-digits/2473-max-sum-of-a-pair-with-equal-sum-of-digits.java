import java.util.Map;
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> trackSumMap = new HashMap<>();
        int maximumSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            // get the sum of digits while getting the digits
            int num = nums[i], sumOfDigits = 0;
            while(num > 0){
                sumOfDigits += num % 10;
                num = num/10;
            }
            trackSumMap.putIfAbsent(sumOfDigits, new ArrayList<>());
            trackSumMap.get(sumOfDigits).add(nums[i]);
        }
        // for(Map.Entry<Integer, List<Integer>> entry: trackSumMap.entrySet()){
        //     Integer sum = entry.getKey();
        //     List<Integer> indexes = entry.getValue();
        //     if(indexes.size()> 1){
        //         for(int i = 0; i < indexes.size(); i++){
        //             for(int j = 0; j < indexes.size(); j++){
        //                 if (indexes.get(i) != indexes.get(j)){
        //                     int tempSum = nums[indexes.get(i)] + nums[indexes.get(j)];
        //                     maximumSum = Math.max(maximumSum, tempSum);
        //                 }
        //             }   
        //         }
        //     }
        // }
        for (List<Integer> values : trackSumMap.values()) {
            if (values.size() > 1) {
                Collections.sort(values, Collections.reverseOrder());
                maximumSum = Math.max(maximumSum, values.get(0) + values.get(1));
            }
        }
        return maximumSum == Integer.MIN_VALUE ? -1: maximumSum;
    }
}
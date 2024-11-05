class Solution {
    public int[] twoSum(int[] numbers, int target) {
       
        int low = 0, high = numbers.length - 1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum > target){
                --high;
                // while(low < high && numbers[high] == numbers[high + 1]){
                //     high--;
                // }
            }
                
            else if(sum < target){
                  ++low;
                // while(low < high && numbers[low] == numbers[low - 1]){
                //     low++;
                // }
            }
              
            
            else{
                return new int[]{low+1, high +1};
            }
                
        }
        return new int[]{-1, -1};
    }
}
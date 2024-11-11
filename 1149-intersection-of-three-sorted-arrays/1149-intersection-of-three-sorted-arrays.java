class Solution {
    Map<Integer, Integer> count = new HashMap<>(); //num : freq
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        //put the numbers of 2 arrays in the hashmap
        putInMap(arr1);
        putInMap(arr2);
        List<Integer> res = new ArrayList<>();
        for(int num: arr3){
            
            if(count.get(num) != null && count.get(num) == 2){
                res.add(num);
            }
        }
        return res;
    }

    private void putInMap(int[] nums){
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }
}
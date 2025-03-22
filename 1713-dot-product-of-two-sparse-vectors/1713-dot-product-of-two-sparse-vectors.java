import java.util.SortedMap;
import java.util.TreeMap;

class SparseVector {
    // how about we store than in hashmap: {idx: num}
    Map<Integer, Integer> nonZero = new HashMap<>();
    SparseVector(int[] nums) {
       for(int i = 0; i < nums.length; i++){
          if(nums[i] != 0){
            nonZero.put(i, nums[i]);
        }
       }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        //we iterate through the map and get the 
        int result= 0;
        // if only one of the vector is sparse, we iterate through the map who size is      smaller
        for(Integer key : nonZero.keySet()){
            if(vec.nonZero.containsKey(key)){
                result += vec.nonZero.get(key) * this.nonZero.get(key);
            }
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
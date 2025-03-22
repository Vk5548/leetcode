

import static java.util.Collections.min;

/**
nums[], k most freq elements

I: [1,2,3,2,1,4,5], k = 1 =-> O: 2,
Q : what happens in the case of ties?
Unique Ans

Q: can k = 0?
[1, # of unique elements]

A: take count array , ater getting the max elelmnt from the Nums
and inc count as soon as you arrive at the number and then 
sort the count array and return k most frequent elements(which is index)
T: O(n) + O(nlogn) : n is the number of unique elelmnst
S: O(n) ; 

A2 : take a hashmap, and store ethe frequency an dthen may use heap, based on the Frequenc
minheap, and sorting would be based on frequencu
T: O(n log k)
S: O(n) : n is teh numebr of unique Elements
 */

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> freq.get(n1) - freq.get(n2));

        for(int num: nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        // we get the Map

        for(int n: freq.keySet()){
            minHeap.offer(n);
            if( minHeap.size() > k)
                minHeap.poll();
        }
        int[] res = new int[k];
        int i = 0;
        while(minHeap.size() > 0){
            res[i++] = minHeap.poll();
        }
        return res;


    }
}
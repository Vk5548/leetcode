

import static java.lang.Math.min;


/* 
nums; k, kth largest element
kth largest elemnt in sorted order not the
 nums[size] : 10^5
heap solution: 
min-heap and maintain its size , while adding element
//at the end of the traversal, return the last element
// T: O(nlogk )+ O(logk)
S: O(k)

A2:
take the resultant array od mazimum size ofnums
-iterate through the array
-and keep increasing the freq of the array and//after the input array traversal, we can just raverse the array of freq from higher degree,
//T: O(n) + O(size of the res array)
//S: O(max-size of [nums[i]])

//HashhMAp, : num: freq
solv eit suing sorted hashmap 
*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for(int num : nums){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
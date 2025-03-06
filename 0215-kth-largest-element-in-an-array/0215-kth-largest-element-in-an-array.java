class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        //add all the elelmenst in the maxHeap
        for(int n: nums){
            maxHeap.add(n);
        }
        int i = 1;
        while(i < k){
            maxHeap.poll();
            i++;
        }
        return maxHeap.poll();

    }
}
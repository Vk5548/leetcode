class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2)-> n2 - n1);

        for(int num: nums){
            heap.add(num);
        }
        
        while(k > 1){
            heap.poll();
            k--;
        }

        return heap.poll();
        
    }
}
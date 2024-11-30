class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0, remove = 0;
        for(int pile: piles){
            pq.add(pile);
            total+= pile;
        }
        for(int i = 0; i < k; i++){
            int num = pq.poll();
            remove += num/2;
            num = Math.ceilDiv(num, 2);
            
            pq.add(num);
        }
        
        return total - remove;
    }
}
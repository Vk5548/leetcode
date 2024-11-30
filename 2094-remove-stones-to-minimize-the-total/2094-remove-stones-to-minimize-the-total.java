class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int total = 0;
        for(int pile: piles){
            pq.add(pile);
        }
        for(int i = 0; i < k; i++){
            int num = pq.poll();
            num = Math.ceilDiv(num, 2);
            pq.add(num);
        }
        while(pq.size() > 0){
            total += pq.poll();
        }
        return total;
    }
}
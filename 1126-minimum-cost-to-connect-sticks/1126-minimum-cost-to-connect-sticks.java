class Solution {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int len : sticks){
            pq.add(len);
        }
        int cost = 0;
        while(pq.size() > 1){
            int stick1 = pq.poll();
            int stick2 = pq.poll();
            int curr = stick1 + stick2;
            cost += curr;
            pq.add(curr);
        }
        return cost;
    }
}
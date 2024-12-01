class SeatManager {
    private int n;
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    public SeatManager(int n) {
        this.n = n;
        for(int i = 1; i <= n; i++){
            pq.add(i);
        }
    }
    
    public int reserve() {
        int num = pq.poll();
        return num;
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
class LRUCache {
    int capacity;
    Deque<Integer> deque = new LinkedList<>();
    Map<Integer, Integer> mp = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) { //updates thr ref count
        if( !mp.containsKey(key)) return -1; // O(1)

        deque.remove(key); //O(n)
        deque.offerFirst(key); // O(1)
        return mp.get(key); 
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){ 
           deque.remove(key); 
        }else{
            if(deque.size() == capacity){ // 1, 2, 3
                int lru = deque.pollLast();
                mp.remove(lru);
            }
        }
        mp.put(key, value);// {1;1}, {2,2}
        deque.offerFirst(key); //mru
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
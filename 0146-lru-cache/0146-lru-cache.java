class LRUCache {

    private class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // make a dummy head Node
        //so that when we need to add a Node it, we can add just after it 
        this.head = new Node(-1, -1); 
        //make a dummy tail node
        //so that when we need to delete a Node it, we can just delete the node before it 
        this.tail = new Node(-1, -1); 
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }

        //recently used 
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node == null){
            Node newNode = new Node(key, value);
            //add to the map
            map.put(key, newNode);
            addNode(newNode);

            if (map.size() > capacity) {
                Node tail = popTail();
                map.remove(tail.key);
            }
        }else {
            // If the key is present, update the value and move it to the head
            node.value = value;
            moveToHead(node);
        }
    }
    private void moveToHead(Node node){
        removeNode(node);
        addNode(node);
    }
    private void addNode(Node node){//we always add node to the start i.e just after head
        Node next = head.next;
        node.next = next;
        node.prev = head;
        next.prev = node;
        head.next = node;

    }
    private void removeNode(Node node){
        // get the prev and the next of the current node
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next; //connecting previpus to directly next
        next.prev = prev;
    }
    private Node popTail(){
        Node nodeToBeRemoved = tail.prev;
        removeNode(nodeToBeRemoved);
        return nodeToBeRemoved;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
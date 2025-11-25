class Node{
    int key,val;
    Node next,prev;
    Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=this.prev=null;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    int cap;
    Node old;
    Node lat;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
        this.old = new Node(-1,-1);
        this.lat = new Node(-1,-1);
        this.lat.next = this.old;
        this.old.prev = this.lat;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            int val = node.val;
            remove(node);
            insert(node);
            return val;
        }
        return -1;
    }


    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insert(Node node){
        node.next = lat.next;
        node.prev = lat;
        lat.next.prev = lat.next = node;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node node = new Node(key,value);
        map.put(key,node);
        insert(node);
        if (map.size() > cap) {
            Node lru = old.prev;
            remove(lru);
            map.remove(lru.key);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
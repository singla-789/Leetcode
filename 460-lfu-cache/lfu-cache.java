class Node {
    int key, val, cnt;
    Node next, prev;

    Node(int key, int val, int cnt) {
        this.key = key;
        this.val = val;
        this.cnt = cnt;
    }
}

class Dll {

    Node lat, old;

    Dll() {
        lat = new Node(-1, -1, -1);
        old = new Node(-1, -1, -1);
        lat.next = old;
        old.prev = lat;
    }

    public boolean empty() {
        return lat.next == old;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        node.next = lat.next;
        node.prev = lat;
        lat.next.prev = node;
        lat.next = node;
    }
}

class LFUCache {

    HashMap<Integer, Node> map;
    ArrayList<Dll> list;
    int cap;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        list = new ArrayList<>();
        cap = capacity;
        list.add(new Dll()); // freq 1 list
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        int c = node.cnt;

        list.get(c - 1).remove(node);
        node.cnt++;

        if (list.size() < node.cnt)
            list.add(new Dll());

        list.get(node.cnt - 1).insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (cap == 0) return;

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            get(key); 
            return;
        }

        if (map.size() >= cap) {
            int idx = 0;
            while (idx < list.size() && list.get(idx).empty()) idx++;

            Node lfu = list.get(idx).old.prev;
            list.get(idx).remove(lfu);
            map.remove(lfu.key);
        }

        Node node = new Node(key, value, 1);
        map.put(key, node);

        if (list.size() < 1)
            list.add(new Dll());

        list.get(0).insert(node);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/




class Solution {

    HashMap<Node,Node> map = new HashMap<>();

    public void dfs(Node node,Node clone){
        for(Node a : node.neighbors){
            if(!map.containsKey(a)){
                Node newClone = new Node(a.val);
                clone.neighbors.add(newClone);
                map.put(a,newClone);
                dfs(a,newClone);
            }else{
                clone.neighbors.add(map.get(a));
            }
        }
    }
    
    public Node cloneGraph(Node node) {

        if(node == null) return null;
        Node clone = new Node();
        clone.val=node.val;
        map.put(node,clone);
        dfs(node,clone);
        return clone;
    }
}
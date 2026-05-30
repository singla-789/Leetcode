class Trie {

    class Node{
        Node node[];
        boolean end;

        Node(){
            node = new Node[26];
            Arrays.fill(node,null);
            end = false;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char a : word.toCharArray()){
            if(curr.node[a-'a'] == null){
                Node newNode = new Node();
                curr.node[a-'a'] = newNode;
            }
            curr = curr.node[a-'a'];
        }
        curr.end = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char a : word.toCharArray()){
            if(curr.node[a-'a'] == null) return false;
            curr = curr.node[a-'a'];
        }
        return curr.end;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char a : prefix.toCharArray()){
            if(curr.node[a-'a'] == null) return false;
            curr = curr.node[a-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Solution {

    class Trie{
        class Node{
            Node l;
            Node r;
            boolean end;
            Node(){
                l = r = null;
                end= false;
            }
        }

        Node root;

        Trie(){ root = new Node(); }

        public void insert(int num){
            Node curr = root;
            for(int i = 31;i>=0;i--){
                int bit = (num>>i) & 1;
                if(bit==0){
                    if(curr.l==null){
                        curr.l = new Node();
                    }
                    curr = curr.l;
                }else{
                    if(curr.r == null){
                        curr.r = new Node();
                    }
                    curr = curr.r;
                }
            }
            curr.end = true;
        }

        public int max(int num){
            Node curr = root;
            int ans =0;
            for(int i = 31;i>=0;i--){
                int bit = (num>>i) & 1;
                
                if(bit==0){
                    if(curr.r!=null){
                        ans += (1<<i);
                        curr = curr.r;
                    }else{
                        curr = curr.l;
                    }
                }else{
                    if(curr.l!=null){
                        ans+=(1<<i);
                        curr = curr.l;
                    }else{
                        curr = curr.r;
                    }
                }
            }

            return ans;
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        int ans = Integer.MIN_VALUE;
        for(int n : nums){
            t.insert(n);
        }
        for(int a : nums){
            ans = Math.max(ans,t.max(a));
        }
        return ans;   
    }
}
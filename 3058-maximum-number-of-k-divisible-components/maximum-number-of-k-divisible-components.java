class Solution {
    int ans =0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(adj,values,k,0,-1);

        return ans;
    }

    public int dfs(List<List<Integer>> adj,int[] val,int k,int node, int par){
        int sum = val[node];
        for(int t : adj.get(node)){
            if(t!=par){
                sum+=dfs(adj,val,k,t,node);
            }
        }
        if(sum%k==0) ans++;
        return sum%k;
    }
}
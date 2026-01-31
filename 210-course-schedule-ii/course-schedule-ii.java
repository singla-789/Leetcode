class Solution {
    public int[] findOrder(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind = new int[n];
        for(int[] arr : edges){
            adj.get(arr[1]).add(arr[0]);
            ind[arr[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0;i<n;i++){
            if(ind[i] == 0) q.add(i);
        }

        boolean[] vis = new boolean[n];

        int[] ans = new int[n];

        int idx =0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[idx++] = curr;
            vis[curr] = true;

            for(int i : adj.get(curr)){
                if(!vis[i]){
                    ind[i]--;
                    if(ind[i] ==0) q.add(i);
                }
            }
        }

        if(idx != n) return new int[0];

        return ans;





    }
}
class pair{
    int i ;
    int w;
    pair(int i,int w){
        this.i = i;
        this.w = w;
    }
}

class Solution {
    public int cost(int[] a,int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.w - b.w);
        boolean[] vis = new boolean[n];

        int ans =0;

        pq.add(new pair(0,0));
        while(!pq.isEmpty()){
            pair p = pq.poll();

            if(!vis[p.i]){
                vis[p.i] = true;
                ans += p.w;
                for(int j =0;j<n;j++){
                    int c = cost(points[p.i],points[j]);
                    
                    pq.add(new pair(j,c));
                }
            }
        } 

        return ans;   
    }
}
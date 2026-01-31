class Dsu{
    int[] par ;
    int[] rank;

    public Dsu(int n ){
        this.par = new int[n];
        this.rank = new int[n];
        for(int i = 0;i<n;i++){
            par[i] =i;
        }
    }

    public int find(int a){
        if(a==par[a]) return a;
        return find(par[a]);
    }

    public void union(int a,int b){
        int pa = find(a);
        int pb = find(b);

        if(rank[pa] == rank[pb]){
            rank[pa]++;
            par[pb] = pa; 
        }else if(rank[pa]<rank[pb]){
            par[pa] = pb;
        }else{
            par[pb] = pa;
        }
    }



}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        Dsu dsu = new Dsu(n);

        for(int[] arr: edges){
            int a = arr[0];
            int b = arr[1];

            if(dsu.find(a) == dsu.find(b)) return arr;

            dsu.union(a,b);


        } 

        return new int[2];


    }
}
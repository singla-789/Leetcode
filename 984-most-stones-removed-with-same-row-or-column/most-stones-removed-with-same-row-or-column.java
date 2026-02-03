class DSU {
    int[] par;
    int[] rank;
    int[][] arr;

    DSU(int n, int[][] arr) {
        this.arr = arr;
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;
    }

    public int find(int a) {
        if (par[a] != a) {
            par[a] = find(par[a]);
        }
        return par[a];
    }

    public void union(int a, int b) {
        int[] p1 = arr[a];
        int[] p2 = arr[b];

        if (p1[0] != p2[0] && p1[1] != p2[1]) return;

        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            par[pa] = pb;
        } else if (rank[pb] < rank[pa]) {
            par[pb] = pa;
        } else {
            par[pb] = pa;
            rank[pa]++;
        }
        
    }
}

class Solution {

    public int removeStones(int[][] stones) {
        int n = stones.length;

        DSU dsu = new DSU(n, stones);

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dsu.union(i,j);
            }
        }

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(dsu.find(i));
        }

        return n-s.size();
    }
}
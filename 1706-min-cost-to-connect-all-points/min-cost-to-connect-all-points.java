import java.util.*;

class DSU {
    int[] par;
    int[] rank;

    DSU(int n) {
        par = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            par[i] = i;
    }

    public int find(int a) {
        if (par[a] != a)
            par[a] = find(par[a]);
        return par[a];   // ✅ FIX
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        if (rank[pa] == rank[pb]) {
            par[pb] = pa;
            rank[pa]++;
        } else if (rank[pa] < rank[pb]) {
            par[pa] = pb;
        } else {
            par[pb] = pa;
        }
        return true;
    }
}

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class Solution {

    public int cost(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);

        ArrayList<Edge> edges = new ArrayList<>();

        // Build all edges
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j, cost(points[i], points[j])));
            }
        }

        // Sort by weight
        Collections.sort(edges, (a, b) -> a.w - b.w);

        int ans = 0;
        int edgesUsed = 0;

        // Kruskal
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                ans += e.w;
                edgesUsed++;
                if (edgesUsed == n - 1) break;
            }
        }

        return ans;
    }
}

class Pair {
    int node;
    long dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    static final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] r : roads) {
            adj.get(r[0]).add(new Pair(r[1], r[2]));
            adj.get(r[1]).add(new Pair(r[0], r[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        int[] count = new int[n];
        count[0] = 1;

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;

            if (d > dist[u]) continue; 

            for (Pair next : adj.get(u)) {
                int v = next.node;
                long newDist = d + next.dist;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    count[v] = count[u];
                    pq.add(new Pair(v, newDist));
                } else if (newDist == dist[v]) {
                    count[v] = (count[v] + count[u]) % MOD;
                }
            }
        }

        return count[n - 1];
    }
}

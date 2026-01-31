import java.util.*;

class Pair {
    int node;
    int price;
    int stops;

    Pair(int node, int price, int stops) {
        this.node = node;
        this.price = price;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            
            if (curr.stops > k) continue;

            for (int[] neighbor : adj.get(curr.node)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (curr.price + weight < dist[v]) {
                    dist[v] = curr.price + weight;
                    q.add(new Pair(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
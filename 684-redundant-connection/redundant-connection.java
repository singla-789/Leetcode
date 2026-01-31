class Solution {

    HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

    private boolean dfs(int curr, int target, boolean[] vis) {
        if (curr == target) return true;

        vis[curr] = true;

        if (!adj.containsKey(curr)) return false;

        for (int nei : adj.get(curr)) {
            if (!vis[nei]) {
                if (dfs(nei, target, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {

        for (int[] arr : edges) {
            int a = arr[0];
            int b = arr[1];

            boolean[] vis = new boolean[edges.length + 1];
            if (adj.containsKey(a) && adj.containsKey(b) && dfs(a, b, vis)) {
                return arr;
            }

            adj.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        return new int[0];
    }
}

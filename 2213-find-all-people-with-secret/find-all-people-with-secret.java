class Solution {
    public List<Integer> findAllPeople(int n, int[][] meet, int fp) {
        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();

        boolean[] ks = new boolean[n];
        ks[0] = true;
        ks[fp] = true;

        for (int[] curr : meet) {
            int x = curr[0];
            int y = curr[1];
            int t = curr[2];
            map.computeIfAbsent(t, k -> new ArrayList<>()).add(new int[] { x, y });
        }

        for (int a : map.keySet()) {

            HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();

            for (int[] m : map.get(a)) {
                int x = m[0], y = m[1];
                adj.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                adj.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
            }

            Set<Integer> s = new HashSet<>();
            for (int[] curr : map.get(a)) {
                int x = curr[0];
                int y = curr[1];
                if (ks[x])
                    s.add(x);
                if (ks[y])
                    s.add(y);
            }

            Queue<Integer> q = new LinkedList<>(s);

            while (!q.isEmpty()) {
                int person = q.poll();
                for (int next : adj.get(person)) {
                    if (!ks[next]) {
                        ks[next] = true;
                        q.add(next);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ks[i])
                res.add(i);
        }
        return res;

    }
}
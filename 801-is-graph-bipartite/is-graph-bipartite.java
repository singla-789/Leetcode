class Solution {
    HashMap<Integer, Boolean> map = new HashMap<>();

    public boolean dfs(int curr,int[][] graph){
        int n = graph[curr].length;
        for(int i =0;i<n;i++){
            int next = graph[curr][i];
            if(!map.containsKey(next)){
                map.put(next,!map.get(curr));
                if(!dfs(next,graph)) return false;
            }else if(map.get(curr) == map.get(next)) return false;
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {


        for (int i = 0; i < graph.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, true);
                if(!dfs(i, graph)) return false;
            }
        }

        return true;
    }
}
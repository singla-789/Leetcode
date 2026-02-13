class TreeAncestor {
    int[][] anc;

    public void fillanc(int[][] anc){
        int n = anc.length;

        for(int i = 1; i < 30; i++){
            for(int j = 0; j < n; j++){
                int prev = anc[j][i - 1];

                if(prev == -1){
                    anc[j][i] = -1;
                } else {
                    anc[j][i] = anc[prev][i - 1];
                }
            }
        }
    }

    public TreeAncestor(int n, int[] parent) {
        anc = new int[n][30];

        for(int i = 0; i < n; i++){
            Arrays.fill(anc[i], -1);
            anc[i][0] = parent[i];
        }

        fillanc(anc);
    }

    public int getKthAncestor(int node, int k) {

        for(int i = 0; i < 30; i++){
            if(node == -1) return -1;

            if((k & (1 << i)) != 0){
                node = anc[node][i];   
            }
        }

        return node;
    }
}

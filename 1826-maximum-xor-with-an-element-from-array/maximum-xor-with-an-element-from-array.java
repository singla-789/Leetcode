class Solution {

    class Trie {

        class Node {
            Node l, r;
        }

        Node root = new Node();

        void insert(int num) {
            Node curr = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (bit == 0) {
                    if (curr.l == null)
                        curr.l = new Node();
                    curr = curr.l;
                } else {
                    if (curr.r == null)
                        curr.r = new Node();
                    curr = curr.r;
                }
            }
        }

        int getMaxXor(int num) {
            Node curr = root;

            if (curr.l == null && curr.r == null)
                return -1;

            int ans = 0;

            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;

                if (bit == 0) {
                    if (curr.r != null) {
                        ans |= (1 << i);
                        curr = curr.r;
                    } else {
                        curr = curr.l;
                    }
                } else {
                    if (curr.l != null) {
                        ans |= (1 << i);
                        curr = curr.l;
                    } else {
                        curr = curr.r;
                    }
                }
            }

            return ans;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {

        Arrays.sort(nums);

        int q = queries.length;

        int[][] offline = new int[q][3];

        for (int i = 0; i < q; i++) {
            offline[i][0] = queries[i][1]; // mi
            offline[i][1] = queries[i][0]; // xi
            offline[i][2] = i;
        }

        Arrays.sort(offline, (a, b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();
        int[] ans = new int[q];

        int idx = 0;

        for (int[] query : offline) {

            int mi = query[0];
            int xi = query[1];
            int originalIdx = query[2];

            while (idx < nums.length && nums[idx] <= mi) {
                trie.insert(nums[idx]);
                idx++;
            }

            ans[originalIdx] = trie.getMaxXor(xi);
        }

        return ans;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class pair {
        int r;
        int val;

        pair(int r, int val) {
            this.r = r;
            this.val = val;
        }
    }

    TreeMap<Integer, PriorityQueue<pair>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, 0);
        int k = 0;
        for (Map.Entry<Integer, PriorityQueue<pair>> i : map.entrySet()) {
            PriorityQueue<pair> curr = i.getValue();
            ans.add(new ArrayList<>());
            while (!curr.isEmpty()) {
                ans.get(k).add(curr.poll().val);
            }
            k++;
        }

        return ans;
    }

    public void dfs(TreeNode root, int r, int c) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(c)) {
            map.put(c, new PriorityQueue<pair>((a, b) -> {
                if (a.r != b.r)
                    return Integer.compare(a.r, b.r);
                return Integer.compare(a.val, b.val);
            }));
        }
        map.get(c).add(new pair(r, root.val));
        dfs(root.left, r + 1, c - 1);
        dfs(root.right, r + 1, c + 1);
    }
}
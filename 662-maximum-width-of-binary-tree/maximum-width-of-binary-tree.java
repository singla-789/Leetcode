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
    class info{
        TreeNode node;
        int idx;
        info(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<info> q = new LinkedList<>();
        q.add(new info(root,0));
        int ans = 0;

        while(!q.isEmpty()){
            int n = q.size();
            int start = 0;
            int end = 0;

            for(int i =0;i<n;i++){
                info curr = q.poll();
                TreeNode node = curr.node;
                int idx = curr.idx;

                if(i==0) {
                    start = idx;
                }
                if(i==n-1) end = idx;
                
                if(node.left!=null) q.add(new info(node.left,(idx*2)+1));
                if(node.right!=null) q.add(new info(node.right,(idx*2)+2));

            }
            ans = Math.max(ans,end-start+1);
        }

        return ans;

    }
}
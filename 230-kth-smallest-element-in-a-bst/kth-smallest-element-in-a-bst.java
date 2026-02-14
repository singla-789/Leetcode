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
    int idx = 0;
    public int kthSmallest(TreeNode root, int k) {
        return solv(root,k);
    }

    public int solv(TreeNode root,int k){
        if(root == null) return -1;

        int l = solv(root.left,k);
        idx++;
        if(idx==k) return root.val;
        int r = solv(root.right,k);

        if(l==-1) return r;
        return l; 

    }
}
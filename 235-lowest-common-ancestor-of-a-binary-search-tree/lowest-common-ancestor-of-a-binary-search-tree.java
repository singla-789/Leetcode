/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solv(root,p,q);
    }

    public TreeNode solv(TreeNode root,TreeNode p,TreeNode q){
        if(root == null) return null;
        if(root==p || root==q) return root;
        TreeNode l = solv(root.left,p,q);
        TreeNode r = solv(root.right,p,q);

        if(l==null) return r;
        else if(r == null) return l;

        return root;
        
    }
}
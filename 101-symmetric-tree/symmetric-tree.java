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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return help(root.left,root.right);
    }

    public boolean help(TreeNode lr,TreeNode rr){

        if(lr == null && rr==null) return true;

        if(lr == null || rr==null) return false;


        return (lr.val == rr.val) && (help(lr.right,rr.left)) && (help(lr.left,rr.right));
    }


}
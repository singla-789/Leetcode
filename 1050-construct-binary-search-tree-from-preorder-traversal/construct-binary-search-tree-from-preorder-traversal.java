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
    public TreeNode bstFromPreorder(int[] pre) {
        int n = pre.length;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(pre[0]);
        s.push(root);
        for(int i=1;i<n;i++){
            TreeNode newNode = new TreeNode(pre[i]);
            TreeNode top = s.peek();
            if(top.val>=newNode.val){
                top.left = newNode;
                
            } else {
                while(!s.isEmpty() && s.peek().val<newNode.val){
                    top = s.pop();
                }
                top.right = newNode;
            }
            s.push(newNode);
        }
        return root;
    }
}
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
    public TreeNode help(int[] pre,int[] in ,int start,int end){
        if(start>end) return null;
        int rootVal = pre[idx];
        int i =start;
        for(;i<=end;i++){
            if(in[i] == rootVal) break;
        }
        TreeNode root = new TreeNode(rootVal);
        idx++;
        root.left = help(pre,in,start,i-1);
        root.right = help(pre,in,i+1,end);

        return root;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;


        return help(preorder,inorder,0,n-1);
    }
}
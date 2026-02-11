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
    int idx;

    public TreeNode solve(int[] in,int[] post,int start,int end){

        if(start>end) return null;
        int rootVal = post[idx];
        int i = start;

        for(;i<end;i++){
            if(in[i]==rootVal) break;
        }

        idx--;

        TreeNode root = new TreeNode(rootVal);
        root.right = solve(in,post,i+1,end);
        root.left = solve(in,post,start,i-1);
        

        return root;
        
    }
    public TreeNode buildTree(int[] in, int[] post) {
        int n = post.length;
        idx = n-1;

        return solve(in,post,0,n-1);
    }
}
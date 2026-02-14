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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return solve(nums,0,n-1);
    }

    public TreeNode solve(int[] nums,int l,int r){
        if(l>r) return null;
        int m = l+(r-l)/2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = solve(nums,l,m-1);
        root.right = solve(nums,m+1,r);
        return root;
    }
}
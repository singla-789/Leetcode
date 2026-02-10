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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxL = 1;
        int maxSum = Integer.MIN_VALUE;
        int l = 1;

        while(!q.isEmpty()){
            int s = q.size();
            int sum = 0;

            for(int i =0;i<s;i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }

            if(maxSum<sum){
                maxL = l;
                maxSum = sum;
            }

            l++;
        }

        return maxL; 
    }
}
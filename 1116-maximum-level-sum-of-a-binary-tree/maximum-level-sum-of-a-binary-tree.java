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
        int ans =1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curr =1;
        int max = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int n = q.size();
            int sum = 0;

            for(int i =0;i<n;i++){
                TreeNode cn = q.poll();
                sum+=cn.val;

                if(cn.left != null){
                    q.add(cn.left);
                }
                if(cn.right != null){
                    q.add(cn.right);
                }
            }
            if(sum>max){
                max = sum;
                ans = curr;
            }
            curr++;
        }

        return ans;


    }
}
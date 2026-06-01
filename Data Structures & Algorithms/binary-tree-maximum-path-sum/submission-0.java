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
    public int maxPathSum(TreeNode root) {
        
        int[] res = {root.val};
         dfs(root, res);
         return res[0];
    }

    int dfs(TreeNode root, int[] res){

        if(root == null){
            return 0;
        }

        int l = Math.max(dfs(root.left, res), 0);
        int r = Math.max(dfs(root.right, res), 0);

        res[0] = Math.max(res[0], l+root.val+r);

        return root.val + Math.max(l, r);
    }
}

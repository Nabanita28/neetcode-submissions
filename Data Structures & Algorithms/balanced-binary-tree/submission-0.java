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
    public boolean isBalanced(TreeNode root) {
        
        return isBalancedRecur(root) >= 0;
        
    }

    int isBalancedRecur(TreeNode root){

        if(root == null){
            return 0;
        }

        int lHeight = isBalancedRecur(root.left);
        int rHeight = isBalancedRecur(root.right);

        if(lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1){
            return -1;
        }


        return 1 + Math.max(lHeight, rHeight);
    }
}

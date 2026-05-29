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

    static int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        maxDiameter = 0;
         diameterRecur(root);
         return maxDiameter;
        

    }

    int diameterRecur(TreeNode root){

        if(root == null){
            return 0;
        }

        int lHeight = diameterRecur(root.left);
        int rHeight = diameterRecur(root.right);

        maxDiameter = Math.max(maxDiameter, lHeight+rHeight);

        return 1 + Math.max(lHeight,rHeight);
    }
}

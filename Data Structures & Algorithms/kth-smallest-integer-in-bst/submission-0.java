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
    public int kthSmallest(TreeNode root, int k) {
        
        int[] tmp = new int[2];
        tmp[0] = k;
        dfs(root, tmp, k);
        return tmp[1];
    }

    void dfs(TreeNode root, int[] tmp, int k){

        if(root == null){
            return;
        }

        dfs(root.left, tmp, k);

        tmp[0] = tmp[0] - 1;

        if(tmp[0] == 0){
            tmp[1] = root.val;
            return;
        }

        dfs(root.right, tmp, k);
    }
}

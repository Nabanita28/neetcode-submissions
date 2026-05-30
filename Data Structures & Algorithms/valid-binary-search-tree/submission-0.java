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
    public boolean isValidBST(TreeNode root) {
        
        if( root == null){
            return true;
        }

        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, Integer.MIN_VALUE, Integer.MAX_VALUE});

        while(!q.isEmpty()){

            Object[] curr = q.poll();
            TreeNode node = (TreeNode)curr[0];
            int min = (int)curr[1];
            int max = (int)curr[2];

            if( !(min < node.val && node.val < max)){
                return false;
            }

            if(node.left != null){
                q.add(new Object[]{node.left, min, node.val});
            }
            if(node.right != null){
                q.add(new Object[]{node.right, node.val, max});
            }
        }
        return true;
    }
}

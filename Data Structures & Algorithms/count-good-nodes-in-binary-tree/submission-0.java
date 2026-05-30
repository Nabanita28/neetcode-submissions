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
    public int goodNodes(TreeNode root) {
        
        if( root == null){
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, Integer.MIN_VALUE));
        int count = 0;

        while(!q.isEmpty()){

                Pair<TreeNode, Integer> curr = q.poll();
                TreeNode node = curr.getKey();
                int val = curr.getVal();

                if(node.val >= val){
                    count++;
                }

                if(node.left != null){
                    q.add(new Pair<>(node.left, Math.max(val, node.val)));
                }

                if(node.right != null){
                    q.add(new Pair<>(node.right, Math.max(val, node.val)));
                }
            
        }

        return count;
    }

    static class Pair<K, V>{
        private final K key;
        private final V val;

        Pair(K key, V val){
            this.key = key;
            this.val = val;
        }

        K getKey(){
            return this.key;
        }

        V getVal(){
            return this.val;  
        }

    }
}

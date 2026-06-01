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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        //preOrder traversal

        if(root == null){
            return "N";
        }

        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(node == null){
                s.append("N,");
            } else {
                s.append(node.val).append(",");
                q.add(node.left);
                q.add(node.right);
            }
        }


    return s.toString();

        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] str = data.split(",");

        if(str[0].equals("N")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;

        while(!q.isEmpty()){

            TreeNode node = q.poll();

            if(!str[index].equals("N")){
                node.left = new TreeNode(Integer.parseInt(str[index]));
                q.add(node.left);
            }
            index++;

            if(!str[index].equals("N")){
                node.right = new TreeNode(Integer.parseInt(str[index]));
                q.add(node.right);
            }
            index++;
        }
        return root;

    }
}

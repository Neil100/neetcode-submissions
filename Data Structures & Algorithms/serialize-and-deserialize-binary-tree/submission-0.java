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
        StringBuilder builder = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int width = queue.size();
        int counter = 0;
        boolean allNull = true;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String val;
            if(node!=null) {
                val = String.valueOf(node.val);
                if(builder.isEmpty()) {
                    builder.append(val);
                } else {
                    builder.append(",").append(val);
                }

                queue.add(node.left);
                queue.add(node.right);
                if(node.left!=null || node.right!=null) {
                    allNull = false;
                }
            } else {
                val = "null";
                if(builder.isEmpty()) {
                    builder.append(val);
                } else {
                    builder.append(",").append(val);
                }
            }

            counter++;
            if(counter == width) {
                if(allNull) {
                    break;
                } else {
                    allNull = true;
                    counter = 0;
                    width = queue.size();
                }
            }
        }
        System.out.println(builder);
        return new String(builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.compareTo("null")==0)
            return null;

        String[] subStrings = data.split(",");

        for(int i=0; i<subStrings.length; i++) {
            System.out.println(subStrings[i]);
        }


        TreeNode root = new TreeNode(Integer.parseInt(subStrings[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for(int i=1; i<subStrings.length; i++) {
            TreeNode node = queue.poll();

            if(subStrings[i].compareTo("null")!=0) {
                node.left = new TreeNode(Integer.parseInt(subStrings[i]));
                queue.add(node.left);
            }
            i++;

            if(subStrings[i].compareTo("null")!=0) {
                node.right = new TreeNode(Integer.parseInt(subStrings[i]));
                queue.add(node.right);
            }
        }
        return root;
    }
}

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
    Map<Integer, Integer> heightNode;
    public List<Integer> rightSideView(TreeNode root) {
        heightNode = new HashMap<>();

        getRightSideView(root, 0);

        return new ArrayList<>(heightNode.values());
    }

    void getRightSideView(TreeNode node, int height) {
        if(node==null)
            return ;

        heightNode.put(height, node.val);

        getRightSideView(node.left, height+1);
        getRightSideView(node.right, height+1);
    }
}

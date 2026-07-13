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
    public TreeNode invertTree(TreeNode root) {
        invertNode(root);
        return root;
    }

    void invertNode(TreeNode node) {
        if(node == null) {
            return ;
        }

        TreeNode leftSide = node.left;
        node.left = node.right;
        node.right = leftSide;

        invertNode(node.left);
        invertNode(node.right);
    }
}

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

    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = Integer.MIN_VALUE;

        findDiameter(root, 0);

        return diameter;
    }

    int findDiameter(TreeNode node, int height) {

        if(node==null)
            return 0;

        int left = findDiameter(node.left, height+1);

        int right = findDiameter(node.right, height+1);

        int maxTempDistance = Integer.MIN_VALUE;

        maxTempDistance = Integer.max(height + left, height + right);
        maxTempDistance = Integer.max(maxTempDistance, left + right);

        diameter = Integer.max(diameter, maxTempDistance);
        return Integer.max(left+1, right+1);
    }
}

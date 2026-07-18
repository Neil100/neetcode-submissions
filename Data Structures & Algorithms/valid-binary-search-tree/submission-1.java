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
        return findIsValidBST(root, -1001, 1001);
    }

    boolean findIsValidBST(TreeNode root, int lowerLimit, int upperLimit) {

        if(root==null)
            return true;

        int val = root.val;
        if(val>lowerLimit && val<upperLimit) {
            return findIsValidBST(root.left, lowerLimit, val) && findIsValidBST(root.right, val, upperLimit);
        }
        return false;
    }
}

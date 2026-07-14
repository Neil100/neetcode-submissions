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
    boolean isBalance = true;
    public boolean isBalanced(TreeNode root) {
        checkBalance(root);

        return isBalance;
    }

    int checkBalance(TreeNode root) {
        if(root == null)
            return 0;

        int left = checkBalance(root.left);

        int right = checkBalance(root.right);

        int difference =  left - right;
        difference = difference<0 ? difference*(-1) : difference;

        if(difference>1)
            isBalance = false;
        return Integer.max(left, right) + 1;
    }
}

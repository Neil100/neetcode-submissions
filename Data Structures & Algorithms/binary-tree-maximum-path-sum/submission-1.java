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
    int sol = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        findMaxPathWithNode(root);
        return sol;
    }

    int findMaxPathWithNode(TreeNode node) {

        if(node==null)
            return 0;

        int val = node.val;

        int leftVal = findMaxPathWithNode(node.left);
        int rightVal = findMaxPathWithNode(node.right);

        if(leftVal + rightVal + val >= leftVal + val && leftVal + rightVal + val >= rightVal + val) {
            sol = Integer.max(sol, leftVal + rightVal + val);
        }

        if(val >= leftVal + val) {
            if(val >= rightVal + val) {
                if(val >= leftVal + rightVal + val) {
                    sol = Integer.max(sol, val);
                }
                return val;
            }
        }

        if(leftVal + val >= val) {
            if(leftVal + val >= rightVal + val) {
                if(leftVal + val >= leftVal + rightVal + val) {
                    sol = Integer.max(sol, leftVal + val);
                }
                return leftVal + val;
            }
        }

        if(rightVal + val >= val) {
            if(rightVal + val >= leftVal + val) {
                if(rightVal + val >= leftVal + rightVal + val) {
                    sol = Integer.max(sol, rightVal + val);
                }
                return rightVal + val;
            }            
        }
        return -1;
    }
}

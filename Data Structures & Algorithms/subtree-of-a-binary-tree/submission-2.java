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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root==null && subRoot==null)
            return true;

        if(root==null || subRoot==null)
            return false;
        boolean ans = false;
        if(root.val == subRoot.val) {
            ans = checkSubroot(root, subRoot);
        }
        if(!ans) {
            ans = isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        return ans;
    }

    boolean checkSubroot(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==root) {
            return true;
        }

        if(root==null || subRoot==null)
            return false;
        boolean ans = false;
        if(root.val == subRoot.val) {
            ans = checkSubroot(root.left, subRoot.left) && checkSubroot(root.right, subRoot.right);
        }

        return ans;
    }
}

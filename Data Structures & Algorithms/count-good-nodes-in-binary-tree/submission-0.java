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
        return countGoodNodes(root, -101);
    }

    int countGoodNodes(TreeNode root, int maxTillParent) {
        if(root==null)
            return 0;
        
        if(maxTillParent <= root.val) {
            return countGoodNodes(root.left, root.val) + countGoodNodes(root.right, root.val) + 1;
        }

        return countGoodNodes(root.left, maxTillParent) + countGoodNodes(root.right, maxTillParent);
    }
}

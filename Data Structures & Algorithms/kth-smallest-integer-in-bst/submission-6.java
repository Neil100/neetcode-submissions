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
    int kthSmallestNumber;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestNumber = -1;
        findNumber(root, k, 0);
        return kthSmallestNumber;
    }

    int findNumber(TreeNode root, int k, int counter) {
        if(root==null)
            return counter+1;

        counter = findNumber(root.left, k, counter);
        if(counter==k) {
            kthSmallestNumber = root.val;
            return 1001;
        }
        
        return findNumber(root.right, k, counter);

    }
}

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

    TreeNode lCA;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        lCA = null;

        findLowestCommonAncestor(root, p.val, q.val);

        System.out.println(lCA);
        return lCA;
    }

    int findLowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null)
            return 0;

        int left = findLowestCommonAncestor(root.left, p, q);
        int right = findLowestCommonAncestor(root.right, p, q);

        if(left == 3 || right == 3) {
            return 3;
        }

        int current = 0;
        if(root.val == p) {
            current = 1;
        } else if(root.val == q) {
            current = 2;
        }

        if((left==1 && right==2) || (left==2 && right==1)) {
            lCA = root;
            return 3;
        }

        if((left==1 || right==1 || left==2 || right==2) && current !=0) {
            lCA = root;
            return 3;
        }

        return Integer.max(Integer.max(left, right), current);
    }
}

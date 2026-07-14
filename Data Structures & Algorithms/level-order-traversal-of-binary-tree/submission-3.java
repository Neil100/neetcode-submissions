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

    // Map<Integer, List<Integer>> ansMap;
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     ansMap = new HashMap<>();

    //     levelOrderListCreation(root, 0);

    //     return new ArrayList<>(ansMap.values());
    // }

    // void levelOrderListCreation(TreeNode root, int height) {
    //     if(root == null)
    //         return ;

    //     List<Integer> currentList = ansMap.getOrDefault(height, new ArrayList<>());

    //     currentList.add(root.val);
    //     ansMap.put(height, currentList);
    //     levelOrderListCreation(root.left, height+1);
    //     levelOrderListCreation(root.right, height+1);
    // }


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        Map<Integer, List<Integer>> ans = new HashMap<>();

        TreeNode traversal = root;

        if(root==null) {
            return new ArrayList();
        }

        que.add(traversal);
        int currentWidth = que.size();
        int counter = 0;
        int height = 0;
        while(!que.isEmpty()) {
            
            TreeNode node = que.poll();
            List<Integer> list = ans.getOrDefault(height, new ArrayList<>());

            list.add(node.val);

            if(node.left!=null)
                que.add(node.left);
            if(node.right!=null)
                que.add(node.right);

            ans.put(height, list);
            counter++;

            if(counter == currentWidth) {
                currentWidth = que.size();
                counter=0;
                height++;
            }
        }

        return new ArrayList<>(ans.values());
    }
}

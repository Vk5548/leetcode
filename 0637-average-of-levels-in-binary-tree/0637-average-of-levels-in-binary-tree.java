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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // BFS approach to traverse each level of the tree
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            
            // Iterate over the nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                
                // Add child nodes to the queue
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Calculate the average for the current level
            double average = sum / size;
            // Round the average to five decimal places
            double roundedAverage = Math.round(average * 100000.0) / 100000.0;
            result.add(roundedAverage);
        }

        return result;
    }
}
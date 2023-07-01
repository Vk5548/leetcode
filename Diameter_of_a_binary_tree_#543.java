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
    int diameter = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        // intuition : dfs
        dfs(root);
        return diameter;
    }
    private int dfs(TreeNode node){
        if(node == null)
            return -1;
        
        int left = 1 + dfs(node.left);
        int right = 1 + dfs(node.right);
        diameter = Math.max(diameter, (left + right));
        return Math.max(left, right);
    }

}
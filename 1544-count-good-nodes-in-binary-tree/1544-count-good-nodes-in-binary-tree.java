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
        return goodNodesWithMax(root, root.val);
    }

    public int goodNodesWithMax(TreeNode node, int max){
        if(node == null){
            return 0;
        }

        if(node.val >= max){
            return 1 + goodNodesWithMax(node.right, node.val) +
                goodNodesWithMax(node.left, node.val);
        }else{
            return goodNodesWithMax(node.right, max) +
                goodNodesWithMax(node.left, max);
        }
 
    }
}
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
    public int minDepth(TreeNode root) {
        return minDepthRec(root, 1);
    }

    public int minDepthRec(TreeNode root, int depth){
        if(root == null){
            return 0;
        }
        depth++;
        int left = minDepthRec(root.left, depth);
        int right = minDepthRec(root.right, depth);
        if(left == 0 && right == 0){
            return depth - 1;
        }
        if(left == 0 || right == 0){
            return left == 0 ? right : left;
        }
        return Math.min(left, right);
    }
}
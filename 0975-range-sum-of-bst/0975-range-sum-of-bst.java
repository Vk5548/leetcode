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
    public int rangeSumBST(TreeNode root, int low, int high) {
        // not to check for null
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int ans = 0;

        while(!stk.isEmpty()){
            TreeNode node = stk.pop();

            if(node.val >= low && node.val <= high){
                ans += node.val;
            }
            if(node.val < high && node.right != null){
                stk.push(node.right);
            }
            if(node.val > low && node.left != null){
                stk.push(node.left);
            }
        }
        return ans;
    }
}
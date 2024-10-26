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
    public TreeNode searchBST(TreeNode root, int val) {
        //at least 1 node is present
        while(root != null){
            // if current root'val is qual to the required:
            if(root.val == val){
                return root;
            }
            if(val > root.val ){
                root = root.right;
            }else if(val < root.val){
                root = root.left;
            }
            
        }
        return null;
    }
}
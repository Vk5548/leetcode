/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // p and q will exist ; so not checking root == null
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        if(p.val < root.val && q.val < root.val){ //both val in left subtree
            return lowestCommonAncestor(root.left, p, q);
        }else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        } // both val in right subtree

        if(p.val < root.val || q.val < root.val){ // both on different sides
            return root;
        }
        return root;
    }
}
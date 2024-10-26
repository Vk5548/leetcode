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
    double minDiff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        return closestValueHelper(root, target, root.val);
    }

    private int closestValueHelper(TreeNode root, double target, int closest){
        if(root == null){
            return closest;
        }

        if(Math.abs(closest - target) > Math.abs(root.val - target)){
            closest = root.val;
        }else if(Math.abs(closest - target) == Math.abs(root.val - target)){
            closest = Math.min(root.val, closest);
        }

        if(target > root.val){
            return closestValueHelper(root.right, target, closest);
        }else{
            return closestValueHelper(root.left, target, closest);
        }
        
    }
}
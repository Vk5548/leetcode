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
 import java.util.*;
class Solution { 
    private int diff = 0;
    public boolean isBalanced(TreeNode root) {
        return heightDiff(root).getKey();
    }
    private Map.Entry<Boolean, Integer> heightDiff(TreeNode node){
        if(node == null)
            return new AbstractMap.SimpleEntry<>(true, 0);;
        Map.Entry<Boolean, Integer> left = heightDiff(node.left);
        Map.Entry<Boolean, Integer> right = heightDiff(node.right);
        diff = Math.abs(right.getValue() - left.getValue());
        boolean balanced = left.getKey() && right.getKey() && diff < 2;
        return new AbstractMap.SimpleEntry<>(balanced, 1+ Math.max(left.getValue(), right.getValue()));

    } 


}
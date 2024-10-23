

import static java.lang.Integer.valueOf;

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
    int prev = -1;
    int ans = Integer.MAX_VALUE;
    //perform the inorder DFS
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }

        getMinimumDifference(root.left);

        if(prev != -1){
            ans = Math.min(ans, Math.abs(root.val - prev));
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return ans;

    }
    
}
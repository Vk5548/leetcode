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

 /** 
 root : bst, low, high
 sum of all values in the  range [low, high]

 I:                 10
          8                       16
      4      9                12      18  
    3   5                  11    13 17   19
: low = 7, h = 15: 
O: 

  */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        int left = 0, right = 0;
        if(root.val > low){ // only traverse when absoulytely needed
            left = rangeSumBST(root.left, low, high);
        }
        if(root.val < high){
            right = rangeSumBST(root.right, low, high);
        }
        if(root.val >= low && root.val <= high)
            return root.val + left + right;
        return left + right;
        
    }
}
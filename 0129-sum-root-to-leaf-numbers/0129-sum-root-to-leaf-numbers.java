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

/*  
 every node :  0 to 9
 each root to leaf: is a num
 so we have to return the sum of all root-to-leaf
 

 Q: Maximum number of nodes
 Q: would the sum fit or is guranyteed to fit in 32-bit
 Q: maximum depth of the tree

 I ->      3
      4           6
    7   9     0       9
O: 347 + 349 + 360 + 369 : 1425

A1: DFS where we send the current number multiplied by 10
and if we reach leaf , we get the whole number and we add it to the result and that would be returned by the leaf

T: O(n)
S: O(max-depth)

Ec:
1. what if root is null : 0
2: what if root is only object
3. 
*/
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return root.val;
        }
        return dfs(root, 0); // root, 0
    }
    private int dfs(TreeNode node, int currNum){
        if(node.left == null && node.right == null){ 
            return currNum + node.val; 
        }

        currNum += node.val;  // 0
        int left = 0, right = 0;
        if(node.left != null)
            left = dfs(node.left, currNum * 10);  // 0

        if (node.right != null)
            right = dfs(node.right, currNum * 10); 

        return left + right;
    }

}
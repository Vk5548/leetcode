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

class Pair{
    TreeNode node;
    int currSum;
    Pair(TreeNode node, int currSum){
        this.node = node;
        this.currSum = currSum;
    }
}
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) { //base case that I forgot
            return false;
        }
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, root.val));

        while(!stk.isEmpty()){
            Pair pair = stk.pop();
            TreeNode node = pair.node;
            int currSum = pair.currSum;

            //To check if we are the leaf node
            if(node.left == null && node.right == null){ //leaf node
                if(currSum == targetSum){
                    return true;
                }else{

                }
            }else{
                if(node.right != null){
                    stk.push(new Pair(node.right, currSum + node.right.val));
                }
                if(node.left != null){
                    stk.push(new Pair(node.left, currSum + node.left.val));
                }
            }

        }
        return false;
    }
}
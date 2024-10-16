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
    TreeNode node ;
    int currMax;
    Pair(TreeNode node, int max){
        this.node = node;
        currMax = max;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        //base case
        if(root == null){
            return 0;
        }
        Stack<Pair> stk = new Stack<>();
        stk.push(new Pair(root, root.val)); //currMax that's been seen
        int ans = 0;
        while(!stk.isEmpty()){
            Pair p = stk.pop();
            TreeNode node = p.node;
            int currMax = p.currMax;
            if(node.val >= currMax){
                ans++;
            }
            currMax = node.val >= currMax ? node.val : currMax;
            if(node.right != null){
                stk.push(new Pair(node.right, node.right.val >= currMax ? node.right.val : currMax));
            }
            if(node.left != null){
                stk.push(new Pair(node.left, node.left.val >= currMax ? node.left.val : currMax));
            }
        }
        return ans;
    }
}
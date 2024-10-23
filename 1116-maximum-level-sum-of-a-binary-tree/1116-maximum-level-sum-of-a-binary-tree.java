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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int currLevel = 0;
        int minLevel = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            currLevel++;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                currSum += node.val;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            if (currSum > maxSum){ //if its greater only, then only switch the level
                minLevel = currLevel;
                maxSum = currSum;    
            }
            currSum = 0;  
        }
        return minLevel;
    }
}
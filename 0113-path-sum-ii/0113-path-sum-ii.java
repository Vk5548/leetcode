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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        // currList.add(root.val);
        helper(root, targetSum, 0, currList);
        return result;
    }

    public void helper(TreeNode node, int targetSum, int currSum, List<Integer> currList){
        if(node == null){
            return;
        }
        currSum += node.val;
        currList.add(node.val);
        if(node.left == null && node.right == null){ // It's a leaf node // no need to go further
            if(currSum == targetSum){
                result.add(new ArrayList<>(currList));// add a copy always
            }
            int temp = currList.remove(currList.size() - 1); // Rememeber how you remove it
            currSum -= temp;
            return;
        }
        helper(node.left, targetSum, currSum, currList);
        helper(node.right, targetSum, currSum, currList);
        int temp = currList.remove(currList.size() - 1);
        currSum -= temp;
        return;

    }
}
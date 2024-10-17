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
    List<Integer> res;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        res = new ArrayList<>();
        dfs(root1);
        List<Integer> rootOneList = new ArrayList<>(res);
        res = new ArrayList<>();
        dfs(root2);
        return rootOneList.equals(res);
    }
    private void dfs(TreeNode root){
        if(root.left == null && root.right == null){
            res.addLast(root.val);
            return;
        }
        if(root.left != null)
            dfs(root.left);
        if(root.right != null)
            dfs(root.right);
        return;
    }
}
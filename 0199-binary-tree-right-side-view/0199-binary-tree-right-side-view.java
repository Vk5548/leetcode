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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            int size = que.size();
            int mostRightVal = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                
                mostRightVal = node.val;
                //not storing any left child
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
                //add to the result list
                
            }
            result.add(mostRightVal);
        }
        return result;
    }
}
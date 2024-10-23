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
    public int deepestLeavesSum(TreeNode root) {
        //root is not null, EVER; so skipping the null step
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int result = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();

            for(int i =0; i< size; i++){
                TreeNode node = q.poll();
                if (node.left != null){ // if there is even a single child; flag will be true and sum won't be calcultated for this level
                    flag = true;
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                    flag = true;
                }
                if(!flag){
                    //no need to calculate the current sum since there is a next level
                    result += node.val ;
                }
            }
            if(flag){
                result = 0;
                flag = false;
            }
        }
        return result;
    }
}
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
 root
 Q ; if root is null
 Q: of just 1 root
 Q: the number of nodes


 // do a BFS
 // use a Queue 
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        
        List <Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            TreeNode last = null;
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                last = node;
            }
            //done traversing teh current level
            res.add(last.val);
        }

        return res;
    }
}
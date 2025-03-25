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

 T: 


 // do a BFS
 // use a Queue 
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){ // O(1)
            return new ArrayList<>();
        }
        
        List <Integer> res = new ArrayList<>(); //O(1)
        Queue<TreeNode> q = new LinkedList<>(); //O(199)
        q.add(root); // O(1)

        while(!q.isEmpty()){ //O(n)
            int size = q.size();

            TreeNode last = null;
            for (int i = 0; i < size; i++){ //O(size)
                TreeNode node = q.poll();
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
                if(i == size - 1)
                    last = node;
            }
            //done traversing teh current level
            res.add(last.val);
        }

        return res;
    }
}
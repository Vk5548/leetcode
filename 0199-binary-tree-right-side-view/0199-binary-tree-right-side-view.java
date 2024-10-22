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
    char pos;
    Pair(TreeNode node, char pos){
        this.node = node;
        this.pos = pos;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root, '_'));
        List<Integer> result = new ArrayList<>();
        while(!que.isEmpty()){
            int size = que.size();
            TreeNode mostRightNode = null;
            for(int i = 0; i < size; i++){
                Pair pair = que.poll();
                TreeNode node = pair.node;
                char pos = pair.pos;
                mostRightNode = node;
                //not storing any left child
                if(node.left != null){
                    que.add(new Pair(node.left, 'l'));
                }
                if(node.right != null){
                    que.add(new Pair(node.right, 'r'));
                }
                //add to the result list
                
            }
            result.add(mostRightNode.val);
        }
        return result;
    }
}
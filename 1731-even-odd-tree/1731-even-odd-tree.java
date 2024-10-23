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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean result = true;
        int level = -1;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int prevVal = -1;
            for(int i = 0; i< size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if(level %2 == 0){ // even-indexed -level
                    if(node.val % 2 == 0){
                        return false;
                    }else{ // odd-numbers check
                        if(i == 0){
                            prevVal = node.val;
                        }else{
                            if(node.val > prevVal){
                                prevVal = node.val;
                            }else{
                                return false;
                            }
                        }
                    }
                }else{ //odd-indexed level
                    if(node.val % 2 != 0){ //odd numbers not allowed
                        return false;
                    }else{ // even-numbers check
                        if(i == 0){
                            prevVal = node.val;
                        }else{
                            if(node.val < prevVal){
                                prevVal = node.val;
                            }else{
                                return false;
                            }
                        }
                    }
                }
            }

        }
        return true;
    }
}
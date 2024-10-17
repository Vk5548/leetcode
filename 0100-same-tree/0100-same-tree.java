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
    TreeNode n;
    char pos;
    Pair(TreeNode n, char pos){
        this.n = n;
        this.pos = pos;
    }
}
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //base case
        if( p == null && q == null){
            return true;
        }
        if(p == null || q== null){
            return false;
        }
        Stack<Pair> s1 = new Stack<>();
        Stack<Pair> s2 = new Stack<>();
        s1.push(new Pair(p, '_'));
        s2.push(new Pair(q, '_'));

        while(!s1.isEmpty() && !s2.isEmpty()){
            Pair p1 = s1.pop();
            Pair q1 = s2.pop();
            TreeNode pTree = p1.n;
            TreeNode qTree = q1.n;
            char posP = p1.pos;
            char posQ= q1.pos;
            

            if(posP != posQ || pTree.val != qTree.val){
                return false;
            }
            
            if(pTree.right != null && qTree.right != null){
                s1.push(new Pair(pTree.right, 'r'));
                s2.push(new Pair(qTree.right, 'r'));
            }else if (pTree.right != null || qTree.right != null) {
                return false;
            }
            if(pTree.left != null && qTree.left != null){
                s1.push(new Pair(pTree.left, 'l'));
                s2.push(new Pair(qTree.left, 'l'));
            }else if (pTree.left != null || qTree.left != null) {
                return false;
            }
        }
        return true;
    }
}
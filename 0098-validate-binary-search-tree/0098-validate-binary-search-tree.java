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
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        inorderDFS(root, lst);
        List<Integer> sortedList = new ArrayList<>(lst);
        Collections.sort(sortedList);

        for(int i = 1; i < lst.size() ; i++){
            if (lst.get(i-1) >= lst.get(i)){
                flag = false;
            }
        }
        if(!flag){
            return false;
        }
        return lst.equals(sortedList);
        
    }
    private void inorderDFS(TreeNode root, List<Integer> lst){
            if(root == null){
                return;
            }
            //left
            
            inorderDFS(root.left, lst);
            lst.add(root.val);
            inorderDFS(root.right, lst);
           
            return;
    }
}
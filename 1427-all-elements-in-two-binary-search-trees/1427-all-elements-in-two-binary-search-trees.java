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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inorderDFS(root1, list1); //sorted
        inorderDFS(root2, list2); //sorted
        int idx1 = 0, idx2 = 0;
        while(idx1 < list1.size() && idx2 < list2.size()){
            if(list1.get(idx1) > list2.get(idx2)){
                result.add(list2.get(idx2));
                idx2++;
            }else{
                result.add(list1.get(idx1));
                idx1++;
            }
        }
        while(idx1 < list1.size()){
            result.add(list1.get(idx1));
            idx1++;
        }
        while(idx2 < list2.size()){
            result.add(list2.get(idx2));
            idx2++;
        }
        return result;
    }

    private void inorderDFS(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        //call left
        inorderDFS(root.left, list);
        list.add(root.val);
        inorderDFS(root.right, list);
        return;
    }
}
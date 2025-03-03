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


import java.util.*;
class Pair{
    TreeNode node;
    int col;
    Pair(TreeNode n, int c){
        node = n;
        col = c;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, ArrayList<Integer>>  sortedMap= new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        // implement Queue
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode n = p.node;
            int col = p.col;
            //add it ot the map
            if(!sortedMap.containsKey(col)){
                sortedMap.put(col, new ArrayList<>());
            }
            sortedMap.get(col).add(n.val);
            if(n.left != null){
                q.offer(new Pair(n.left, col - 1));
            }
            if(n.right != null){
                q.offer(new Pair(n.right, col + 1));
            }
        }

        for(ArrayList<Integer> ls : sortedMap.values()){
            res.add(ls);
        }
        return res;
    }

}
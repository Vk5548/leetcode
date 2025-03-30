
import java.util.SortedMap;/**
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
 Binary Tree, vertical order verticalTraversal
 // row, col => (row +1, col - 1),( row +1, col  + 1)
 // root starts at 0, 0
 : top to bottom for each column

 Cq:
 1. what if root = null? send null
 2. what if no child, only onw root= then send the root

 A1: BFS/DFS:
 BFS, that would give me a level order tarversal-since we want, top - to botoom
 and if values exist in the same column, then we need to sort by, their values
 Mpa<Integer, List<Integer>> columnMap  {col: <>} {col : {row : value}}

 
  */
class Solution {
    private static class Trouple{ //col, row, val
        int col, row;
        TreeNode node;
        Trouple(int c, int r, TreeNode n){
            col = c;
            row = r;
            node = n;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if ( root == null ) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
    
        SortedMap<Integer, SortedMap<Integer, PriorityQueue<Integer>>> colRowMap = new TreeMap<>();
        Queue<Trouple> q = new LinkedList<>();
        q.offer(new Trouple(0, 0, root)); // col, row/level , value

        while(!q.isEmpty()){ // since it's tree, we don't need visited set
             // processing all the nodes of the current level
            Trouple t = q.poll();
            int col = t.col;
            int row = t.row;
            TreeNode node = t.node;

            colRowMap.putIfAbsent(col, new TreeMap<>());
            colRowMap.get(col).putIfAbsent(row, new PriorityQueue<>()); // min by default
            colRowMap.get(col).get(row).offer(node.val);
            if(node.left != null){
                q.offer(new Trouple(col - 1, row + 1, node.left));
            }
            if(node.right != null){
                q.offer(new Trouple(col + 1, row + 1, node.right));
            }
        } // at this point i have my sorted map

        for(SortedMap<Integer, PriorityQueue<Integer>> rowMap : colRowMap.values()){
            List<Integer> colList = new ArrayList<>();
            for(PriorityQueue<Integer> pq: rowMap.values()){
                while(! pq.isEmpty()){
                    colList.add(pq.poll());
                }    
            }
            result.add(colList);
        }
        return result;
    }
}
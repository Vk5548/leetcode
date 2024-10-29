/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parents = new HashMap<>(); //since all the integer are unique // {node : parent}
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //given the root of a Binary tree
        //since it can be from any node, I will need to keep track of all the parents
        dfs(root, null); //root's parent s null
        //after setting all the nodes' parents:
        // now we need to start from the target node which we are sure that will exits:
        //also keeping track of the node if already seen
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        seen.add(target);
        int distance = 0;

        while(!q.isEmpty() && distance < k){
            int size = q.size();
            //current size

            for(int i = 0; i < size; i++){
                //polling all nodes out from current level one by one
                TreeNode node = q.poll();

                // getting all the neighbors of the current node:
                //Since its a binary tree, there are 3 of them at any given point: 2 children and a parent
                for(TreeNode neighbor : new TreeNode[]{node.left, node.right, parents.get(node)}){
                    if(neighbor != null && !seen.contains(neighbor)){
                        q.add(neighbor); // iterating through neighbor and adding them in the queue;
                        seen.add(neighbor);
                    }
                    
                }
            }
            distance++;
        }
        List<Integer> levelK = new ArrayList<>();
        while(distance == k && !q.isEmpty()){
            levelK.add(q.poll().val);
        }
        return levelK;

    }
    private void dfs(TreeNode node, TreeNode parent){
        //doing the preorder traversal
        if(node == null){
            return;
        }
        parents.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}
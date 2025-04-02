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
String of () and integres
0 or 1 or 2 pairs of parantheses: 
integer followed by 0 or 1 or 2 pairs of parantheses: 

the integer represents the root
The input :  "4(2(3)(1))(6(5))" // recursion as soon as you encounter a parantheses
                    4
                2       6
            3      1   5

CQ: can the string be null?
1. What if starts with : () () ? is it valid input
2. can input be sure to considered without things like special carcaters or non-valid characetrs in general?
3. 

A: recursion approach, 
where I get the number make it root of the recursion
and send the substring as soon as I encounter a parantheses
T: n log (len of String)
S: O(n)

*/
class Solution {
    public TreeNode str2tree(String s) {
        if( s== "" || s == null) return null;
        int[] idx = new int[1];
        return buildTree(s, idx); // O(n)

        
    }

    private TreeNode buildTree(String s, int[] idx){
        if(idx[0] >= s.length()){
            return null;
        }
        // Read number (could be negative)
        int sign = 1;
        if (s.charAt(idx[0]) == '-') {
            sign = -1;
            idx[0]++;
        }

        int num = 0; // can only be 1 node
        while (idx[0] < s.length() && Character.isDigit(s.charAt(idx[0]))) { // O(n)
            num = num * 10 + (s.charAt(idx[0]++) - '0');
        }

        TreeNode root = new TreeNode(sign * num);

        // Parse left subtree // O( subtree size)
        if (idx[0] < s.length() && s.charAt(idx[0]) == '(') {
            idx[0]++; // skip '('
            root.left = buildTree(s, idx);
            idx[0]++; // skip ')'
        }

        // Parse right subtree
        if (idx[0] < s.length() && s.charAt(idx[0]) == '(') {
            idx[0]++; // skip '('
            root.right = buildTree(s, idx);
            idx[0]++; // skip ')'
        }

        return root;
    }
}
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode pTree = s1.pop();
            TreeNode qTree = s2.pop();

            // If the values are different, return false
            if (pTree.val != qTree.val) {
                return false;
            }

            // Check the right children: if one exists and the other doesn't, return false
            if (pTree.right != null && qTree.right != null) {
                s1.push(pTree.right);
                s2.push(qTree.right);
            } else if (pTree.right != null || qTree.right != null) {
                return false;
            }

            // Check the left children: if one exists and the other doesn't, return false
            if (pTree.left != null && qTree.left != null) {
                s1.push(pTree.left);
                s2.push(qTree.left);
            } else if (pTree.left != null || qTree.left != null) {
                return false;
            }
        }

        // If both stacks are empty, the trees are the same
        return s1.isEmpty() && s2.isEmpty();
    }
}

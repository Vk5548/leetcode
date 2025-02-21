# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class FindElements:

    def __init__(self, root: Optional[TreeNode]):
        self.values = set()
        if root:
            self._recover(root, 0)

    def _recover(self, node: TreeNode, val : int) -> None:
        if node:
            node.val = val
            self.values.add(val)
            #call left
            self._recover(node.left, 2*val + 1)
            #call right
            self._recover(node.right, 2*val + 2)

    def find(self, target: int) -> bool:
        return target in self.values


# Your FindElements object will be instantiated and called as such:
# obj = FindElements(root)
# param_1 = obj.find(target)
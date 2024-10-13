// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }
use std::rc::Rc;
use std::cell::RefCell;
impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        // match root{
        //     Some(root) => {
        //         let root = root.borrow();
        //         let left = Solution::max_depth(root.left.clone()); // No idea about the parent
        //         let right = Solution::max_depth(root.right.clone());
        //         return 1 + left.max(right); // logic for the current node; therefore, it post order traversal
        //     },
        //     None => 0,
        // }
        if root.is_none(){
            return 0;
        }

        let mut stack: Vec<(Option<Rc<RefCell<TreeNode>>>, i32)> = Vec:: new();

        let mut max_depth = 0;

        stack.push((root, 1));
        while let Some((node, depth)) = stack.pop(){
            if let Some(node_ref) = node{
                let node = node_ref.borrow();

                max_depth = max_depth.max(depth);

                if node.left.is_some(){
                    stack.push((node.left.clone(), depth + 1));
                }
                if node.right.is_some(){
                    stack.push((node.right.clone(), depth + 1));
                }
            }
        }
        max_depth
    }
}
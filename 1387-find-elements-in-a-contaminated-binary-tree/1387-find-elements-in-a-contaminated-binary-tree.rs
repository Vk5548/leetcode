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
use std::collections::HashSet;

struct FindElements {
    values: HashSet<i32>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl FindElements {

    fn new(root: Option<Rc<RefCell<TreeNode>>>) -> Self {
        //initialize the values
        let mut values = HashSet::new();
        //check if we have a tree
        if let Some(node) = root { //if there is a root
            Self::recover_tree_dfs(node, 0, &mut values);
        }
        FindElements { values }
    }

    fn recover_tree_dfs(root: Rc<RefCell<TreeNode>>, value: i32, values: &mut HashSet<i32>){
        let mut node = root.borrow_mut();
        node.val = value; //assigned the value
        values.insert(value);

        if let Some(left) = node.left.clone(){
            Self::recover_tree_dfs(left, 2*value + 1, values);
        }
        if let Some(right) = node.right.clone(){
            Self::recover_tree_dfs(right, 2*value + 2, values);
        }

    }
    
    fn find(&self, target: i32) -> bool {
        self.values.contains(&target)
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * let obj = FindElements::new(root);
 * let ret_1: bool = obj.find(target);
 */
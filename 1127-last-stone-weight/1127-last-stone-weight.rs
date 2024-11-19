use std::collections::BinaryHeap;

impl Solution {
    pub fn last_stone_weight(stones: Vec<i32>) -> i32 {
        //implements max-heap by default
        let mut heap = BinaryHeap::new();

        //adding all the elments of the array to the heap
        for &stone in stones.iter(){
            heap.push(stone);
        }
        //after adding all the stones
        while let Some(stone1) = heap.pop(){ //getting the first stone : stone1 >= stone2
            if let Some(stone2) = heap.pop(){ //if I get the second stone as well
                if stone1 != stone2{
                    heap.push(stone1 - stone2);
                }
            }else{
                return stone1;
            }
        }
        0
    }
}
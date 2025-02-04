use std::collections::BinaryHeap;
use std::cmp::Reverse;

impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        let mut min_heap : BinaryHeap<Reverse<i32>> = BinaryHeap::new();

        //iterate through the costs
        for &cost in costs.iter(){
            min_heap.push(Reverse(cost));
        }//set up

        let mut bars = 0;
        let mut coins = coins;
        while let Some(Reverse(curr)) = min_heap.pop(){
            coins -= curr;
            if coins < 0{
                break;
            }

            bars+= 1;
            
        }
        bars
    }
}
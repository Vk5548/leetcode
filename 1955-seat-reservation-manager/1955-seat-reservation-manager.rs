use std::collections::BinaryHeap;
use std::cmp::Reverse;
struct SeatManager {
    minHeap : BinaryHeap<Reverse<i32>>,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl SeatManager {

    fn new(n: i32) -> Self {
        let mut minHeap = BinaryHeap::new();
        for i in 1..=n{
            minHeap.push(Reverse(i));
        }
        SeatManager { minHeap }
    }
    
    fn reserve(&mut self) -> i32 {
        let Reverse(seat) = self.minHeap.pop().unwrap();
        seat
    }
    
    fn unreserve(&mut self, seat_number: i32) {
        self.minHeap.push(Reverse(seat_number));
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * let obj = SeatManager::new(n);
 * let ret_1: i32 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
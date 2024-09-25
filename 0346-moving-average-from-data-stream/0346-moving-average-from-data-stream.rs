use std::collections::VecDeque;
struct MovingAverage {
    size : usize,
    movingAvg : VecDeque<i32>,
    sum : i64,
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl MovingAverage {

    fn new(size: i32) -> Self {
        MovingAverage {
            size : size as usize,
            movingAvg : VecDeque::with_capacity(size as usize),
            sum : 0,
        }
    }
    
    fn next(&mut self, val: i32) -> f64 {
        self.movingAvg.push_back(val);
        self.sum += val as i64;
        if self.movingAvg.len() > self.size{
            if let Some(removed) = self.movingAvg.pop_front(){
                self.sum -= removed as i64;
            }
        }
        self.sum as f64 / self.movingAvg.len() as f64
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * let obj = MovingAverage::new(size);
 * let ret_1: f64 = obj.next(val);
 */
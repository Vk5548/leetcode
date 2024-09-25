use std::collections::VecDeque;
struct RecentCounter {
    request : VecDeque<i32>
}


/** 
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl RecentCounter {

    fn new() -> Self {
        RecentCounter {
            request : VecDeque::new(),
        }
    }
    
    fn ping(&mut self, t: i32) -> i32 {
        self.request.push_back(t);
        // Removing time stamps older than 3000
        while let Some(&val) = self.request.front(){
            if val < t- 3000 {
                self.request.pop_front();
            }else{
                break;
            }
        }
        self.request.len() as i32
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * let obj = RecentCounter::new();
 * let ret_1: i32 = obj.ping(t);
 */
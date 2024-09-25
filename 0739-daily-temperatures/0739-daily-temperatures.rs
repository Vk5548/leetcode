impl Solution {
    pub fn daily_temperatures(temperatures: Vec<i32>) -> Vec<i32> {
        let mut stk : Vec<i32> = Vec::new();
        let mut res : Vec<i32> = vec![0; temperatures.len()];
        for i in 0..temperatures.len(){
            while let Some(&prev) = stk.last(){
                if temperatures[i as usize] > temperatures[prev as usize]{
                    stk.pop();
                    res[prev as usize] = (i as i32 - prev) as i32;
                }else{
                    break;
                }
            }
            stk.push(i as i32);
        }
        res
    }
}
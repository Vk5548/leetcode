impl Solution {
    pub fn min_moves(target: i32, mut max_doubles: i32) -> i32 {
        let mut start = target;
        let mut moves = 0;

        while start > 1 && max_doubles > 0{
            if start % 2 == 0 && max_doubles > 0{
                start /= 2;
                max_doubles -= 1;
            }else{
                start -= 1;
            }
            moves+= 1;
        }
        if start > 1{
            moves += start - 1
        }
        moves
    }
}
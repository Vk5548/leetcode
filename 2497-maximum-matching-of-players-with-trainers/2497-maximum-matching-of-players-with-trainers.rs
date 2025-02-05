impl Solution {
    pub fn match_players_and_trainers(mut players: Vec<i32>, mut trainers: Vec<i32>) -> i32 {
        players.sort_unstable();
        trainers.sort_unstable();

        let mut res = 0;
        let mut p = 0;
        let mut t = 0;
        while p < players.len() && t < trainers.len(){
            if players[p] <= trainers[t]{
                p += 1;
                t += 1;
                res += 1;
            }else{
                t += 1;
            }
        }
        res
    }
}
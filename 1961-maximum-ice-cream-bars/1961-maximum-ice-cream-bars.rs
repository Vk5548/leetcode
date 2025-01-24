impl Solution {
    pub fn max_ice_cream(costs: Vec<i32>, coins: i32) -> i32 {
        let max_num = *costs.iter().max().unwrap_or(&0);

        //declare the array for this size
        let mut freq = vec![0; (max_num+ 1) as usize];

        for &c in &costs{
            freq[c as usize] += 1;
        } // got the freq array // meanin the index is the cost

        let mut remanining_coins = coins;
        let mut bars_bought = 0;

        for cost in 1..=max_num as usize{
            //how many bars are available to buy
            let num_bars = freq[cost];

            //how many bars can be bought
            let bars_can_be_bought = (remanining_coins/cost as i32).min(num_bars);

            bars_bought += bars_can_be_bought;
            remanining_coins -= bars_can_be_bought * cost as i32;

            if remanining_coins<= 0{
                break;
            }
        }
        bars_bought
    }
}
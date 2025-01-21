use std::collections::BinaryHeap;

impl Solution {
    pub fn find_maximized_capital(k: i32, w: i32, profits: Vec<i32>, capital: Vec<i32>) -> i32 {
        let mut projects: Vec<(i32, i32)> = capital.into_iter().zip(profits.into_iter()).collect(); 
        projects.sort_by(|a, b| a.0.cmp(&b.0)); 

        let mut curr_capital = w;
        let mut avail_projects = BinaryHeap::new();

        let mut i = 0;

        for _ in 0..k{
            while i < projects.len() && curr_capital >= projects[i].0{
                avail_projects.push(projects[i].1);
                i += 1;
            } 

            if let Some(profit) = avail_projects.pop() {
                curr_capital += profit;
            }
        }
        curr_capital
    }
}
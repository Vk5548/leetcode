impl Solution {
    pub fn earliest_full_bloom(plant_time: Vec<i32>, grow_time: Vec<i32>) -> i32 {
        //get the combined array
        let mut combined : Vec<Vec<i32>> = grow_time.into_iter().zip(plant_time.into_iter()).map(|(g, p)| vec![g, p]).collect();

        //get the sorted array
        combined.sort_by(|x, y| y[0].cmp(&x[0]).then(y[1].cmp(&x[1]))); //sort by growTime and then break ties using plantTime in desc

        let mut num_days = 0;
        //start planting on day 0, for first combined[0][1] days nothing else can be done

        // num_days += combined[0][1]; //first seed planted

        let n = combined.len();
        let mut current_plant = 0;
        let mut max_bloom_day = 0;

        for row in combined.iter(){
            if let [grow, plant] = row.as_slice(){
                num_days += plant;
                max_bloom_day = max_bloom_day.max(num_days + grow);
            }
        }
        max_bloom_day
    }
}
impl Solution {
    pub fn maximum_units(mut box_types: Vec<Vec<i32>>, truck_size: i32) -> i32 {
        box_types.sort_by(|a,b| b[1].cmp(&a[1]));//sorted by the frequency

        //now iterate through the box_types
        let mut num_boxes = 0;
        let mut num_units = 0;
        for i in 0..box_types.len(){
           
            if num_boxes + box_types[i][0] <= truck_size { //all boxes can be added
                num_boxes += box_types[i][0];
                num_units += box_types[i][0] * box_types[i][1];
            }else if num_boxes < truck_size{ //partial addition of boxes
                //how many boxes to add
                let balance = truck_size - num_boxes;
                num_boxes += balance;
                num_units += balance * box_types[i][1];
                break;
            }
            
        }
        num_units
    }
}
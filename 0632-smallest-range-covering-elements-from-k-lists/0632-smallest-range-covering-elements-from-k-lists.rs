impl Solution {
    pub fn smallest_range(nums: Vec<Vec<i32>>) -> Vec<i32> {
        //brute force way;
        //merge all the list in one to start with
        
        //edge cases
        if nums.is_empty() || nums.iter().any(|list| list.is_empty()){
            return vec![];
        }
        let mut one_list = vec![];
        

        //flatten the lists into (value, index) pairs
        for (index, list) in nums.iter().enumerate(){ //itearting over lists of lists
            for &num in list{ // then itearting over particular list
                one_list.push((num, index));
            }
        }

        //sorting the list based on the first value i.e the value and not the list number
        one_list.sort_unstable_by_key(|&(val, _)| val); //meaning sorted by first value in tuple

        //To have the sliding window to give the minimum smallest_range

        // let mut count_map = HashMap::new(); 

        // to see or I can use an array, so let me start with the array
        // we don't know how many lists in the list
        let num_lists = nums.len();
        let mut if_all_lists = vec![0; num_lists + 1];
        let mut left = 0;
        let mut right = 0;
        let mut unique_count = 0;
        let mut res = vec![one_list[0].0, one_list[one_list.len() - 1].0];

        while right < one_list.len(){
            let (_, idx) = one_list[right];
            if_all_lists[idx] += 1;
            if if_all_lists[idx] == 1{
                unique_count += 1;
            }

            while unique_count == num_lists{ //meaning we have at least 1 number from every list
                let curr_range = one_list[right].0 - one_list[left].0;

                if curr_range < res[1] - res[0] || (curr_range == res[1] - res[0] && one_list[left].0 < res[0]) {
                    res = vec![one_list[left].0, one_list[right].0];
                }

                //shrinking the current window from left
                let (_, left_list_idx) = one_list[left];
                if_all_lists[left_list_idx] -= 1;

                if if_all_lists[left_list_idx] == 0{
                    unique_count -= 1;
                }

                left += 1;
            }
            right += 1;
        }
        res
    }
}
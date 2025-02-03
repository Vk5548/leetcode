use std::collections::BinaryHeap;
use std::cmp::Reverse;

impl Solution {
    pub fn most_booked(n: i32, mut meetings: Vec<Vec<i32>>) -> i32 {
        //sort by start times
        meetings.sort_unstable_by(|a,b| a[0].cmp(&b[0]));

        //get the end_times heap and minHeap
        let mut end_times : BinaryHeap<Reverse<(i64, i32)>> = BinaryHeap::new();

        // available rooms:
        let mut rooms_avail : BinaryHeap<Reverse<i32>> = BinaryHeap::new();

        //result array
        let mut res : Vec<i32> = vec![0; n as usize];

        for i in 1..n{ //adding all the empty rooms
            rooms_avail.push(Reverse(i));
        }

        // Queued meetings?? I  still don't know if we will need it
        let mut queued_meetings : BinaryHeap<Reverse<i32>> = BinaryHeap::new();

        //enter the end_time of first meeting in the heap with first room available;
        end_times.push(Reverse((meetings[0][1] as i64, 0))); // the first room avail in 0 to n-1
        //update the count for room 0
        res[0] += 1;

        // to iterate through the meetings in sorted manner
        for meeting in meetings.into_iter().skip(1){
            let start = meeting[0];
            let end = meeting[1];
            let duration = end - start;

            //free up the rooms which won't be used after this start time or at this start time
           while let Some(&Reverse((end_time, room))) = end_times.peek() {
                if end_time <= start as i64 {
                    end_times.pop();
                    rooms_avail.push(Reverse(room));
                } else {
                    break;
                }
            }

            //check for an available room
            if let Some(Reverse(room)) = rooms_avail.pop(){ // if room is available
                res[room as usize] += 1;
                end_times.push(Reverse((end as i64, room))); // meeting added to ongoing
            }else{ // if rooms aren't available, get the meetings that ends at the earliest
                if let Some(Reverse((earliest_end, room))) = end_times.pop(){ // I get the meeting to end at the earliest
                    let new_end = earliest_end + duration as i64;
                    end_times.push(Reverse((new_end, room)));
                    res[room as usize] += 1;
                //add the current meeting
                }
            }
        }
        let mut max = 0;
        let mut ans = 0;
        for i in 0..n {
            if max < res[i as usize]{
                max = res[i as usize];
                ans = i;
            }
        }
        ans as i32
    }
}
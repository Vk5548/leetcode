// impl Solution {
//     pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
//         let mut i = (m - 1) as isize;
//         let mut j = (n - 1) as isize;
//         let mut k = (m + n -1) as usize;
//         while i >= 0 && j >= 0{
//             if nums1[i as usize] >= nums2[j as usize]{
//                 nums1[k] = nums1[i as usize];
//                 i -= 1;
//             }else{
//                 nums1[k] = nums2[j as usize];
//                 j -= 1;
//             }
//             k-= 1
//         }
//         while i >= 0{
//             nums1[k] = nums1[i as usize];
//             k -= 1;
//             i -= 1;
//         }
//         while j >= 0{
//             nums1[k] = nums2[j as usize];
//             k -= 1;
//             j -= 1;
//         }
//     }
// }
impl Solution {
    pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
        let m: usize = m.try_into().unwrap();
        let n: usize = n.try_into().unwrap();

        let mut nums1_ix = m.checked_sub(1);
        let mut nums2_ix = n.checked_sub(1);

        for result_ix in (0..(m + n)).rev() {
            match (nums1_ix, nums2_ix) {
                (None, None) => {}
                (None, Some(some_nums2_ix)) => {
                    nums1[result_ix] = nums2[some_nums2_ix];

                    nums2_ix = some_nums2_ix.checked_sub(1);
                }
                (Some(some_nums1_ix), None) => {
                    nums1[result_ix] = nums1[some_nums1_ix];

                    nums1_ix = some_nums1_ix.checked_sub(1);
                }
                (Some(some_nums1_ix), Some(some_nums2_ix)) => {
                    if nums1[some_nums1_ix] > nums2[some_nums2_ix] {
                        nums1[result_ix] = nums1[some_nums1_ix];

                        nums1_ix = some_nums1_ix.checked_sub(1);
                    } else {
                        nums1[result_ix] = nums2[some_nums2_ix];

                        nums2_ix = some_nums2_ix.checked_sub(1);
                    }
                }
            }
        }
    }
}
/* 
int[] : num1 and nums2
sorted in non-decreasing , meaning ,5,5,6,6,7
int m and n: # of ele 
nums1 : m + n // m are occupied
nums2 : n

CQ:
1: can nums 1 be: a size od n instead, and then we just return n 
2. can nums1 be of len m : therefroe no nums2, and return nums1
3. can both of them be empty
4. 


A1: 2 Ptr app, I start tarversing both the arrays from the end(arrays' valid end), 
and keep feeling the nums 1


*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 && nums2.length == 0){
            return;
        }

        if (nums1.length == n){
            for(int i = 0 ; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
        // if(nums2.length == 0){//we already have the ans
        //     return;
        // }
        int ptr1 = m - 1, ptr2 = n-1;
        int idx = m + n - 1;

        while(ptr2 >= 0 && ptr1 >= 0&& idx >= 0){
            if( nums2[ptr2] > nums1[ptr1] ){
                nums1[idx--] = nums2[ptr2--];
            }else{
                nums1[idx--] = nums1[ptr1--];
            }
        }
        while(ptr2 >= 0){
            nums1[idx--] = nums2[ptr2--];
        }
        // while(ptr1 >= 0){
        //     nums1[idx--] = nums1[ptr1--];
        // }

    }
}
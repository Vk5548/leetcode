class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1; // actual Index
        m--; n--;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[index--]= nums1[m--];
            }else{
                nums1[index--] = nums2[n--];
            }
        }
        // In any case only one of the following
        //conditions is gonna be true at any given point
        while(m >= 0){
            nums1[index--]= nums1[m--];
        }
        while(n >= 0){
            nums1[index--] = nums2[n--];
        }
    }
}
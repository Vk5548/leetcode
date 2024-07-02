class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        if(nums1[0] > nums2[nums2.length - 1] || nums2[0] > nums1[nums1.length - 1])
            return -1;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] > nums2[j]){
                j++;
            }
            else if(nums2[j] > nums1[i])
                i++;
            else{
                return nums1[i];
            }
        }
        return -1;
    }
}
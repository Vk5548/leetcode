class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        # Initialize indices
        nums1_ix = m - 1
        nums2_ix = n - 1
        result_ix = m + n - 1

        # Merge in reverse order
        while nums2_ix >= 0:
            if nums1_ix >= 0 and nums1[nums1_ix] > nums2[nums2_ix]:
                nums1[result_ix] = nums1[nums1_ix]
                nums1_ix -= 1
            else:
                nums1[result_ix] = nums2[nums2_ix]
                nums2_ix -= 1
            result_ix -= 1

        
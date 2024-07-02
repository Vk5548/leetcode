class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        if nums1[0] > nums2[len(nums2) - 1] or nums2[0] > nums1[len(nums1) - 1] :
            return -1
        i =j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] < nums2[j]:
                i += 1
            elif nums1[i] > nums2[j]:
                j+=1
            else:
                return nums1[i]
        return -1
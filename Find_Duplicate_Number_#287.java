class Solution {
    public int findDuplicate(int[] nums) {
        // Well main intuition of the problem is: Cycle in a linked List :
        // meaning we have the consider the values as .next for the array
        // Oth index is where the traversing will begin because its nit gonna be visisted
        // again as nums[i] belongs to [1, n]

        int length = nums.length;
        int n = length - 1; 
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        int slow2 = 0;

        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        while (slow != slow2);

        return slow2;
    }
}
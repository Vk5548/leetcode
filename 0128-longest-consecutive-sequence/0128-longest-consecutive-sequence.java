class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxRes = 0;

        for (int num : numSet) {
            // Check if `num` is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int res = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    res++;
                }

                maxRes = Math.max(maxRes, res);
            }
        }

        return maxRes;
    }
}

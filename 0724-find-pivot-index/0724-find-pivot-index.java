class Solution {
    public int pivotIndex(int[] nums) {
        ArrayList<Integer> front = new ArrayList<>();
        front.add(nums[0]);
        ArrayList<Integer> rear = new ArrayList<>();
        rear.add(nums[nums.length - 1]);
        for(int i = 1; i < nums.length; i++){
            front.add(front.get(i - 1) + nums[i]);
        }
        for(int i = nums.length - 2; i >= 0; i--){
            rear.add(0, rear.get(0) + nums[i]);
        }
        for(int i =0; i<nums.length; i++){
            if (front.get(i).equals(rear.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
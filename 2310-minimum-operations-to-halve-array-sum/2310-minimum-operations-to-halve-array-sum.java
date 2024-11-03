class Solution {
    public int halveArray(int[] nums) {
        double target = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (double num: nums) {
            target += num;
            heap.add(num);
        }
        
        target /= 2;
        int ans = 0;
        while (target > 0) {
            ans++;
            double x = heap.remove();
            target -= (x / 2);
            heap.add(x / 2);
        }
        
        return ans;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((n1, n2) -> {
           // Calculate distances and compare
            int d1 = n1[0] * n1[0] + n1[1] * n1[1];
            int d2 = n2[0] * n2[0] + n2[1] * n2[1];
            return d2 - d1; 
        }); // max-heap

        for(int[] point: points){
            heap.add(point);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(heap.size() > 0){
            res[i++] = heap.poll();
        }
        return res;
    }
}
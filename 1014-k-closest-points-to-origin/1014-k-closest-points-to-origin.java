/* 
points[[]]= points[i] = [xi, yi]
k closest to origin

CQ: what if points.length < k?, return as is?
what id points.length = 0? , k >0, : retrun an empty arr
what if n > 0, k = 0, retrun an empty arr

*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if (n < k) return points;
        if( n == 0 || k == 0) return new int[0][0];
    
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((n1, n2) -> {
            int d1 = n1[0] * n1[0] + n1[1] * n1[1];
            int d2 = n2[0] * n2[0] + n2[1] * n2[1];
            return d2 - d1;
        });

        for(int[] p : points){
            maxHeap.offer(p);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty())
            res[i++] = maxHeap.poll();


        return res;
    }
}
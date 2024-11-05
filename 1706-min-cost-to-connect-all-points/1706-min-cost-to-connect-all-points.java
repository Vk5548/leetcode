import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int totalCost = 0;
        int edgesUsed = 0;

        // Start from the first point (index 0)
        minHeap.offer(new int[]{0, 0});

        while (edgesUsed < n) {
            int[] current = minHeap.poll();
            int pointIndex = current[0];
            int cost = current[1];

            // If the point is already visited, skip it
            if (visited[pointIndex]) continue;

            // Mark this point as visited and add the cost
            visited[pointIndex] = true;
            totalCost += cost;
            edgesUsed++;

            // Check all other points to add their connection costs to the min-heap
            for (int nextIndex = 0; nextIndex < n; nextIndex++) {
                if (!visited[nextIndex]) {
                    int nextCost = Math.abs(points[pointIndex][0] - points[nextIndex][0]) +
                                   Math.abs(points[pointIndex][1] - points[nextIndex][1]);
                    minHeap.offer(new int[]{nextIndex, nextCost});
                }
            }
        }

        return totalCost;
    }
}

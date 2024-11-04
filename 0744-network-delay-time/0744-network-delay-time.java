class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[1] - n2[1]); //node, time
        //to store the graph, iterate through times
        for(int[] time: times){
            int u = time[0], v = time[1], wt = time[2];
            graph.putIfAbsent(u, new ArrayList<>()); // dest, wt
            graph.get(u).add(new int[]{v, wt}); //dest, wt
        } // graph - ready

        // we start from node k
        int[] result = new int[n+1];
        
        for(int i = 1; i < n+1; i++){
            result[i] = Integer.MAX_VALUE;
        }
        result[k] = 0;// we start from here

        //add the start node to the minHeap
        minHeap.add(new int[]{k, 0}); //to reach k from k, it takes 0 time

        while(!minHeap.isEmpty()){
            int[] entry = minHeap.poll();
            int node = entry[0];
            int time = entry[1];

            // to get the neighbors of node
            if(graph.get(node) != null){
                for(int[] neighborEntry : graph.get(node)){
                    int neighbor = neighborEntry[0];
                    int timeFromK = neighborEntry[1];
                    int newTime = time + timeFromK;
                    if(newTime < result[neighbor]){
                        result[neighbor] = newTime;
                        //add to the minHeap
                        minHeap.add(new int[]{neighbor, newTime});
                    }
                }
            }
        }

        // we traverse the result[]
        int max = result[k];
        for(int i = 1; i <= n; i++){
            if(result[i] != Integer.MAX_VALUE){
                max = Math.max(result[i], max);
            }else{
                return -1;
            }
        }
        return max;

    }
}
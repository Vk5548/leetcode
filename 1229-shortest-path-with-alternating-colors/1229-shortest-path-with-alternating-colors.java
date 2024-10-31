class Pair{
    int node;
    String color;
    Pair(int n, String c){
        node = n;
        color = c;
    }
}
class Solution {
    int n;
    String RED = "Red";
    String BLUE = "Blue";
    Map<Integer, List<Integer>> redGraph = new HashMap<>();
    Map<Integer, List<Integer>> blueGraph = new HashMap<>();
    int[] seenBlue ;
    int[] seenRed ;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // making the graph 
        //iterating through red Edges:
        this.n = n;
         // Initialize the graph for red and blue edges separately
        for (int[] edge : redEdges) {
            int a = edge[0];
            int b = edge[1];
            redGraph.putIfAbsent(a, new ArrayList<>());
            redGraph.get(a).add(b);
        }

        for (int[] edge : blueEdges) {
            int a = edge[0];
            int b = edge[1];
            blueGraph.putIfAbsent(a, new ArrayList<>());
            blueGraph.get(a).add(b);
        }
        //after making teh graph; we need to start bfs from (0, blue) and (0, red)
        seenBlue = new int[n];
        seenRed = new int[n];
        Arrays.fill(seenBlue, -1);
        Arrays.fill(seenRed, -1);
        // first from bfs(0,blue):
        bfs(0, BLUE);
        bfs(0, RED);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (seenBlue[i] == -1 && seenRed[i] == -1) {
                result[i] = -1;
            } else if (seenBlue[i] == -1) {
                result[i] = seenRed[i];
            } else if (seenRed[i] == -1) {
                result[i] = seenBlue[i];
            } else {
                result[i] = Math.min(seenBlue[i], seenRed[i]);
            }
        }
        return result;
    }
    private void bfs(int startNode, String startColor){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode, startColor));
        int level = 0;
        if (startColor.equals(RED)) {
            seenRed[startNode] = 0;
        } else {
            seenBlue[startNode] = 0;
        }

        while(!q.isEmpty()){
            int size = q.size();
            level++;

            for(int i = 0; i < size; i++){
                Pair pair = q.poll();
                int node = pair.node;
                String color = pair.color;
                String nextColor = color.equals(RED) ? BLUE : RED;
                Map<Integer, List<Integer>> nextGraph = color.equals(RED) ? blueGraph : redGraph;
                // see all its neighbors from graph
                for(int neighbor : nextGraph.getOrDefault(node, new ArrayList<>())){
                    //Question is how do I alternate between colors
                   if (nextColor.equals(RED)) {
                        if (seenRed[neighbor] == -1 || level < seenRed[neighbor]) {
                            seenRed[neighbor] = level;
                            q.add(new Pair(neighbor, RED));
                        }
                    } else {
                        if (seenBlue[neighbor] == -1 || level < seenBlue[neighbor]) {
                            seenBlue[neighbor] = level;
                            q.add(new Pair(neighbor, BLUE));
                        }
                    }
                }
            }
        }   
    }
}
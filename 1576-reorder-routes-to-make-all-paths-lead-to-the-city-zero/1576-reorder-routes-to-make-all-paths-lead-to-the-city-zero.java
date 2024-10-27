class Solution {
    Map<Integer, List<Integer>> neighbors;
    int result = 0;
    Set<String> edges;
    Set<Integer> visited;

    public int minReorder(int n, int[][] connections) {
        edges = new HashSet<>();
        neighbors = new HashMap<>();
        visited = new HashSet<>();

        // Add each directed edge to the edges set and build the undirected neighbors map
        for (int[] edge : connections) {
            int a = edge[0];
            int b = edge[1];

            // Store directed edge as "a->b"
            edges.add(a + "->" + b);

            // Add edges to neighbors for both directions to create an undirected graph
            neighbors.putIfAbsent(a, new ArrayList<>());
            neighbors.putIfAbsent(b, new ArrayList<>());
            neighbors.get(a).add(b);
            neighbors.get(b).add(a);
        }

        // Start DFS from node 0
        visited.add(0);
        dfs(0);

        return result;
    }

    private void dfs(int city) {
        for (int neighbor : neighbors.get(city)) {
            if (visited.contains(neighbor)) {
                continue;
            }

            // Check if the edge goes from city to neighbor; if it does, increment result
            if (edges.contains(city + "->" + neighbor)) {
                result++;
            }

            visited.add(neighbor);
            dfs(neighbor);
        }
    }
}

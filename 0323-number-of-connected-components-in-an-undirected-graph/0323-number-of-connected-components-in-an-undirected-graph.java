class Solution {
    int parents[];
    int rank[];
    int numComponents;
    public int countComponents(int n, int[][] edges) {
        // solving it using union-find:
        parents = new int[n];
        rank = new int[n];
        numComponents = n;
        for(int i = 0; i < n; i++){
            parents[i] = i; //each node will be its own parent initially
            rank[i] = 1; //each component is of size = 1 initially
        }
        for(int[] edge: edges){
            int p = edge[0];//parent
            int c = edge[1]; //child
            //so child's parent will change
            
            union(p, c);

        }
        return numComponents;
    }
    private void union(int parent, int child){
        int rootX = findParent(parent);
        int rootY = findParent(child);

        //if they have the same parent: do nothing
        if(rootX == rootY){
            return;
        }

        //if that's not the case:
        //merging will happen:
        numComponents--;
         // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parents[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parents[rootX] = rootY;
        } else { // rank[rootX] == rank[rootY]
            parents[rootY] = rootX;
            rank[rootX]++;
        }

    }
    private int findParent(int child){
        if(parents[child] == child) return child;
        return findParent(parents[child]);
    }
}
import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort the items based on the first element
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = items.length;
        // Step 2: Sort the queries along with their original indices
        int q = queries.length;
        int[][] sortedQueries = new int[q][2]; // [queryValue, originalIndex]
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[q];
        int maxBeauty = 0;
        int itemIndex = 0;
        
        // Step 3: Iterate through each query and update maxBeauty
        for (int i = 0; i < q; i++) {
            int currentQuery = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            // Move the itemIndex as long as items[itemIndex][0] <= currentQuery
            while (itemIndex < n && items[itemIndex][0] <= currentQuery) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex++;
            }
            
            // Assign the current maxBeauty to the result
            result[originalIndex] = maxBeauty;
        }
        
        return result;
    }
}

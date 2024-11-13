import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort the items based on the first element
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = items.length;
        // Step 2: Create the prefix maximum array
        int[] prefixMax = new int[n];
        prefixMax[0] = items[0][1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], items[i][1]);
        }
        
        int q = queries.length;
        // Step 3: Sort the queries along with their original indices
        int[][] sortedQueries = new int[q][2]; // [queryValue, originalIndex]
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[q];
        // Step 4: Process each query using binary search
        for (int i = 0; i < q; i++) {
            int currentQuery = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            
            // Binary search to find the rightmost item with items[j][0] <= currentQuery
            int left = 0;
            int right = n - 1;
            int pos = -1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= currentQuery) {
                    pos = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            
            if (pos != -1) {
                result[originalIndex] = prefixMax[pos];
            } else {
                result[originalIndex] = 0; // No valid item found
            }
        }
        
        return result;
    }
}

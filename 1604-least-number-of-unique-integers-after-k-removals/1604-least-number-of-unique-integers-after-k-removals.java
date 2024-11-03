class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Frequency map to store counts of each unique element
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap to sort elements by frequency
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Add entries to heap based on frequency
        minHeap.addAll(freq.entrySet());

        // Reduce k by removing elements with the smallest frequency
        while (k > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            int frequency = entry.getValue();
            
            if (k >= frequency) {
                k -= frequency;
                freq.remove(entry.getKey());  // Remove from map as it's fully "deleted"
            } else {
                break;
            }
        }

        // The remaining number of unique keys is the result
        return freq.size();
    }
}

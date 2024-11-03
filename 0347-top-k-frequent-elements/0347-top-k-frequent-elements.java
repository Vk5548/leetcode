class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>(); // freq -> Number from nums or for now Number -> freq
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get)); // will store the freq of elements
        // PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> freqMap.get(n1) - freqMap.get(n2));

        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1); // remember getOrDefault
        } // got the Map

        //add to the heap; itearting through the keys
        for(int num: freqMap.keySet()){
            heap.add(num);

            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while (heap.size()!= 0) {
            res[i++] = heap.poll();
        }

        return res;
        
    }
}
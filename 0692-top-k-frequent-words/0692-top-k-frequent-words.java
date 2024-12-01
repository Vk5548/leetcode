class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> maxHeap = new PriorityQueue<>((n1, n2) -> {
            int count1 = freq.get(n1);
            int count2 = freq.get(n2);

            if(count1 == count2){
                return n1.compareTo(n2);
            }
            return count2 - count1;
        });
        for(String str: words){
            freq.put(str, freq.getOrDefault(str, 0) + 1);    
        }
        // for(String str: words){
        //     maxHeap.add(str);    
        // }
        maxHeap.addAll(freq.keySet());
        List<String> res = new ArrayList<>();
        while(k > 0){
            res.add(maxHeap.poll());
            k--;
        }
        return res;
    }
}
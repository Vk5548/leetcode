class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Map<Integer, Integer> diffMap = new HashMap<>(); // arr[i] -> | x - arr[i]|;
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> {
            if(Math.abs(n1 - x) == Math.abs(n2-x)){
                return n2 - n1;
            }

            return Math.abs(n2-x) - Math.abs(n1 -x);
        });//got the heap declaration; don't even need the map here

        for(int num: arr){
            heap.add(num);
            if(heap.size() > k){
                heap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < k ; i++){
            ans.add(heap.poll());
        }

        Collections.sort(ans);
        return ans;

        
    }
}
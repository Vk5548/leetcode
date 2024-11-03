class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : stones){
            q.add(i);
        }

        while(q.size() > 1){
            int max = q.remove();
            int secondMax = q.remove();

            if(max != secondMax){
                q.add(max - secondMax);
            }
        }

        return q.isEmpty() ? 0 : q.remove();
    }
}
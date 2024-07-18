class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> valIndexMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i < cards.length; i++){
            if(valIndexMap.containsKey(cards[i])){
                min = Math.min(min, i - valIndexMap.get(cards[i]) + 1);
            }
            valIndexMap.put(cards[i], i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
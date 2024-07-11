class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> loss = new HashMap();
        for(int[] stat : matches){
            loss.put(stat[1], loss.getOrDefault(stat[1], 0) + 1);
            loss.putIfAbsent(stat[0], 0); // remember this
        }
        List<Integer> zeroLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry: loss.entrySet()){
            if (entry.getValue() == 0)
                zeroLosses.add(entry.getKey());
            if(entry.getValue() == 1)
                oneLoss.add(entry.getKey());
        }
        // Sort the lists
        zeroLosses.sort(null); //and this
        oneLoss.sort(null);

        // Return the result
        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLosses);
        result.add(oneLoss);

        return result;
    }
}
/* 
intervals : [starti, endi]
//merge overlapping intervals
non-overlapping intervals

Input: [[1,5], [4,5],[3,8], [5,9], [2,3]]
O: [[1,8], [8,9]]

Q: do we start from 0, or the minimum  start value in the interavl
2: 
T: O(logn) # of intervals
S: O(n)

i : [[1,2], [2,3]] //overlapping? Yes

*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if( intervals.length == 0 )
            return new int[0][0];
        List<int[]> res = new ArrayList<>();
        //sort
        Arrays.sort(intervals, (n1, n2) -> Integer.compare(n1[0], n2[0]));
        int[] lastInterval = intervals[0];
        res.add(lastInterval);

        for(int i = 1; i < intervals.length; i++){
            //check for overlapping
            int startNew = intervals[i][0];
            int endNew = intervals[i][1];

            int startOld = lastInterval[0];
            int endOld = lastInterval[1];
            if(  startNew <= endOld){
                //merge
                lastInterval[1] = Math.max(endNew, endOld);
            }else{
                lastInterval = new int[]{startNew, endNew};
                res.add(lastInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
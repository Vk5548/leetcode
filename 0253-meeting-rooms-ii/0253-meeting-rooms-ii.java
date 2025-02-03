class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        int s= 0, e= 0, count = 0, res = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        while(s < n){
            if(start[s] < end[e]){ //start is greater than end
                count++;
                s++;
            }else{
                count--;
                e++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
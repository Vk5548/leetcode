class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 0;
        int right = 10000000;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if (check(mid, dist, hour)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    private boolean check(int speed, int[] dist, double hour){
       // calculate hours
       //and always start at the ineteger
       double time = 0.0;
       int n = dist.length;
       for (int i = 0; i < n - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time+= (double) dist[n - 1] / speed;
        return time <= hour;
    }
}
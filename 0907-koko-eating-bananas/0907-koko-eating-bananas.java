class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //sort the imput?
        int left = 1; // the minimum # of bnanas she can eat 
        int right = 1; // the max number she can eat; that has to be the maximum in the answer
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        // So, what's different here is we are running binary search, not on our array but our solution space
        // which is between 1 and right
        while(left < right){
            int mid = left + (right - left)/2;
            //check for mid if its possible
            int hours = 0;
            for(int pile: piles){
                hours += Math.ceil((double)pile / mid);
            }
            if(hours > h){ //meaning not possible, answer has to be greatre than mid
                left = mid + 1;
            }else{
                right = mid ;
            }
        }
        return left;

    }
}
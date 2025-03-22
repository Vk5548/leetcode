
/**
// a stream of integers, and a window size, 
calculate the moving avg of all integers in the sliding Window

- size : windowSize, return the moving avg of last size values of teh Stream

CQ: what would be the max size:?
In the sum / windowSize: , would sum > Integr.Max(32-bit)
How many calls will be made

Edge cases: 
1: window size 0, we return 0?
2: how do you want me to handle when the current avlue sin the stream is < windows Size

T: O(n): 
 */
class MovingAverage {
    int windowSize;
    Queue<Integer> stream;
    double runningSum = 0; // maybe we would not need this
    public MovingAverage(int size) {
        windowSize = size;
        stream = new LinkedList<>();
    }
    
    public double next(int val) {
        runningSum += val;
        double denominator = 1;
        stream.offer(val);
        if(stream.size() > windowSize){
            runningSum -= stream.poll(); //remove form the front of the queue
        }
        return runningSum / stream.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
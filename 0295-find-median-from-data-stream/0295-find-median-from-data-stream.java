import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    private PriorityQueue<Integer> leftHalf; // Max heap for the left half
    private PriorityQueue<Integer> rightHalf; // Min heap for the right half

    public MedianFinder() {
        leftHalf = new PriorityQueue<>(Collections.reverseOrder());
        rightHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to leftHalf first
        leftHalf.offer(num);

        rightHalf.add(leftHalf.remove());
        if(rightHalf.size() > leftHalf.size()){
            leftHalf.add(rightHalf.remove());
        }
    }

    public double findMedian() {
        if (leftHalf.size() > rightHalf.size()) {
            return leftHalf.peek();
        } 
        return (leftHalf.peek() + rightHalf.peek()) / 2.0;
    }
}

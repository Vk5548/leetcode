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

        // Step 2: Balance by moving the largest from leftHalf to rightHalf if needed
        if (!leftHalf.isEmpty() && !rightHalf.isEmpty() && leftHalf.peek() > rightHalf.peek()) {
            rightHalf.offer(leftHalf.poll());
        }

        // Step 3: Ensure leftHalf has at most one more element than rightHalf
        if (leftHalf.size() > rightHalf.size() + 1) {
            rightHalf.offer(leftHalf.poll());
        } else if (rightHalf.size() > leftHalf.size()) {
            leftHalf.offer(rightHalf.poll());
        }
    }

    public double findMedian() {
        if (leftHalf.size() > rightHalf.size()) {
            return leftHalf.peek();
        } else {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        }
    }
}

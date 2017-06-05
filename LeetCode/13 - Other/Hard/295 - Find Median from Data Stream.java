/**
 *
 * 295. Find Median from Data Stream
 *    Median is the middle value in an ordered integer list. If the size of the list is
 *    even, there is no middle value. So the median is the mean of the two middle value.
 *
 *    Examples:
 *    [2,3,4] , the median is 3
 *
 *    [2,3], the median is (2 + 3) / 2 = 2.5
 *
 *    Design a data structure that supports the following two operations:
 *
 *    void addNum(int num) - Add a integer number from the data stream to the data
 *    structure.
 *    double findMedian() - Return the median of all elements so far.
 *    For example:
 *
 *    addNum(1)
 *    addNum(2)
 *    findMedian() -> 1.5
 *    addNum(3)
 *    findMedian() -> 2
 *
 */

import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num > left.peek()) {
            right.add(num);
        } else {
            left.add(num);
        }
        while (left.size() < right.size()) {
            left.add(right.remove());
        }
        while (left.size() - 1 > right.size()) {
            right.add(left.remove());
        }
    }

    public double findMedian() {
        return left.size() == right.size() ? (0.0 + left.peek() + right.peek()) / 2 : 0.0 + left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
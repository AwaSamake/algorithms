/**
 *
 * 480. Sliding Window Median
 *    Median is the middle value in an ordered integer list. If the size of the list is
 *    even, there is no middle value. So the median is the mean of the two middle value.
 *
 *    Examples:
 *    [2,3,4] , the median is 3
 *
 *    [2,3], the median is (2 + 3) / 2 = 2.5
 *
 *    Given an array nums, there is a sliding window of size k which is moving from the
 *    very left of the array to the very right. You can only see the k numbers in the
 *    window. Each time the sliding window moves right by one position. Your job is to
 *    output the median array for each window in the original array.
 *
 *    For example,
 *    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 *    Window position                Median
 *    ---------------               -----
 *    [1  3  -1] -3  5  3  6  7       1
 *     1 [3  -1  -3] 5  3  6  7       -1
 *     1  3 [-1  -3  5] 3  6  7       -1
 *     1  3  -1 [-3  5  3] 6  7       3
 *     1  3  -1  -3 [5  3  6] 7       5
 *     1  3  -1  -3  5 [3  6  7]      6
 *    Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 *
 */

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length < k) {
            return new double[0];
        }
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> right = new PriorityQueue<Integer> (k);
        PriorityQueue<Integer> left = new PriorityQueue<Integer> (k, Collections.reverseOrder());

        for (int i = 0; i < k - 1; ++i) {
            add(right, left, nums[i]);
        }

        for (int i = k - 1; i < nums.length; ++i) {
            add(right, left, nums[i]);
            double median = getMedian(right, left);
            result[i - k + 1] = median;
            remove(right, left, nums[i - k + 1]);
        }
        return result;
    }

    private double getMedian(PriorityQueue<Integer> right, PriorityQueue<Integer> left) {
        if (left.isEmpty() && right.isEmpty()) {
            return 0;
        }
        while (left.size() < right.size()) {
            left.add(right.poll());
        }
        while (left.size() - right.size() > 1) {
            right.add(left.poll());
        }
        if (left.size() == right.size()) {
            double sum = left.peek() * 1.0 + right.peek();
            return sum / 2.0;
        }
        return left.peek();
    }

    private void add(PriorityQueue<Integer> right, PriorityQueue<Integer> left, int num) {
        if (left.isEmpty() && right.isEmpty()) {
            left.add(num);
            return;
        } else {
            if (num <= getMedian(right, left)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
    }

    private void remove(PriorityQueue<Integer> right, PriorityQueue<Integer> left, int num) {
        if (num <= getMedian(right, left)) {
            left.remove(num);
        } else {
            right.remove(num);
        }
    }
}